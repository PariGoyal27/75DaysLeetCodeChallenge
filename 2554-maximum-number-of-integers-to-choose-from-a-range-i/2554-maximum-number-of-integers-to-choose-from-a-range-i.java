class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int len = banned.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < len; i++)
            hs.add(banned[i]);

        int cnt = 0, sum = 0;
        for(int i = 1; i <= n; i++){
            if(sum >= maxSum) return cnt;
            if(!hs.contains(i)){ 
                sum += i;
                if(sum <= maxSum) cnt++;
            }
        }
        return cnt;
    }
}