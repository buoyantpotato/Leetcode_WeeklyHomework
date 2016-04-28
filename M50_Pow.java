package Weekly_Homework;
public class M50_Pow {
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
}