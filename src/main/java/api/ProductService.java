package api;

import entity.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;
    Optional<Product> getProductByProductName(String productName) throws IOException;
    Optional<Product> getProductById(Long productId) throws IOException;

    boolean isProductExist(String productName);

    boolean saveProduct(Product product);
    void removeProduct(String productName) throws Exception;
}
