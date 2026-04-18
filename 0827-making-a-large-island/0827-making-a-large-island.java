class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v)
            return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    int n;
    private boolean isValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
    public int largestIsland(int[][] grid) {
        n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        // Step 1 - Create connections
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;
                for(int i = 0; i < 4; i++){
                    int nrow = row + dr[i];
                    int ncol = col + dc[i];
                    if(isValid(nrow, ncol) && grid[nrow][ncol] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        // Step 2 - Convert 0 -> 1
        int mx = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;
                HashSet<Integer> ulp = new HashSet<>();
                for(int i = 0; i < 4; i++){
                    int nrow = row + dr[i];
                    int ncol = col + dc[i];
                    if(isValid(nrow, ncol) && grid[nrow][ncol] == 1){
                        int adjNodeNo = nrow * n + ncol;
                        ulp.add(ds.findUPar(adjNodeNo));
                    }
                }
                int sizeTotal = 0;
                for(Integer p : ulp){
                    sizeTotal += ds.size.get(p);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        // edge case : what if all cells are already 1
        for(int i = 0; i < n*n; i++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(i)));
        }
        return mx;
    }
}