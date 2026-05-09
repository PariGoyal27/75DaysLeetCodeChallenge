class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 1;
        int num = nums[0];
        int i = 1;
        while(i < n){
            if(nums[i] == num) i++;
            else{ 
                num = nums[i];
                nums[k++] = num;
            }
        }
        return k;
    }
}