package process;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = (Customer) objectMapper.readValue(new File("src/main/resources/sample-customer.json"), Customer.class);
        System.out.println(customer);
    }
}
