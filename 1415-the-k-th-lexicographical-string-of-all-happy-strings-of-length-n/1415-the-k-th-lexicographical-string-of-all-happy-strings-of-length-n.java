class Solution {
    String ans = "";
    int k;
    private void solve(int n, StringBuilder sb){
        if(sb.length() == n){
            k--;
            if(k == 0){
                ans = sb.toString();
            }
            return;
        }
        for(char ch : new char[]{'a', 'b', 'c'}){
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == ch)
                continue;
            
            sb.append(ch);
            solve(n, sb);

            if(!ans.equals("")) return; // If ans has been found
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public String getHappyString(int n, int k) {
        this.k = k;
        StringBuilder sb = new StringBuilder();
        solve(n, sb);
        return ans;
    }
}