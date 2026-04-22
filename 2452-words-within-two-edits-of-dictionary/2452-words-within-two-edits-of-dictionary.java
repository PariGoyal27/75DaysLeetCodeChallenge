class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int q = queries.length;
        int d = dictionary.length;
        List<String> ans = new ArrayList<>();
        int len = queries[0].length();
        for(int i = 0; i < q; i++){
            for(int j = 0; j < d; j++){
                int edits = 0;
                for(int k = 0; k < len; k++){
                    if(queries[i].charAt(k) != dictionary[j].charAt(k)){
                        edits++;
                    }
                    if(edits > 2) break;
                }
                if(edits <= 2){
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }
}