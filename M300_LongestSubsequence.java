package Weekly_Homework;

import java.util.Arrays;

public class M300_LongestSubsequence {
    public int lengthOfLIS(int[] nums) {
       
        int max = 1;
        int[] dpMap = new int[nums.length];
        Arrays.fill(dpMap, 1);
        
        for (int i = 1; i < nums.length; i++) {
            
            int maxForOne = 0;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                else {
                    if (maxForOne < dpMap[j] + 1) {
                        maxForOne = dpMap[j] + 1;
                    }
                }
            }
            
            if (maxForOne > dpMap[i]) {
            	dpMap[i] = maxForOne;
            }
            if (max < maxForOne) {
                max = maxForOne;
            }
        }
        if (nums.length == 0) return 0;
        return max;
    }
}