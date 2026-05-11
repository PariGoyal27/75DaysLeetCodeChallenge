class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            String s = String.valueOf(nums[i]);
            for(int j = 0; j < s.length(); j++){
                char ch = s.charAt(j);
                list.add(ch - '0');
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}