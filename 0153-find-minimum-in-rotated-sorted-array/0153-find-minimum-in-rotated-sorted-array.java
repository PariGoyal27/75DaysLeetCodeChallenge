class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high]){
                ans = Math.min(ans, nums[low]);
                break;
            }
            if(nums[mid] <= nums[high]){
                high = mid - 1;
                ans = Math.min(ans, nums[mid]);
            }else{
                low = mid + 1;
                ans = Math.min(ans, nums[high]);
            }
        }
        return ans;
    }
}