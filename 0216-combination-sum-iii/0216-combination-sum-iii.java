class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void solve(int k, int ind, int n, int sum, List<Integer> temp){
        if(temp.size() == k && sum == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
            
        for(int i = ind; i <= n; i++){
            if(i > sum) break;

            temp.add(i);
            solve(k, i + 1, n, sum - i, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(k, 1, 9, n, new ArrayList<>());
        return ans;
    }
}