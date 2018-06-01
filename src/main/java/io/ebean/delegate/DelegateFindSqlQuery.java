package io.ebean.delegate;

import io.ebean.EbeanServer;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import io.ebean.Transaction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Wraps an underlying EbeanServer.
 * <p>
 * Can you used for testing purposes when you want to create a test double that
 * only replaces some of the underlying functionality of the EbeanServer.
 */
public class DelegateFindSqlQuery implements InterceptFindSqlQuery {

  protected EbeanServer delegate;

  /**
   * Construct with a EbeanServer to delegate to by default.
   * <p>
   * This delegate will be used on all method calls that are not overwritten.
   */
  public DelegateFindSqlQuery(EbeanServer delegate) {
    this.delegate = delegate;
  }

  @Override
  public List<SqlRow> findList(SqlQuery query, Transaction transaction) {
    return delegate.findList(query, transaction);
  }

  @Override
  public SqlRow findOne(SqlQuery query, Transaction transaction) {
    return delegate.findOne(query, transaction);
  }

  @Override
  public void findEach(SqlQuery sqlQuery, Consumer<SqlRow> consumer, Transaction transaction) {
    delegate.findEach(sqlQuery, consumer, transaction);
  }

  @Override
  public void findEachWhile(SqlQuery sqlQuery, Predicate<SqlRow> consumer, Transaction transaction) {
    delegate.findEachWhile(sqlQuery, consumer, transaction);
  }
}
