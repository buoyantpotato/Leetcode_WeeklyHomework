

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
                	//System.out.println(i + " " + j + " " + k);
                    if (!isGood(s, j, k)) break;
                    //System.out.println(i + " " + j + " " + k);
                    if (!isGood(s, k, (s.length()))) continue;
                    
                    String str = s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k) 
                                    + "." + s.substring(k, s.length());
                    //System.out.println(i + " " + j + " " + k);
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
        //System.out.println(a + " " + b);
        int n = Integer.parseInt(s.substring(a, b));
        //System.out.println(a + " " + b);
        if (n > 255) return false;
        if (n < 10 && (b - a) > 1) return false;
        if (n < 100 && (b - a) > 2) return false;
        //System.out.println(a + " " + b);
        return true;
    }
    
    public static void main(String[] args) {
    	String ip = "027924";
    	Solution_M93_IPAddress sl = new Solution_M93_IPAddress();
    	System.out.println(sl.restoreIpAddresses(ip));
    	System.out.println(sl.restoreIpAddresses(ip).size());
    }
}