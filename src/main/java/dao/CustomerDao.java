package dao;

import model.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDao {

    public static List<Customer> getCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getConnnection();
        String query = "select * from customer";
//        BeanListHandler<Customer> customerBeanListHandler = new BeanListHandler<>(Customer.class);
        CustomerHandler customerBeanListHandler = new CustomerHandler(connection);
        QueryRunner queryRunner = new QueryRunner();
        List<Customer> customerList = queryRunner.query(connection, query, customerBeanListHandler);
        connection.close();
        return customerList;
    }

    public static int insertCustomers(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getConnnection();
        QueryRunner queryRunner = new QueryRunner();
        ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();

        String insertString = "INSERT INTO customer (firstName, lastName, middleName) VALUES (?, ?, ?)";
        String customerIdQuery = "SELECT id FROM customer WHERE firstName = ? AND lastName = ? AND middleName = ?";
        queryRunner.update(connection, insertString, customer.getFirstName(), customer.getLastName(), customer.getMiddleName());
        Integer customerId = queryRunner.query(connection, customerIdQuery, scalarHandler, customer.getFirstName(), customer.getLastName(), customer.getMiddleName());
        ContactDao.insertContact(customer.getContactList(), customerId);
        return 0;
    }

}
