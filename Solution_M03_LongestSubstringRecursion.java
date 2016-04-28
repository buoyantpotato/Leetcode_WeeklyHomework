package Weekly_Homework;

public class Solution_M03_LongestSubstringRecursion {
	
	public Solution_M03_LongestSubstringRecursion() {
		
	}
	
    public int lengthOfLongestSubstring(String s) {
        Boolean[] check = new Boolean[127];
        for (int i = 0; i < check.length; i++) {
        	check[i] = false;
        }
        int maxLength = 0;
        return longestSubstringSolver(maxLength, 0, s, check, 0);
    }
    
    private int longestSubstringSolver(int maxLength, int currentLength, String sourceString, 
    									Boolean[] checkArray, int pointer) {
    	
    	if (sourceString.equals("") || pointer >= sourceString.length()) return maxLength;
    	
    	if (!checkArray[sourceString.charAt(pointer)]) {
			checkArray[sourceString.charAt(pointer)] = true;
			
			if (currentLength >= maxLength) {
				return longestSubstringSolver(currentLength + 1, currentLength + 1, sourceString, checkArray, pointer + 1);
			}
			else {
				return longestSubstringSolver(maxLength, currentLength + 1, sourceString, checkArray, pointer + 1);
			}
		}
    	
    	else {
    		int newLength = currentLength;
    		int newHead = 0;
    		for (int i = 0; i < pointer; i++) {
    			if (sourceString.charAt(pointer) != sourceString.charAt(i)) {
    				checkArray[i] = false;
    				newLength--;
    			}
    			else {
    				newHead = i + 1;
    				break;
    			}
    		}
    		
    		return longestSubstringSolver(maxLength, newLength, sourceString.substring(newHead), checkArray, pointer + 1 - newHead);
    	}
	}

	public static void main(String[] args) {
    	String s = "abcdefg";
    	//System.out.println(s.charAt(0)-1);
    	Solution_M03_LongestSubstringRecursion solution = new Solution_M03_LongestSubstringRecursion();
    	System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
