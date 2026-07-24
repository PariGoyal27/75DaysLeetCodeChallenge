class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                set1.add(nums[i] ^ nums[j]);
            }
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(Integer it : set1){ 
            for(int i = 0; i < n; i++){
                set2.add(it ^ nums[i]);
            }
        }
        return set2.size();
    }
}
// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         int n = nums.length;

//         if (n == 1) return 1;

//         HashSet<Integer> pair = new HashSet<>();

//         // XOR of every pair of distinct indices
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 pair.add(nums[i] ^ nums[j]);
//             }
//         }

//         BitSet ans = new BitSet();

//         for (int x : pair) {
//             for (int num : nums) {
//                 ans.set(x ^ num);
//             }
//         }

//         // Triplets like (i,i,i) or (i,i,j) ensure every array element
//         // itself is also included.
//         for (int num : nums) {
//             ans.set(num);
//         }

//         return ans.cardinality();
//     }
// }