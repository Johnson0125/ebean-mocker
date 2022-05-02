package org.example.domain;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyBean extends Model {

  public static final MyBeanFinder OTHER = new MyBeanFinder();

  @Id
  Long id;

  String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
