class Solution {
    public double myPow(double x, int n) {
        if (x == 1) return x;
        if (x == -1) return n%2 == 0 ? 1 : -1;
        if (n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE) return 0;
        double pow = 1;
        boolean neg = n < 0 ? true : false;
        n = neg ? n*-1 : n;
        
        while (n > 0) {
            pow *= x;
            n--;
        }
        return neg ? 1/pow : pow;
    }
}
