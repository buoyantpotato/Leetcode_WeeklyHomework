package Weekly_Homework;

public class M69_Sqrt {
    public int mySqrt(int x) {
        
        if (x == 0) return 0;
        if (x == 1) return 1;
        int start = 1;
        int end = x / 2;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            }
            else if (mid < x / mid) {
                start = mid;
            }
            else return mid;
        }
        
        if (end <= x / end) return end;
        else return start;
    }
}