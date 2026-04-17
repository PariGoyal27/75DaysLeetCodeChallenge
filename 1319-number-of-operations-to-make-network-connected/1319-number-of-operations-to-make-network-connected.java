class DisjointSets{
    public List<Integer> size = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();
    DisjointSets(int n){
        for(int i = 0; i <= n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) return;

        int size_u = size.get(ulp_u);
        int size_v = size.get(ulp_v);
        if(size_u < size_v){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size_u + size_v);
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size_u + size_v);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int cnt = connections.length;
        DisjointSets ds = new DisjointSets(n);
        //Counting number of extra edgees
        int extra = 0;
        for(int[] c : connections){
            int u = c[0], v = c[1];
            if(ds.findUpar(u) == ds.findUpar(v)){
                extra++;
            }else{
                ds.unionBySize(u, v);
            }
        } 
        //Counting number of disconnected Computers
        int disCompo = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i){
                disCompo++;
            }
        }
        disCompo -= 1; // 1 connection will be there at last
        // if disconnected computer <= extra edges 
        if(disCompo <= extra) return disCompo;
        return -1;
    }
}