package exception;

public class ProductPriceNoPositiveException extends Exception {

    public ProductPriceNoPositiveException(String msg) {
        super(msg);
    }
}
