package Weekly_Homework;
public class M50_Pow {
	// Recursion method
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / (myPow(x, -(n + 1)) * x); // -(Min_Integer) = Min_Integer
        }
        
        double routeToAns = myPow(x, n / 2);
        if (n % 2 == 0) {
            return routeToAns * routeToAns;
        }
        else {
            return routeToAns * routeToAns * x;
        }
    }
    

    //**From teacher**
    // Iteration method
    public double myPowIteration(double x, int n) {
    	double result = 1;
        long m = (long) ((n >= 0) ? n : -n);
        while (m > 0) {
            if ((m & 1) == 1) {
                result *= x;
            }
            
            x *= x;
            m >>= 1;
        }
        
        return n >= 0 ? result : 1 / result; 	
    }
}