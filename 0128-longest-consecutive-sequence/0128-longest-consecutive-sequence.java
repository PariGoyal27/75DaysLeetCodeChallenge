class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++){
            hs.add(nums[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);
        int max = 1;
        int cnt = 1;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) - list.get(i-1) == 1){
                cnt++;
            }else
                cnt = 1;
            max = Math.max(max, cnt);
        }
        return max;
    }
}