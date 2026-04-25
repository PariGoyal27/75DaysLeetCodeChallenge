class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, Long> indSum = new HashMap<>(); // Sum to indices
        Map<Integer, Long> indCnt = new HashMap<>(); // Frequency Count

        // Traverse left to right
        for(int i = 0; i < n; i++){
            long freq = indCnt.getOrDefault(nums[i], 0L);
            long sum = indSum.getOrDefault(nums[i], 0L);

            ans[i] += freq * i - sum; // derived formula by observing the pattern
            indCnt.put(nums[i], freq + 1);
            indSum.put(nums[i], sum + i);
        }
        indCnt.clear();
        indSum.clear();
        // Traverse right to left
        for(int i = n-1; i >= 0; i--){
            long freq = indCnt.getOrDefault(nums[i], 0L);
            long sum = indSum.getOrDefault(nums[i], 0L);

            ans[i] += sum - freq * i;
            indCnt.put(nums[i], freq + 1);
            indSum.put(nums[i], sum + i);
        }

        return ans;
    }
}

// TLE - 1065 / 1068
// class Solution {
//     public long[] distance(int[] nums) {
//         int n = nums.length;
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             map.putIfAbsent(nums[i], new ArrayList<>());
//             map.get(nums[i]).add(i);
//         }
//         long[] ans = new long[n];
//         for(int i = 0; i < n; i++){
//             List<Integer> list = map.get(nums[i]);
//             int size = list.size();
//             if(size == 1){
//                 ans[i] = 0;
//             }else{
//                 for(int j = 0; j < size; j++){
//                     ans[i] += Math.abs(i - list.get(j));
//                 }
//             }
//         }
//         return ans;
//     }
// }

// Naive approach
// class Solution {
//     public long[] distance(int[] nums) {
//         int n = nums.length;
//         long[] ans = new long[n];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 if(nums[i] == nums[j]){
//                     ans[i] += Math.abs(j-i);
//                 }
//             }
//         }
//         return ans;
//     }
// }