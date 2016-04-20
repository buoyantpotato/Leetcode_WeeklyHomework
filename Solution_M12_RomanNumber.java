

public class Solution_M12_RomanNumber {
	
	public Solution_M12_RomanNumber() {
		
	}
	
    public String intToRoman(int num) {
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letter = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String roman = "";
        int i = 0;
        while (num != 0) {
            int n = 0;
            n = num / number[i];
            num = num % number[i];
            
            for (int j = 0; j < n; j++) {
                roman += letter[i];
            }
            
            i++;
        }
        
        return roman;
    }
    
    public static void main(String[] args) {
    	int num = 3999;
    	Solution_M12_RomanNumber sl = new Solution_M12_RomanNumber();
    	System.out.println(sl.intToRoman(num));
    }
}