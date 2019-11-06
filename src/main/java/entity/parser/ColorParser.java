package entity.parser;

import entity.enums.Color;

public class ColorParser {

    public static Color parseStrToColor(String str) {
        String color = str.toUpperCase();

        switch (color) {
            case "RED":
                return Color.RED;
            case "BLUE":
                return Color.BLUE;
            case "BLACK":
                return Color.BLACK;
            case "YELLOW":
                return Color.YELLOW;
            case "GREEN":
                return Color.GREEN;
        }
        return Color.WHITE;
    }
}
