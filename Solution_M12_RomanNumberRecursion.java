

public class Solution_M12_RomanNumberRecursion {
	
	public Solution_M12_RomanNumberRecursion() {
		
	}
	
    public String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String roman = "";

        return intToRomanSolver(roman, num, numbers, letters, 0);
    }
    
    private String intToRomanSolver(String result, int sourceNum, int[] numbers, 
    							String[] letters, int index) {
		if (sourceNum == 0) {
			return result;
		}
		
    	int n = sourceNum / numbers[index];
		if (n != 0) {
			for (int i = 0; i < n; i++) {
				result += letters[index];
			}
		}
		return intToRomanSolver(result, sourceNum % numbers[index], numbers, letters, index + 1);
	}
    
    public static void main(String[] args) {
    	int num = 3999;
    	Solution_M12_RomanNumberRecursion sl = new Solution_M12_RomanNumberRecursion();
    	System.out.println(sl.intToRoman(num));
    }
}