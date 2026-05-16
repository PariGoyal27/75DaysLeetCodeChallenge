class Solution {
    List<List<Integer>> ans;
    private void solve(int[] nums, int i, int target, List<Integer> temp){
        if(i == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        // pick
        if(nums[i] <= target){
            temp.add(nums[i]);
            solve(nums, i, target - nums[i], temp);
            temp.remove(temp.size() - 1);
        }
        // not pick
        solve(nums, i + 1, target, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(candidates, 0, target, new ArrayList<>());
        return ans;
    }
}