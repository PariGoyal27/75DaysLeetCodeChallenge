class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n){
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
            rank.set(ulp_u, rank.get(u) + 1);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String,Integer> mapMail = new HashMap<>();

        // Creating map mail to index
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mapMail.containsKey(mail)){
                    mapMail.put(mail, i);
                }else{
                    ds.unionByRank(i, mapMail.get(mail));
                }
            }
        }
        List<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<>();
        }
        // traverse mapMail
        for(Map.Entry<String, Integer> it : mapMail.entrySet()){
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
            mergedMail[node].add(mail);
        }
        // By sorting mails storing answer along with name
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // adding name
            for(String it : mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}