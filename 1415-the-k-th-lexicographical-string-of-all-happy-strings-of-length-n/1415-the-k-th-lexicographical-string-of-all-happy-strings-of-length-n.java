class Solution {
    char[] arr = {'a', 'b', 'c'};
    private void solve(int n, int k, StringBuilder sb, List<String> ans){
        if(ans.size() == k) return;
        if(sb.length() == n){
            ans.add(sb.toString());
            return;
        }
        for(int i = 0; i < 3; i++){
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == arr[i])
                continue;
            sb.append(arr[i]);
            solve(n, k, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(n, k, sb, ans);
        if(k > ans.size()) return "";
        return ans.get(k-1);
    }
}