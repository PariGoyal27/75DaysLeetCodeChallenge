class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1]; // who trusts me
        int[] outdegree = new int[n+1]; // who i trust
        for(int i = 0; i < trust.length; i++){
            // a -> b
            int a = trust[i][0]; 
            int b = trust[i][1];
            indegree[b]++;
            outdegree[a]++;
        }
        for(int i = 1; i <= n; i++){
            if(indegree[i] == n-1 && outdegree[i] == 0){
                return i;
            }
        }
        return -1;
    }
}