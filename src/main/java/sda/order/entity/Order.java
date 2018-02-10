package sda.order.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private Customer customer;
    private OrderStatus orderStatus;
    private Date date;
    private List<OrderItem> items;

}
