class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(!hs.contains(i)) list.add(i);
        }
        return list;
    }
}