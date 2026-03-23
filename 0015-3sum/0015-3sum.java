class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int l = i+1, r = n-1, target = -nums[i];
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum == target){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(l < r && nums[r] == nums[r+1]) r--;
                }else if(sum > target)
                    r--;
                else
                    l++;
            }
        }
        return result;
    }
}
// public List<List<Integer>> twoSum(int[] nums, int target, int l, int r) {
//     int n = nums.length;
//     // int l = 0, r = n-1;
//     List<List<Integer>> ans = new ArrayList<>();
//     while(l < r){
//         int sum = nums[l] + nums[r];
//         if(sum == target){
//             ans.add(Arrays.asList(nums[l], nums[r]));
//             l++;
//             r--;
//             while(l < r && nums[l] == nums[l-1]) l++;
//             while(l < r && nums[r] == nums[r+1]) r--;
//         }else if(sum > target)
//             r--;
//         else
//             l++;
//     }
//     return ans;
// }