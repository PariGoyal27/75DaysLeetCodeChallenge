class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    boolean[] used;
    private void solve(int[] nums, int ind, ArrayList<Integer> temp){
        if(nums.length == temp.size()){
            set.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            temp.add(nums[i]);
            solve(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        used = new boolean[n];

        solve(nums, 0, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list : set){
            ans.add(list);
        }
        return ans;
    }
}