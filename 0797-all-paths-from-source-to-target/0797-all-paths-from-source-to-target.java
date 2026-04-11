class Solution {
    List<List<Integer>> ans;
    
    private void dfs(int node, int[][] graph, List<Integer> list){
        list.add(node);
        if(node == graph.length-1){
            ans.add(new ArrayList<>(list));
        }
        else
            for(int it : graph[node]){
                dfs(it, graph, list);
            }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //  adj list type is given
        int V = graph.length;
        ans = new ArrayList<>();
        
        dfs(0, graph, new ArrayList<>());
        return ans;
    }
}