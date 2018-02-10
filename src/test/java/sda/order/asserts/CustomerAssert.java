package sda.order.asserts;

import org.junit.Assert;
import sda.oder.entity.Customer;

public class CustomerAssert {

    private Customer customer;

    public CustomerAssert hasFirstName(String firstName) {
        Assert.assertEquals("First name should be equal ",customer.getFirstName(), );
    }

}
