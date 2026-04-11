//Using topo sort - BFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        //Reverse all the edges
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        // for(int i = 0; i < V; i++){
        //     for(Integer it : adjRev.get(i)){
        //     }
        // }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(Integer it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

// Using DFS - Marking safe nodes in a call
// class Solution {
//     boolean visited[], pathVis[];
//     boolean mark[];
//     private boolean dfs(int node, int[][] graph){
//         visited[node] = true;
//         pathVis[node] = true;
//         for(int it : graph[node]){
//             if(!visited[it]){
//                 if(dfs(it, graph)) return true;
//             }else if(pathVis[it]) return true;
//         }
//         pathVis[node] = false;
//         mark[node] = true; // It is a safe node
//         return false;
//     }
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         visited = new boolean[V];
//         pathVis = new boolean[V];
//         mark = new boolean[V];
//         for(int i = 0; i < V; i++){
//             if(!visited[i]){
//                 dfs(i, graph);
//             }
//         }
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0; i < V; i++){
//             if(mark[i])
//                 ans.add(i);
//         }
//         return ans;
//     }
// }
// Working fine - but not efficient
// class Solution {
//     boolean visited[], pathVis[];
//     private boolean dfs(int node, int[][] graph){
//         visited[node] = true;
//         pathVis[node] = true;
//         for(int it : graph[node]){
//             if(!visited[it]){
//                 if(dfs(it, graph)) return true;
//             }else if(pathVis[it]) return true;
//         }
//         pathVis[node] = false;
//         return false;
//     }
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         visited = new boolean[V];
//         pathVis = new boolean[V];
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0; i < V; i++){
//             if(!pathVis[i]){
//                 if(!dfs(i, graph)){
//                     ans.add(i);
//                 }
//             }
//         }
//         return ans;
//     }
// }