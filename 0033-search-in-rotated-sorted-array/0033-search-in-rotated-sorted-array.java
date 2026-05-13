class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;

            if(nums[mid] < nums[r]){
                // the right part is sorted
                //Check if target is exists there or not
                if(target > nums[mid] && target <= nums[r]){
                    //target exists in the sorted part
                    l = mid + 1;
                }else{
                    //if does not exist there go left
                    r = mid - 1;
                }
            }else{
                // the left part is sorted
                if(target >= nums[l] && target < nums[mid]){
                    // target exists in the left sorted part
                    r = mid - 1;
                }else{
                    // target exists on right
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}