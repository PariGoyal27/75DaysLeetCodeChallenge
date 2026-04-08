class Solution {
    boolean visited[];
    private void dfs(int i, int[][] isConnected){
        visited[i] = true;
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j])
                dfs(j, isConnected);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        visited = new boolean[V];
        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, isConnected);
                cnt++;
            }
        }
        return cnt;
    }
}