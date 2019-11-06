package models.parser;

import entity.enums.SkinType;
import entity.parser.SkinParser;
import org.junit.Assert;
import org.junit.Test;

public class SkinParserTest {

    @Test
    public void testParseNatural() {
        String strSkin = "NaturaL";

        SkinType skinType = SkinParser.parseStrToSkinType(strSkin);

        Assert.assertEquals(SkinType.NATURAL, skinType);
    }

    @Test
    public void testParseArtificial() {
        String strSkin = "ARTificial";

        SkinType skinType = SkinParser.parseStrToSkinType(strSkin);

        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }

    @Test
    public void testParseWrongType() {
        String strSkin = "any";

        SkinType skinType = SkinParser.parseStrToSkinType(strSkin);

        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }
}
