package sda.order.entity;

public class Customer {

    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private CustomerType customerType;
    private Address address;

    public Customer(Integer id, String login, String firstName, String lastName, CustomerType customerType) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Address getAddress() {
        return address;
    }

    public void changeCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
