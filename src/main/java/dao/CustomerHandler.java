package dao;

import model.Contact;
import model.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerHandler extends BeanListHandler<Customer> {
    private Connection connection;

    public CustomerHandler(Connection con) {
        super(Customer.class);
        this.connection = con;
    }

    @Override
    public List<Customer> handle(ResultSet rs) throws SQLException {
        List<Customer> customers = super.handle(rs);

        QueryRunner runner = new QueryRunner();
        BeanListHandler<Contact> handler = new BeanListHandler<>(Contact.class);
        String query = "SELECT * FROM Contact WHERE customerId = ?";

        for (Customer customer : customers) {
            List<Contact> contacts
                    = runner.query(connection, query, handler, customer.getId());
            customer.setContactsList(contacts);
        }
        return customers;
    }
}
