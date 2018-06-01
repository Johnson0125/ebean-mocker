package io.ebean.delegate;

import io.ebean.EbeanServer;
import io.ebean.FutureIds;
import io.ebean.FutureList;
import io.ebean.FutureRowCount;
import io.ebean.PagedList;
import io.ebean.Query;
import io.ebean.QueryIterator;
import io.ebean.Transaction;
import io.ebean.Version;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Wraps an underlying EbeanServer.
 * <p>
 * Can you used for testing purposes when you want to create a test double that
 * only replaces some of the underlying functionality of the EbeanServer.
 */
public class DelegateFind implements InterceptFind {

  protected EbeanServer delegate;

  /**
   * Construct with a EbeanServer to delegate to by default.
   * <p>
   * This delegate will be used on all method calls that are not overwritten.
   */
  public DelegateFind(EbeanServer delegate) {
    this.delegate = delegate;
  }

  @Override
  public void refresh(Object bean) {
    delegate.refresh(bean);
  }

  @Override
  public void refreshMany(Object bean, String propertyName) {
    delegate.refreshMany(bean, propertyName);
  }

  @Override
  public <T> T findOne(Query<T> query, Transaction transaction) {
    return delegate.findOne(query, transaction);
  }

  @Override
  public <T> T find(Class<T> beanType, Object id, Transaction transaction) {
    return delegate.find(beanType, id, transaction);
  }

  @Override
  public <T> int findCount(Query<T> query, Transaction transaction) {
    return delegate.findCount(query, transaction);
  }

  @Override
  public <A> List<A> findIds(Query<?> query, Transaction transaction) {
    return delegate.findIds(query, transaction);
  }

  @Override
  public <A> List<A> findSingleAttributeList(Query<?> query, Transaction transaction) {
    return delegate.findSingleAttributeList(query, transaction);
  }

  @Override
  public <T> QueryIterator<T> findIterate(Query<T> query, Transaction transaction) {
    return delegate.findIterate(query, transaction);
  }

  @Override
  public <T> void findEach(Query<T> query, Consumer<T> consumer, Transaction transaction) {
    delegate.findEach(query, consumer, transaction);
  }

  @Override
  public <T> void findEachWhile(Query<T> query, Predicate<T> consumer, Transaction transaction) {
    delegate.findEachWhile(query, consumer, transaction);
  }

  @Override
  public <T> List<T> findList(Query<T> query, Transaction transaction) {
    return delegate.findList(query, transaction);
  }

  @Override
  public <T> FutureRowCount<T> findFutureCount(Query<T> query, Transaction transaction) {
    return delegate.findFutureCount(query, transaction);
  }

  @Override
  public <T> FutureIds<T> findFutureIds(Query<T> query, Transaction transaction) {
    return delegate.findFutureIds(query, transaction);
  }

  @Override
  public <T> FutureList<T> findFutureList(Query<T> query, Transaction transaction) {
    return delegate.findFutureList(query, transaction);
  }

  @Override
  public <T> PagedList<T> findPagedList(Query<T> query, Transaction transaction) {
    return delegate.findPagedList(query, transaction);
  }

  @Override
  public <T> Set<T> findSet(Query<T> query, Transaction transaction) {
    return delegate.findSet(query, transaction);
  }

  @Override
  public <K, T> Map<K, T> findMap(Query<T> query, Transaction transaction) {
    return delegate.findMap(query, transaction);
  }

  @Override
  public <T> List<Version<T>> findVersions(Query<T> query, Transaction transaction) {
    return delegate.findVersions(query, transaction);
  }
}
