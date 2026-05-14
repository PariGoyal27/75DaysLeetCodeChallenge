// T.C. -> O(n)
// S.C. -> O(n)
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        
        int[] base = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] < 1 || nums[i] >= n) return false;

            base[nums[i]]++;
            if(base[nums[i]] > 2) return false;
        }

        for(int i = 1; i < n-1; i++){
            if(base[i] != 1) return false;
        }
        return base[n-1] == 2;
    }
}

// T.C. -> O(nlogn) 
// S.C. -> O(1);
// class Solution {
//     public boolean isGood(int[] nums) {
//         int n = nums.length;
        
//         Arrays.sort(nums);
//         for(int i = 0; i < n-1; i++){
//             if(nums[i] != i+1) return false;
//         }
//         if(nums[n-1] != n-1) return false;
//         return true;
//     }
// }