/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import Account.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AD
 */
public class ManagerProduct {
    public List<Product> getAllProducts(String UserName) throws SQLException {
        List<Product> products = new ArrayList<Product>();

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from product where userName = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("idProduct"));
                product.setName(rs.getString("nameProduct"));
                product.setAmount(rs.getInt("amount"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public Product getProductById(String userName, int id) throws SQLException {

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from product where idProduct = ? and userName = ?";
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product.setId(rs.getInt("idProduct"));
                product.setName(rs.getString("nameProduct"));
                product.setAmount(rs.getInt("amount"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public void addProduct(Product product) throws SQLException {
        Connection connection =  ConnectDatabase.getConnectionDatabase();
        String sql = "Insert into product(nameProduct, amount, userName)"
                + "Values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getAmount());
            preparedStatement.setString(3, product.getUserName());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct(Product product) throws SQLException{
        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "Update product set nameProduct = ?, amount = ? Where idProduct = ? and userName = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getAmount());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.setString(4, product.getUserName());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(String userName, int id) throws SQLException{
       Connection connection = ConnectDatabase.getConnectionDatabase();
       String sql = "delete from product where idProduct = ? and userName = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, userName);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public Product findProduct(Product product) throws SQLException {
//        List<Product> listProduct = new ArrayList<>();
//        listProduct = getAllProducts();
//        for (Product s : listProduct) {
//            if (product.getName().equals(s.getName())) {
//                return s;
//            }
//        }
//        return null;
//    }
}
