class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] == nums[l] && nums[mid] == nums[r]){
                l++;
                r--;
                continue;
            }

            if(nums[mid] <= nums[r]){
                // the right part is sorted
                if(target >= nums[mid] && target <= nums[r]){
                    // the target exists on right
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                // the left part is sorted
                if(target >= nums[l] && target <= nums[mid]){
                    // the target exists on left
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}