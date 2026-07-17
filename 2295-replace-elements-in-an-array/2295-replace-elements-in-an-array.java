class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }
        for(int[] op : operations){
            int num = op[0];
            int newNum = op[1];
            int ind = map.get(num);
            
            map.remove(num);
            nums[ind] = newNum;
            map.put(newNum, ind);
            
        }
        return nums;
    }
}