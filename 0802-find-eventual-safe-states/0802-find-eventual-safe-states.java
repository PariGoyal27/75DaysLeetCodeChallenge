class Solution {
    boolean visited[], pathVis[];
    private boolean dfs(int node, int[][] graph){
        visited[node] = true;
        pathVis[node] = true;
        for(int it : graph[node]){
            if(!visited[it]){
                if(dfs(it, graph)) return true;
            }else if(pathVis[it]) return true;
        }
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        visited = new boolean[V];
        pathVis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            // if(!visited[i]){
                if(!dfs(i, graph)){
                    ans.add(i);
                }
            // }
        }
        return ans;
    }
}