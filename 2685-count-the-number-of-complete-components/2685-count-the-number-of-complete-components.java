class Solution {
    boolean[] vis;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        vis = new boolean[n];
        int cnt = 0;
        
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                // Collect all nodes of the component
                List<Integer> component = new ArrayList<>();
                int compoSize = dfs(i, adj, component);

                boolean ok = true;
                for(int node : component){
                    if(adj.get(node).size() != compoSize-1){
                        ok = false;
                        break;
                    }
                }
                if(ok) cnt++;
            }
        }
        return cnt;
    }
    private int dfs(int node, List<List<Integer>> adj, List<Integer> component){
        vis[node] = true;
        component.add(node);
        int size = 1;

        for(Integer it : adj.get(node)){
            if(!vis[it]){
                size += dfs(it, adj, component);
            }
        }
        return size;
    }
}

// class Solution {
//     boolean[] vis;
//     public int countCompleteComponents(int n, int[][] edges) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] e : edges){
//             adj.get(e[0]).add(e[1]);
//             adj.get(e[1]).add(e[0]);
//         }

        // int[] degree = new int[n];
        // for(int i = 0; i < n; i++){
        //     degree[i] = adj.get(i).size();
        // }
//         vis = new boolean[n];

//         int[] compoSize = new int[n];
//         for(int i = 0; i < n; i++){
//             if(!vis[i]){
//                 compoSize[i] = componentSize(i, adj);
//             }
//         }
//         // System.out.println("Component Size " + Arrays.toString(compoSize));
//         vis = new boolean[n];
//         int cnt = 0;
//         // Check completeness of every component
//         for(int i = 0; i < n; i++){
//             if(!vis[i]){
//                 boolean isComplete = dfs(i, adj, degree, compoSize[i] - 1);
//                 if(isComplete)
//                     cnt++;
//             }
//         }
//         return cnt;
//     }
//     private int componentSize(int node, List<List<Integer>> adj){
//         vis[node] = true;
//         int size = 1;

//         for(Integer it : adj.get(node)){
//             if(!vis[it]){
//                 size += componentSize(it, adj);
//             }
//         }
//         return size;
//     }
//     private boolean dfs(int node, List<List<Integer>> adj, int[] degree, int deg){
//         vis[node] = true;
//         boolean ans = true;
        
//         if(degree[node] != deg) ans = false;

//         for(Integer it : adj.get(node)){
//             if(!vis[it]){
//                 if(!dfs(it, adj, degree, deg))
//                     ans = false;
//             }
//         }
//         return ans;
//     }
// }