class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for(int q : quantities){
            max = Math.max(max, q);
        }
        int ans = -1;
        int low = 1, high = max;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, n, quantities)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean isPossible(int mid, int n, int[] quantities){
        int cnt = 0;
        for(int i = 0; i < quantities.length; i++){
            cnt += (quantities[i] + mid - 1) / mid;

            if(cnt > n) return false;
        }
        return true;
    }
}