package models;

import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DBConnection connection;

    public ProductDAO(DBConnection connection) {
        this.connection = connection;
    }

    public Product getById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                return new Product(idProduct, name, price);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL SELECT");
        }
        return null;
    }

    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try {
            Statement statement = this.connection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                Product product = new Product(idProduct, name, price);
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi câu lệnh SQL");
        }

        return products;
    }

    public void save(Product product) {

        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";

        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL Insert Into");
        }

    }

    public void deleteById(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL DELETE");
        }
    }
}
