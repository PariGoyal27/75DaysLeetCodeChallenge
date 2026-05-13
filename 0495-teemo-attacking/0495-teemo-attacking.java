class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        
        int cnt = 0;
        for(int i = 0; i < n-1; i++){
            cnt += Math.min(duration, timeSeries[i+1] - timeSeries[i]);
        }
        return cnt + duration;
    }
}
// class Solution {
//     public int findPoisonedDuration(int[] timeSeries, int duration) {
//         int n = timeSeries.length;
//         int i = timeSeries[0]; // read head
//         int cnt = 0;
//         for(int j = 0; j < n; j++){
//             int start = timeSeries[j];
//             int end = start + duration - 1;
//             if(start > i){ // non overlapping
//                 cnt += end - start + 1;
//             }
//             else{ // overlapping
//                 cnt += end - i + 1;
//             }
//             i = end + 1;
//         }
//         return cnt;
//     }
// }