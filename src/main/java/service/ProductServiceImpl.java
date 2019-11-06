package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();


    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Optional<Product> getProductByProductName(String productName) throws IOException {
        return getAllProducts().stream()
                .filter(product -> productName.equals(product.getProductName()))
                .findFirst();
    }

    public Optional<Product> getProductById(Long productId) throws IOException {
        return getAllProducts().stream()
                .filter(product -> productId.equals(product.getId()))
                .findFirst();
    }

    public boolean isProductExist(String productName) {
        Optional<Product> product = Optional.empty();
        try {
            product = getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return product.isPresent();
    }

    public boolean saveProduct(Product product) {
        try {
            if(productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeProduct(String productName) throws Exception {
        productDao.removeProductByName(productName);
    }
}
