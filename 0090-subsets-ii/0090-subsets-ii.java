class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void solve(int[] nums, int ind, List<Integer> temp){
        // if(ind >= nums.length){
        //     ans.add(new ArrayList<>(temp));
        //     return;
        // }
        ans.add(new ArrayList<>(temp));
        for(int i = ind; i < nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            solve(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return ans;
    }
}