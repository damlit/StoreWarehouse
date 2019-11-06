package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final String fileName = "products.data";
    private static ProductDao instance = null;

    private ProductDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        products.forEach(product -> printWriter.write(product.toString() + "\n"));
        printWriter.close();
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        products.stream()
                .filter(product -> productName.equals(product.getProductName()))
                .findFirst()
                .ifPresent(products::remove);

        saveProducts(products);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            ProductParser.stringToProduct(readLine)
                    .ifPresent(products::add);
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        return products;
    }
}
