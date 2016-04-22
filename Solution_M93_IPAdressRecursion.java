
import java.util.ArrayList;
import java.util.List;

public class Solution_M93_IPAdressRecursion {
    public List<String> restoreIpAddresses(String s) {
        
    	List<String> answers = new ArrayList<String>();
        
    	ipAddressSolver(answers, s, "", 0);
        
        return answers;
    }
    
    private void ipAddressSolver(List<String> answers, String s, String oneAnswer,
    							int countSeperator) {
		//System.out.println(oneAnswer + " " + countSeperator + " " + s);
    	if (countSeperator == 3) {
    		if (isGood(s, 0, s.length())) {
    			oneAnswer += "." + s.substring(0, s.length());
    			answers.add(oneAnswer);
    			return;
    		}
    		else return;
    	}
    	
    	for (int i = 1; i < 4; i++) {
    		if (i < s.length() && isGood(s, 0, i)) {
    			
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

	private boolean isGood(String s, int a, int b) {
		if (b - a > 3) return false;
        int n = Integer.parseInt(s.substring(a, b));
        if (n > 255) return false;
        if (n < 10 && (b - a) > 1) return false;
        if (n < 100 && (b - a) > 2) return false;
        return true;
    }
    
    public static void main(String[] args) {
    	String ip = "121212";
    	Solution_M93_IPAdressRecursion sl = new Solution_M93_IPAdressRecursion();
    	System.out.println(sl.restoreIpAddresses(ip));
    	System.out.println(sl.restoreIpAddresses(ip).size());
    }
}