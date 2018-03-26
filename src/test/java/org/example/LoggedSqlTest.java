package org.example;

import java.util.List;

import org.avaje.agentloader.AgentLoader;
import io.ebeantest.LoggedSql;
import org.example.domain.MyBean;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.ebean.Ebean;

public class LoggedSqlTest {

  protected static Logger logger = LoggerFactory.getLogger(LoggedSqlTest.class);
  
  static {
    logger.debug("... preStart");
    if (!AgentLoader.loadAgentFromClasspath("ebean-agent","debug=1;packages=org.example.**")) {
      logger.info("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
    }    
  }
  @Test
  public void test() {

    MyBean bean = new MyBean();
    bean.setName("hello");
    bean.save();
    
    Assert.assertNotNull(bean.getId());
    
    LoggedSql.start();
    
    MyBean fetched = Ebean.find(MyBean.class, bean.getId());
    Assert.assertNotNull(fetched);
    
    List<String> loggedSql = LoggedSql.stop();
    Assert.assertEquals(1, loggedSql.size());
    Assert.assertTrue(loggedSql.get(0).contains("select t0.id, t0.name from my_bean t0 where t0.id = ?"));
  }
  
}
