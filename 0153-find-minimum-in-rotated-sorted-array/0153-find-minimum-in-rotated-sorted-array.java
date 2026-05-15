class Solution {
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = 0;
        // int end = high;
        while(low < high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[high]){
                // unsorted part
                low = mid + 1;
            }else{
                // sorted part
                // ans = arr[mid];
                high = mid;
            }
        }
        return arr[low];
    }
}