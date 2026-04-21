class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUpar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) return;

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
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DisjointSet ds = new DisjointSet(n);
        // Creating connected components
        for(int i = 0; i < allowedSwaps.length; i++){
            int u = allowedSwaps[i][0];
            int v = allowedSwaps[i][1];
            ds.unionBySize(u, v);
        }
        // Build Components Map
        HashMap<Integer, List<Integer>> components = new HashMap<>();

        for(int i = 0; i < n; i++){
            int parent = ds.findUpar(i);
            components.putIfAbsent(parent, new ArrayList<>());
            components.get(parent).add(i);
        }
        int misMatch = 0;
        //Traverse each component
        for(List<Integer> comp : components.values()){
            HashMap<Integer, Integer> map = new HashMap<>();
                // for each index in that component:
                for(int j : comp){
                    map.put(source[j], map.getOrDefault(source[j], 0) + 1);
                }
                // for each index in that component:
                for(int j : comp){
                    if(map.containsKey(target[j]) && map.get(target[j]) > 0){
                        // decrease the frequency
                        map.put(target[j], map.get(target[j]) - 1);
                    }else{
                        misMatch++;
                    }
                }
        }
                
        return misMatch;
    }
}