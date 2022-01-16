class Solution {
    public double myPow(double x, int n) {
        double myresult = 1.0;
        long number = n;
        if (n < 0) {
            if (x == 0) {
                throw new IllegalArgumentException("0.0 cannot be raised to a negative power");
            }
            number = -1 * number;
        }
        while (number > 0) {
            if (number % 2 == 0) {
                x = x * x;
                number = number / 2;
            } else {
                myresult = myresult * x;
                number = number - 1;
            }
        }
        if (n < 0) {
            return (double)(1.0) / (double)(myresult);
        }
        return myresult;
    }
}
