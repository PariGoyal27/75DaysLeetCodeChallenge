class Solution {
    public int findMin(int[] arr) {
        int i = 0, j = arr.length - 1;
        int ans = 0;
        int end = j;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(arr[mid] > arr[end]){
                i = mid + 1;
            }else{
                ans = arr[mid];
                j = mid - 1;
            }
        }
        return ans;
    }
}