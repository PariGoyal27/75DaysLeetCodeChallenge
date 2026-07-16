class Solution {
    public long minCost(int[] nums, int[] cost) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int x : nums){
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            long cost1 = calculate_cost(nums, cost, mid);
            long cost2 = calculate_cost(nums, cost, mid + 1);

            if(cost1 <= cost2){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return calculate_cost(nums, cost, low);
    }
    private long calculate_cost(int[] nums, int[] cost, int target){
        long ans = 0;

        for(int i = 0; i < nums.length; i++){
            ans += 1L * Math.abs(nums[i] - target) * cost[i];
        }
        return ans;
    }
}