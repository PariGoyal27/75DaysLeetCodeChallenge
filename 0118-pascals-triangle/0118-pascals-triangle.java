class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            // prepare each row
            List<Integer> temp = new ArrayList<>();
            int val = 1;
            for(int j = 0; j <= i; j++){
                temp.add(val);
                val = val * (i - j) / (j + 1);
            }
            ans.add(temp);
        }
        return ans;
    }
}