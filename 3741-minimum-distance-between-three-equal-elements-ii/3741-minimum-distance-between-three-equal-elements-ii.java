class Solution {
    public int minimumDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        int n = nums.length;
        if(n <= 2) return -1;
        int[] prev1 = new int[n+1];
        int[] prev2 = new int[n+1];
        Arrays.fill(prev1, -1);
        Arrays.fill(prev2, -1);
        for(int i = 0; i < n; i++){
            // we want to get the first and the last occured index
            int val = nums[i];
            // prev2 is -1 means the occurance of val is < 2
            // third occurance
            if(prev2[val] != -1){ // if not -1 that means two occurances are done this is third
                minDist = Math.min(minDist, i - prev2[val]);
            }
            // second occrance - prev1(first occ) goes in prev2 and second occ goes in prev1 (next line)
            prev2[val] = prev1[val];
            // first occurance - goes in prev1
            prev1[val] = i;
        }
        return minDist == Integer.MAX_VALUE ? -1 : 2 * minDist;
    }
    // 117ms
    // public int minimumDistance(int[] nums) {
    //     int minDist = Integer.MAX_VALUE;
    //     int n = nums.length;
    //     if(n <= 2) return -1;
    //     HashMap<Integer, List<Integer>> map = new HashMap<>();
    //     for(int i = 0; i < n; i++){
    //         if(!map.containsKey(nums[i]))
    //             map.put(nums[i], new ArrayList<>());
    //         map.get(nums[i]).add(i);
    //     }
    //     for(List<Integer> list : map.values()){
    //         if(list.size() < 3) continue;
            
    //         for(int i = 2; i < list.size(); i++){
    //             minDist = Math.min(minDist, 2 * (list.get(i) - list.get(i-2)));
    //         }
    //     }
    //     return minDist == Integer.MAX_VALUE ? -1 : minDist;
    // }
}