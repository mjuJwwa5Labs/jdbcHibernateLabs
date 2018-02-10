package sda.order.asserts;

import org.junit.Assert;
import sda.order.entity.Customer;
import sda.order.entity.CustomerType;

public class CustomerAssert {

    private Customer customer;

    public CustomerAssert(Customer customer) {
        this.customer = customer;
    }

    public CustomerAssert hasFirstName(String firstName) {
        Assert.assertEquals("First name should be equal ", firstName ,customer.getFirstName());
        return this;
    }

    public CustomerAssert hasLastName(String lastName) {
        Assert.assertEquals("Last name should be equal ", lastName, customer.getLastName());
        return this;
    }

    public CustomerAssert hasLogin(String login) {
        Assert.assertEquals("Login should be equal ", login, customer.getLogin());
        return this;
    }

    public CustomerAssert hasType(CustomerType customerType) {
        Assert.assertEquals("Login should be equal ", customerType, customer.getCustomerType());
        return this;
    }
}
