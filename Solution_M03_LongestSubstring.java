

import java.util.Arrays;

public class Solution_M03_LongestSubstring {
	
	public Solution_M03_LongestSubstring() {
		
	}
	
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
            //System.out.println("Never R");
        }
        
        //System.out.println(first + " " + last);
        //System.out.println(s.substring(first, last + 1));
        return maxLength;
    }
    
    public static void main(String[] args) {
    	String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    	//System.out.println(s.charAt(0)-1);
    	Solution_M03_LongestSubstring solution = new Solution_M03_LongestSubstring();
    	System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
