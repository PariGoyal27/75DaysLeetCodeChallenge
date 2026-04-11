class Solution {
    public int minimumDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        int n = nums.length;
        if(n <= 2) return -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for(List<Integer> list : map.values()){
            if(list.size() < 3) continue;
            
            for(int i = 2; i < list.size(); i++){
                minDist = Math.min(minDist, 2 * (list.get(i) - list.get(i-2)));
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}