class Solution {
    List<List<Integer>> ans;
    private void solve(int[] nums, int i, int target, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int ind = i; ind < nums.length; ind++){
            if(ind > i && nums[ind] == nums[ind - 1])
                continue;
            
            if(nums[ind] > target) break; // no further choices all will be greater than target
            temp.add(nums[ind]);
            solve(nums, ind + 1, target - nums[ind], temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);

        solve(candidates, 0, target, new ArrayList<>());

        return ans;
    }
}

// tle - 172 / 176 time complexity is higher than expected
// class Solution {
//     // List<List<Integer>> ans;
//     HashSet<List<Integer>> set;
//     private void solve(int[] nums, int i, int target, List<Integer> temp){
//         if(i == nums.length){
//             if(target == 0){
//                 set.add(new ArrayList<>(temp));
//             }
//             return;
//         }
//         if(nums[i] <= target){
//             temp.add(nums[i]);
//             solve(nums, i + 1, target - nums[i], temp);
//             temp.remove(temp.size() - 1);
//         }
//         solve(nums, i + 1, target, temp);
//     }
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         set = new HashSet<>();
//         Arrays.sort(candidates);
//         solve(candidates, 0, target, new ArrayList<>());

//         List<List<Integer>> ans = new ArrayList<>();
//         for(List<Integer> list : set){
//             ans.add(list);
//         }
//         return ans;
//     }
// }