package entity.parser;

import entity.enums.Material;

public class MaterialParser {

    public static Material parseStrToMaterial(String str) {
        String material = str.toUpperCase();

        switch (material) {
            case "LEATHER":
                return Material.LEATHER;
            case "FUR":
                return Material.FUR;
            case "COTTON":
                return Material.COTTON;
            case "WOOL":
                return Material.WOOL;
        }
        return Material.POLYESTERS;
    }
}
