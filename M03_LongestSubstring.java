package Weekly_Homework;


import java.util.Arrays;

public class M03_LongestSubstring {
	
	// Iteration method
    public int lengthOfLongestSubstring(String s) {
        Boolean[] check = new Boolean[127];
        Arrays.fill(check, false);
        //int first = 0;
        //int last = 0;
        int maxLength = 0;
        int pointer = 0; // Indicate the first char of current substring
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            // Not repeatitive, lengthen the substring
            if (!check[ch]) {
                check[ch] = true;
                currentLength++;
            }
            // Repeatitive
            else {
                // Check if the current substring is the longest one
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    //first = pointer;
                    //last = i - 1;
                }
                // Reset the check array and the pointer
                for (int j = pointer; j < i; j++) {
                	int ch2 = s.charAt(j);
                    if (ch2 == ch) {
                        pointer = j + 1;
                        break;
                    }
                    else {
                        check[ch2] = false;
                        currentLength--;
                    }
                }
            }
        }
        
        if (currentLength > maxLength) {
            maxLength = currentLength;
            //first = 0;
            //last = s.length() - 1;
        }
        
        //System.out.println(first + " " + last);
        //System.out.println(s.substring(first, last + 1));
        return maxLength;
    }
    
    
    // Recursion method
    public int lengthOfLongestSubstring2(String s) {
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
    	String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    	//System.out.println(s.charAt(0)-1);
    	M03_LongestSubstring solution = new M03_LongestSubstring();
    	System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
