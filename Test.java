package Weekly_Homework;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		PrintStream ps = System.out;
		
		String s = "98 43 59 89 84 35 19 27 1 50 38 13 65";
		int[] arrInt = Arrays.stream(s.split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		
		M300_LongestSubsequence sl = new M300_LongestSubsequence();
		ps.println(sl.lengthOfLIS(arrInt));
		
		ps.println(Integer.MAX_VALUE);

	}

}
