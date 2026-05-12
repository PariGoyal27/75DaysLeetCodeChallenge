class Solution {
    private boolean isPossible(int[][] arr, int mid){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int act = arr[i][0];
            int min = arr[i][1];

            if(min > mid){
                return false;
            }
            mid -= act;
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        // remaining energy in decreasing order
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0])); 
        int low = 0;
        int high = (int)1e9;

        int result = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(tasks, mid)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}