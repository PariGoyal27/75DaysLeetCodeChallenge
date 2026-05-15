class Solution {
    private double solve(double x, long n){
        if(n == 1) return x;
        if(n == 0) return 1;
        
        if(n % 2 == 0){
            return solve(x * x, n/2);
        }else{
            return x * solve(x, n-1);
        }
    }
    public double myPow(double x, int n) {
        if(n == 1) return x;
        if(n == 0) return 1;
        long m = n;
        if(m < 0){
            return solve(1 / x, -m);
        }
        // return x * myPow(x, n-1);
        if(m % 2 == 0){
            return solve(x * x, m/2);
        }else{
            return x * solve(x, m-1);
        }
    }
}