package models.parser;

import entity.enums.Material;
import entity.parser.MaterialParser;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {

    @Test
    public void testParseLeather() {
        String strMaterial = "leather";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.LEATHER, material);
    }

    @Test
    public void testParseFur() {
        String strMaterial = "FUr";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void testParseCotton() {
        String strMaterial = "CottON";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.COTTON, material);
    }

    @Test
    public void testParseWool() {
        String strMaterial = "wOOL";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void testParsePolyesters() {
        String strMaterial = "Polyesters";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.POLYESTERS, material);
    }

    @Test
    public void testParseWrongMaterial() {
        String strMaterial = "any";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.POLYESTERS, material);
    }
}
