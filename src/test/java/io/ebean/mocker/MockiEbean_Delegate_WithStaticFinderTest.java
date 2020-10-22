package io.ebean.mocker;

import io.ebean.MockiEbean;
import org.example.domain.Customer;
import org.example.domain.CustomerFinder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MockiEbean_Delegate_WithStaticFinderTest extends BaseTest {

  final Customer foo = new Customer(42L, "foo");
  final Customer baz = new Customer(99L, "baz");

  @Test
  public void test() {

    DelegateEbeanServer mock = new DelegateEbeanServer();

    mock.withFinder(Customer.class).as(new TDCustomerFinder());

    MockiEbean.runWithMock(mock, () -> {

      Customer found = Customer.find.byUniqueName("foo");
      assertThat(found).isSameAs(foo);
    });

  }

  /**
   * Local test double.
   */
  class TDCustomerFinder extends CustomerFinder {

    @Override
    public Customer byUniqueName(String name) {
      return foo;
    }
  }

}