package models;

import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private DBConnection connection;

    public CustomerDAO(DBConnection connection) {
        this.connection = connection;
    }

    public List<Customer> getCustomers() {

        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id, name FROM customers";

        try {
            Statement statement = this.connection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString(2);

                Customer customer = new Customer(id, name);
                customers.add(customer);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi câu lệnh SQL");
        }

        return customers;
    }

    public void save(String customerName) {

        String sql = "INSERT INTO customers (name) VALUES (?)";

        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setString(1, customerName);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL Insert Into");
        }

    }

    public void deleteById(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL DELETE");
        }
    }
}
