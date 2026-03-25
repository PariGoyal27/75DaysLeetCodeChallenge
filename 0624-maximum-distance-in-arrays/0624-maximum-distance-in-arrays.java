class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int dist = 0;
        for(int i = 1; i < n; i++){
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            dist = Math.max(dist, Math.abs(currMax - min));
            dist = Math.max(dist, Math.abs(max - currMin));
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }
        return dist;
    }
}