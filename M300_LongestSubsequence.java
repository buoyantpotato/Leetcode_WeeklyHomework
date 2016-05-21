package Weekly_Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    //**From teacher**
    // O(nlogn)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        List<Integer> seq = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            updateSequence(seq, nums[i]);
        }
        
        return seq.size();
    }

    private void updateSequence(List<Integer> seq, int elem) {
        int start = 0, end = seq.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (seq.get(mid) == elem) {
                return;
            } else if (seq.get(mid) < elem) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if (start >= seq.size()) {
            seq.add(elem);
        } else {
            seq.set(start, elem);
        }
    }

          
}