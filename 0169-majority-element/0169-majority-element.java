class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, element = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == element){
                cnt++;
            }else if(cnt == 0){
                element = nums[i];
                cnt = 1;
            }else{
                cnt--;
            }
        }
        return element;
    }
}
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];
//     }
// }