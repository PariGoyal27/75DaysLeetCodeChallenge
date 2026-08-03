class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int maxI = 0, minI = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[maxI]){
                maxI = i;
            }
            if(nums[i] < nums[minI]) {
                minI = i;
            }
        }
        int min = Math.min(maxI, minI);
        int max = Math.max(maxI, minI);
        // There are three scenerios
        // 1. both gets deleted from left
        int deletions = max + 1;

        // 2. both gets deleted from right
        deletions = Math.min(deletions, n - min);

        // 3. one from left and one from right  
        deletions = Math.min(deletions, min + 1 + n - max);


        return deletions;   
    }
}