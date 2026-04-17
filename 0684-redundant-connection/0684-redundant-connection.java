class DisjointSets{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSets(int n){
        for(int i = 0; i <= n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionByRank(int u, int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSets ds = new DisjointSets(n);
        int[] ans = new int[2];
        for(int[] e : edges){
            int u = e[0], v = e[1];
            int ulp_u = ds.findUpar(u);
            int ulp_v = ds.findUpar(v);
            if(ulp_u == ulp_v){
                ans[0] = u;
                ans[1] = v;
            }else
                ds.unionByRank(u, v);
        }
        return ans;
    }
}