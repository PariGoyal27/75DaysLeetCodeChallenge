class Solution {
    List<String> ans;
    private void solve(StringBuilder s, int i, int open, int close){
        if(i == s.length()){
            ans.add(s.toString());
            return;
        }
        if(open > 0){
            s.setCharAt(i, '(');
            solve(s, i + 1, open - 1, close);
        }
        if(close > open && close > 0){
            s.setCharAt(i, ')');
            solve(s, i + 1, open, close - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < 2*n; i++){
            s.append(' ');
        }
        solve(s, 0, n, n);
        return ans;
    }
}