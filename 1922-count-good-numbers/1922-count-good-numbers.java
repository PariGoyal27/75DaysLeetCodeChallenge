class Solution {
    private static final int M = (int)1e9 + 7;
    private long myPow(long x, long n){
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n % 2 == 0){
            return myPow(x * x % M, n / 2) % M;
        }
        return x * myPow(x, n - 1) % M;
    }
    public int countGoodNumbers(long n) {
        long oddPos = n / 2;
        long evenPos = (n + 1) / 2;
        long ans = (myPow(5, evenPos) * myPow(4, oddPos)) % M;
        return (int)ans;
    }
}