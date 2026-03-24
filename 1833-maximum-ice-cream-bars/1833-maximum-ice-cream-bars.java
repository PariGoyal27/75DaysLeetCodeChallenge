class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int i = 0;
        int cost = 0;
        while(i < n && cost + costs[i] <= coins){
            cost += costs[i];
            i++;
        }
        return i;
    }
}