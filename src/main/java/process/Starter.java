package process;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CustomerDao;
import dao.MysqlConnection;
import model.Customer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//        List<Customer> customers = CustomerDao.getCustomers();

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(new File("src/main/resources/sample-customer.json"), Customer.class);
        System.out.println(customer);
        int i = CustomerDao.insertCustomers(customer);
        System.out.println(i);
    }
}
