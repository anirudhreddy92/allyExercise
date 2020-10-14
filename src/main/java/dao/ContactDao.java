package dao;

import model.Contact;
import model.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ContactDao {

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

    public static int insertContact(List<Contact> contacts, Integer customerId) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getConnnection();
        QueryRunner queryRunner = new QueryRunner();

        String insertString = "INSERT INTO contact (customerId, isPrimaryContact, phoneNumber, secondaryPhoneNumber, homeAddress, zip, state ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        contacts.forEach(contact -> {
            try {
                queryRunner.update(connection, insertString, customerId , contact.getPrimaryContact(), contact.getPhoneNumber(), contact.getSecondaryPhoneNumber(), contact.getHomeAddress(),
                        contact.getZip(), contact.getState());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        return 0;

    }
}
