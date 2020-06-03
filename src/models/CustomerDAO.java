package models;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static CustomerDAO instance;
    List<Customer> customers = new ArrayList<>();

    private CustomerDAO() {
        customers.add(new Customer("Huân"));
        customers.add(new Customer("Đông"));
        customers.add(new Customer("Đoàn"));
        customers.add(new Customer("Khuê"));
    }

    public static CustomerDAO getInstance() {

        if (instance == null) {
            instance = new CustomerDAO();
        }

        return instance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void save(String customerName) {
        Customer customer = new Customer(customerName);
        customers.add(customer);
    }

    public void deleteById(int id) {
        if (id >= 0 && id < customers.size() && customers.get(id) != null) {
            customers.remove(id);
        } else {
            throw new RuntimeException("Không tồn tại khách hàng có id là " + id);
        }
    }
}
