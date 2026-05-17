class Solution {
    boolean[] visited;
    private boolean solve(int[] nums, int ind, long mult, long target){
        if(mult > target) return false;
        if(mult == target) return true;
        if(ind == nums.length) return false;

        return solve(nums, ind + 1, mult * nums[ind], target) 
                || solve(nums, ind + 1, mult, target);
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
        visited = new boolean[n];
        Arrays.sort(nums);

        long mult = 1;
        for(int i = 0; i < n; i++){
            mult *= nums[i];
        }
        if(target * target != mult) return false;
        return solve(nums, 0, 1, target);
    }
}