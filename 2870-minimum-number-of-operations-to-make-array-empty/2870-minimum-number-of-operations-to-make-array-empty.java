class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int op = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int val = e.getValue();
            if(val == 1) return -1;
            if(val % 3 == 0)
                op += val/3;
            else if(val % 3 == 1){ // remainder = 1
                op += (val - 4)/3 + 2;
            }else{ // remainder 2
                op += val/3 + 1;
            }
        }
        return op;
    }
}