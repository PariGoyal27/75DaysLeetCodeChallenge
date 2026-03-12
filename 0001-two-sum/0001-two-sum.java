class Solution {
    public int[] twoSum(int[] nums, int target) {
        //O(n^2)
        // int n = nums.length;
        // for(int i = 0; i < n-1; i++){
        //     int num = target - nums[i];
        //     for(int j = i+1; j < n; j++){
        //         if(nums[j] == num){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{-1, -1};
        
        //O(n)
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}