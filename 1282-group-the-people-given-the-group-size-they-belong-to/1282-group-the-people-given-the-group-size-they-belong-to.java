class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            List<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            if(groupSizes[i] == list.size()){
                ans.add(new ArrayList<>(list));
                map.remove(groupSizes[i]);
            }
        }
        return ans;        
    }
}