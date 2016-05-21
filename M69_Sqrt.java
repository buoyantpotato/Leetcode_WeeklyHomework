package Weekly_Homework;

public class M69_Sqrt {
    public int mySqrt(int x) {
        
        if (x == 0 || x == 1) return x;
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
    
    //**From teacher**
    public int mySqrt2(int x) {
        int start = 1, end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x / mid >= mid && x / (mid + 1) < mid + 1) { // Good condition, return only in while loop
                return mid;
            } else if (x / mid < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
          
    
    public static void main(String[] args) {
    	double b = 1.1;
    	int i = 1;
    	System.out.println(b == i);
    }
}