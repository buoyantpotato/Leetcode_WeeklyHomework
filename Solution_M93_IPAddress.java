package Weekly_Homework;


import java.util.ArrayList;
import java.util.List;

public class Solution_M93_IPAddress {
    public List<String> restoreIpAddresses(String s) {
        
    	List<String> ans = new ArrayList<String>();
        
        for (int i = 1; i < 4; i++) {
            if (!isGood(s, 0, i)) break;
            
            for (int j = i+1; j < i+4; j++) {
                if (!isGood(s, i, j)) break;
                
                for (int k = j + 1; k < j+4; k++ ) {
                    if (!isGood(s, j, k)) break;
                    if (!isGood(s, k, (s.length()))) continue;
                    
                    String str = s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k) 
                                    + "." + s.substring(k, s.length());
                    ans.add(str);
                }
            }
        }
        
        return ans;
    }
   
    private boolean isGood(String s, int a, int b) {
        if (a > s.length() - 1 || b > s.length()) return false;
        if (a >= b) return false;
        if (b - a > 3) return false;
        int n = Integer.parseInt(s.substring(a, b));
        if (n > 255) return false;
        if (n < 10 && (b - a) > 1) return false;
        if (n < 100 && (b - a) > 2) return false;
        return true;
    }
    
    // Recursion method
    public List<String> restoreIpAddresses2(String s) {
        
    	List<String> answers = new ArrayList<String>();
        
    	ipAddressSolver(answers, s, "", 0);
        
        return answers;
    }
    
    private void ipAddressSolver(List<String> answers, String s, String oneAnswer,
    							int countSeperator) {
		//System.out.println(oneAnswer + " " + countSeperator + " " + s);
    	if (countSeperator == 3) {
    		if (isGood2(s, 0, s.length())) {
    			oneAnswer += "." + s.substring(0, s.length());
    			answers.add(oneAnswer);
    			return;
    		}
    		else return;
    	}
    	
    	for (int i = 1; i < 4; i++) {
    		if (i < s.length() && isGood2(s, 0, i)) {
    			
    			String newSubString;
    			if (countSeperator == 0) {
    				newSubString = s.substring(0, i);
    			}
    			else {
    				newSubString = "." + s.substring(0, i);
    			}
    			
    			oneAnswer += newSubString;
    			ipAddressSolver(answers, s.substring(i), oneAnswer, countSeperator + 1);
    			oneAnswer = oneAnswer.substring(0, oneAnswer.length() - newSubString.length());
    		}
    		else return;
    	}
		
	}

	private boolean isGood2(String s, int a, int b) {
		if (b - a > 3) return false;
        int n = Integer.parseInt(s.substring(a, b));
        if (n > 255) return false;
        if (n < 10 && (b - a) > 1) return false;
        if (n < 100 && (b - a) > 2) return false;
        return true;
    }
    
    public static void main(String[] args) {
    	String ip = "027924";
    	Solution_M93_IPAddress sl = new Solution_M93_IPAddress();
    	System.out.println(sl.restoreIpAddresses(ip));
    	System.out.println(sl.restoreIpAddresses(ip).size());
    }
}