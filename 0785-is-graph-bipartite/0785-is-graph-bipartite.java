// DFS
class Solution {
    int[] color;
    private boolean dfs(int node, int col, int[][] graph){
        color[node] = col;
        for(int it : graph[node]){
            if(color[it] == -1){
                if(!dfs(it, 1 - col, graph)) return false;
            }else if(color[it] == col){
                return false;
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
                if(!dfs(i, 0, graph)) return false;
            }
        }
        return true;
    }
}
// BFS
// class Solution {
//     int[] color;
//     private boolean bfs(int start, int[][] graph){
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(start);
//         color[start] = 0;
//         while(!q.isEmpty()){
//             int node = q.poll();
//             for(int it : graph[node]){
//                 //Adjacent node is not colored yet
//                 if(color[it] == -1){
//                     color[it] = 1 - color[node];
//                     q.offer(it);
//                 }else if(color[it] == color[node]){ //colored and equal to adjacent
//                     return false; //can not be a bipartite
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean isBipartite(int[][] graph) {
//         int V = graph.length;
//         color = new int[V];
//         Arrays.fill(color, -1);

//         for(int i = 0; i < V; i++){
//             if(color[i] == -1){
//                 if(!bfs(i, graph)) return false;
//             }
//         }
//         return true;
//     }
// }