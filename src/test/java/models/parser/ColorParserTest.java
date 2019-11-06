package models.parser;

import entity.enums.Color;
import entity.parser.ColorParser;
import org.junit.Assert;
import org.junit.Test;


public class ColorParserTest {

    @Test
    public void testParseColorRed() {
        String strColor = "REd";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.RED, color);
    }

    @Test
    public void testParseColorBlue() {
        String strColor = "BLue";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.BLUE, color);
    }

    @Test
    public void testParseColorGreen() {
        String strColor = "GREEn";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.GREEN, color);
    }

    @Test
    public void testParseColorYellow() {
        String strColor = "YELLow";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.YELLOW, color);
    }

    @Test
    public void testParseColorBlack() {
        String strColor = "BLACK";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.BLACK, color);
    }

    @Test
    public void testParseColorWhite() {
        String strColor = "WHite";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.WHITE, color);
    }


    @Test
    public void testParseWrongColor() {
        String strColor = "fst";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.WHITE, color);
    }
}
