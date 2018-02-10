package sda.order.dao;

import sda.order.entity.Customer;
import sda.order.exceptions.DatabaseException;

public interface CustomerDao {

    public Customer findById(Integer id);

    public void insert(Customer customer);

    public void update(Customer customer) throws DatabaseException;

    public void delete(Integer id);
}
