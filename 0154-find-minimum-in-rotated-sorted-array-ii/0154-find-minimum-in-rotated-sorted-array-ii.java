class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                ans = Math.min(ans, nums[mid]);
                low++;
                high--;
                continue;
            }
            if(nums[low] < nums[high]){
                ans = Math.min(ans, nums[low]);
                break;
            }
            else if(nums[low] <= nums[mid]){
                // left half is sorted
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }else{
                // right half is sorted
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}