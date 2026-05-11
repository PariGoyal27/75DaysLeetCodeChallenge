class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int longest = 1, lastSmaller = Integer.MIN_VALUE, cntCur = 0;
        for(int i = 0; i < n; i++){
            if(lastSmaller + 1 == nums[i]){
                cntCur++;
                lastSmaller = nums[i];
            }else if(lastSmaller == nums[i]){
                continue;
            }
            else{
                cntCur = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, cntCur);
        }
        return longest;
    }
}