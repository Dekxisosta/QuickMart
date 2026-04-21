package service;

import java.util.HashMap;
import java.util.Map;

public class BarcodeService {
    private static int idCounter = 1;
    private static final Map<String, String> CATEGORY_CONFIG = new HashMap<>();

    static {
        CATEGORY_CONFIG.put("beverages", "01");
        CATEGORY_CONFIG.put("snacks", "02");
        CATEGORY_CONFIG.put("meals", "03");
        CATEGORY_CONFIG.put("canned", "04");
        CATEGORY_CONFIG.put("bakery", "05");
    }

    public static String generate(String category) {
        String countryCode = "480";
        String catCode = getCategoryCode(category);
        String itemCode = String.format("%07d", idCounter++);

        String base = countryCode + catCode + itemCode;
        return base + calculateCheckDigit(base);
    }

    private static String getCategoryCode(String category) {
        String code = CATEGORY_CONFIG.get(category.toLowerCase());
        return (code != null) ? code : "00";
    }

    private static int calculateCheckDigit(String code) {
        int sum = 0;
        for (int i = 0; i < code.length(); i++) {
            int digit = Character.getNumericValue(code.charAt(i));
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += digit * 3;
            }
        }
        int mod = sum % 10;
        return (mod == 0) ? 0 : 10 - mod;
    }
}