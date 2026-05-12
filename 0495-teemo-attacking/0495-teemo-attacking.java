class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int i = timeSeries[0];
        int cnt = 0;
        for(int j = 0; j < n; j++){
            int start = timeSeries[j];
            int end = start + duration - 1;
            if(start > i){
                cnt += end - start + 1;
            }
            else{
                cnt += end - i + 1;
            }
            i = end + 1;
        }
        return cnt;
    }
}