package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

    private final static ProductFacade instance = new ProductFacadeImpl();
    private final ProductService productService = ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {
    }

    public static ProductFacade getInstance() {
        return ProductFacadeImpl.instance;
    }

    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "Create product " + product;
    }

    public String removeProduct(String productName) {
        try {
            productService.removeProduct(productName);
            return "Removed product";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
