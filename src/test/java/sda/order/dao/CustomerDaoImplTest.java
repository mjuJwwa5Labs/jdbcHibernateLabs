package sda.order.dao;

import org.junit.Test;
import sda.order.entity.Customer;
import sda.order.entity.CustomerType;
import sda.order.asserts.CustomerAssert;
import sda.order.exceptions.DatabaseException;

public class CustomerDaoImplTest {

    @Test
    public void findById() {
        //given
        CustomerDao customerDao =  new CustomerDaoImpl();

        //when
        Customer customer = customerDao.findById(1);

        //then
        new CustomerAssert(customer)
                .hasFirstName("piesek")
                .hasLastName("leszek")
                .hasLogin("piesekleszek")
                .hasType(CustomerType.REGULAR);
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() throws DatabaseException {
        //given
        CustomerDao customerDao =  new CustomerDaoImpl();
        Customer customer = customerDao.findById(6);
        customer.changeCustomerType(CustomerType.VIP);

        //when
        customerDao.update(customer);

        //then
        Customer customerUpdated = customerDao.findById(6);
        new CustomerAssert(customerUpdated)
                .hasType(CustomerType.VIP)
                .hasFirstName("Robert")
                .hasLastName("Lewandowski")
                .hasLogin("robertlewandowski");
    }

    @Test
    public void delete() {
    }
}