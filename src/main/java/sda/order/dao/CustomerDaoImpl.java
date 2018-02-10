package sda.order.dao;

import sda.order.entity.Customer;
import sda.order.entity.CustomerType;
import sda.order.exceptions.DatabaseException;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    public static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/order?useSSL=false&serverTimezone=UTC&user=root&password=M@rek";

    @Override
    public Customer findById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING);
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, login, `type` from customer where id = ?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer customerId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String login = resultSet.getString("login");
                String customerType = resultSet.getString("type");
                CustomerType customerTypeEnum = CustomerType.valueOf(customerType);
                customer = new Customer(customerId, login, firstName, lastName, customerTypeEnum);
            }
        }
        catch (SQLException e) {
            System.out.println("Error while connecting to db: " + e.getMessage());
        } finally {
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection with db: " + e.getMessage());
                }
            }
            if (preparedStatement!=null) {
                if (preparedStatement!=null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        System.out.println("Error while closing connection with db: " + e.getMessage());
                    }
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection with db: " + e.getMessage());
                }
            }
            return customer;
        }

    }

    @Override
    public void insert(Customer customer) {

    }

    @Override
    public void update(Customer customer) throws DatabaseException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING);
            preparedStatement = connection.prepareStatement("update order.customer SET first_name = ?, last_name = ?, " +
                    "login = ?, `type`=? where id = ?");

            preparedStatement.setString(1,customer.getFirstName());
            preparedStatement.setString(2,customer.getLastName());
            preparedStatement.setString(3,customer.getLogin());
            preparedStatement.setString(4,customer.getCustomerType().name());
            preparedStatement.setInt(5,customer.getId());

            int updatedRows = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new DatabaseException("Problem while customer update " + customer.getId(), e);
        } finally {
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection with db: " + e.getMessage());
                }
            }
            if (preparedStatement!=null) {
                if (preparedStatement!=null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        System.out.println("Error while closing connection with db: " + e.getMessage());
                    }
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection with db: " + e.getMessage());
                }
            }
        }

    }

    @Override
    public void delete(Integer id) {

    }
}
