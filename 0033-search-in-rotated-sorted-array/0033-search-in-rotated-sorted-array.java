class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while(s <= e){
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) return mid;
            //Check which half is sorted
            if(nums[s] <= nums[mid]){ // left half sorted
                if(target >= nums[s] && target <= nums[mid]){
                    e = mid - 1;
                }else{
                    s = mid + 1;
                }
            }else{ //right half sorted
                if(target >= nums[mid] && target <= nums[e]){
                    s = mid + 1;
                }else{
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
}