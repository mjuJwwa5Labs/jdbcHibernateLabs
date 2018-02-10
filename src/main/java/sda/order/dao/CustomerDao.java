package sda.order.dao;

import sda.oder.entity.Customer;

public interface CustomerDao {

    public Customer findById(Integer id);

    public void instert(Customer customer);

    public void update(Customer customer);

    public void delete(Integer id);
}
