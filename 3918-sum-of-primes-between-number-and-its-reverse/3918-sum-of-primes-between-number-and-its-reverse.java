class Solution {
    public int sumOfPrimesInRange(int n) {
        int temp = n;
        int rev = 0;
        while(temp > 0){
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp /= 10;
        }
        int min = Math.min(n, rev);
        int max = Math.max(n, rev);

        // sieve
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i <= max; i++){
            if(isPrime[i]){
                for(int j = i*i; j <= max; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;
        for(int i = min; i <= max; i++){
            if(isPrime[i]){
                sum += i;
            }
        }
        return sum;
    }
}