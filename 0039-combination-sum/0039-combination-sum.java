class Solution {
    List<List<Integer>> ans;
    private void solve(int[] nums, int i, int target, int sum, List<Integer> temp){
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i >= nums.length || sum > target){
            return;
        }        
        // take
        temp.add(nums[i]);
        solve(nums, i, target, sum + nums[i], temp);
        temp.remove(temp.size()-1);
        
        // not take
        solve(nums, i + 1, target, sum, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(candidates, 0, target, 0, new ArrayList<>());
        return ans;
    }
}