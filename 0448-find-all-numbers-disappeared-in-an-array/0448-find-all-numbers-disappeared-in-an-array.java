class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }
        // Set<Integer> hs = new HashSet<>();
        // for(int num : nums){
        //     hs.add(num);
        // }
        List<Integer> list = new ArrayList<>();
        for(i = 0; i < n; i++){
            // if(!hs.contains(i+1)) list.add(i+1);
            if(nums[i] != i+1)
                list.add(i+1);
        }
        return list;
    }
}