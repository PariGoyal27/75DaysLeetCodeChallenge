class Solution {
    public int smallestNumber(int n, int t) {
        while(!digitProduct(n, t)){
            n++;
        }
        return n;
    }
    private boolean digitProduct(int n, int t){
        int prod = 1;
        while(n > 0){
            prod *= n % 10;
            if(prod % t == 0) return true;
            n /= 10;
        }
        return false;
    }
}