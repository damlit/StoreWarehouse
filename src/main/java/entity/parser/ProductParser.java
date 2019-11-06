package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

import java.util.Optional;

public class ProductParser {

    private static final String PRODUCT_SEPARATOR = ProductSeparators.PRODUCT_SEPARATOR.toString();

    public static Optional<Product> stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0,1));

        if(productType == null) {
            return Optional.empty();
        }
        switch (productType) {
            case PRODUCT_ID:
                return Optional.of(convertToProduct(productStr));

            case CLOTH_ID:
                return Optional.of(convertToCloth(productStr));

            case BOOTS_ID:
                return Optional.of(convertToBoots(productStr));
        }
        return Optional.empty();
    }

    private static Product convertToProduct(String productStr) {
        String [] productInformations = productStr.split(PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Cloth convertToCloth(String productStr) {
        String [] productInformations = productStr.split(PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        Material material = MaterialParser.parseStrToMaterial(productInformations[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Boots convertToBoots(String productStr) {
        String [] productInformations = productStr.split(PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        SkinType skinType = SkinParser.parseStrToSkinType(productInformations[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }
}
