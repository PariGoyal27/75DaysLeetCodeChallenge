class Solution {
    List<List<Integer>> result;
    private void solve(int[] nums, int i, int n, List<Integer> list){
        if(i == n){
            result.add(new ArrayList<>(list));
            return;
        }
        // not take
        solve(nums, i + 1, n, list);
        // take
        list.add(nums[i]);
        solve(nums, i + 1, n, list);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, n, temp);
        return result;
    }
}