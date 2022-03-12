/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import Product.ManagerProduct;
import Product.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AD
 */
public class ProductService {
    private ManagerProduct ManagerProduct;
    public ProductService(){
        ManagerProduct = new ManagerProduct();
    }
    public List<Product> getAllProducts(String UserName) throws SQLException{
        return ManagerProduct.getAllProducts(UserName);
    }
    public void addProduct(Product product) throws SQLException{
        ManagerProduct.addProduct(product);
    }
    public void deleteProduct(String userName, int id) throws SQLException{
        ManagerProduct.deleteProduct(userName, id);
    }
    public Product getProductById(String userName, int id) throws SQLException{
        return ManagerProduct.getProductById(userName, id);
    }
    public void updateProduct(Product product) throws SQLException{
        ManagerProduct.updateProduct(product);
    }
//    public Product findProduct(Product product) throws SQLException{
//        return ManagerProduct.findProduct(product);
//    }
}
