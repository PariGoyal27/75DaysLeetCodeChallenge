class Solution {
    int[] color;

    private boolean bfs(int start, int V, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : graph[node]){
                //Adjacent node is not colored yet
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.offer(it);
                }else if(color[it] == color[node]){ //colored and equal to adjacent
                    return false; //can not be a bipartite
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!bfs(i, V, graph)) return false;
            }
        }
        return true;
    }
}