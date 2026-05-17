class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    private void solve(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            temp.add(nums[i]);
            used[i] = true;
            solve(nums, temp);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        solve(nums, new ArrayList<>());
        return ans;
    }
}