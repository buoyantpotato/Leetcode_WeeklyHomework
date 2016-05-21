package Weekly_Homework;

import java.util.HashMap;
import java.util.Map;

public class M12_IntToRoman {

	//**From Teacher**
	// HashMap
	private static final Map<Character, Integer> ROMAN_TO_INTEGER_MAPPING = new HashMap<>();

    static {
        ROMAN_TO_INTEGER_MAPPING.put('I', 1);
        ROMAN_TO_INTEGER_MAPPING.put('V', 5);
        ROMAN_TO_INTEGER_MAPPING.put('X', 10);
        ROMAN_TO_INTEGER_MAPPING.put('L', 50);
        ROMAN_TO_INTEGER_MAPPING.put('C', 100);
        ROMAN_TO_INTEGER_MAPPING.put('D', 500);
        ROMAN_TO_INTEGER_MAPPING.put('M', 1000);
    }

    public int romanToInt(String s) {
        int prev = 0, total = 0;
        for (char c : s.toCharArray()) {
            int curr = ROMAN_TO_INTEGER_MAPPING.get(c);
            total += (curr > prev) ? (curr - 2 * prev) : curr;
            prev = curr;
        }
        return total;
    }
}
