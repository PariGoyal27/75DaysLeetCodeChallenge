class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int cnt = 0, coins = 0;
        Arrays.sort(piles);
        for(int i = n-2; i >= 0; i -= 2){
            if(cnt == n/3) break;
            coins += piles[i];
            cnt++;
        }
        return coins;
    }
}