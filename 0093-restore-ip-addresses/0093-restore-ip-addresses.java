class Solution {
    List<String> ans = new ArrayList<>();
    private void solve(String s, int ind, int parts, String address){
        if(ind == s.length()){
            if(parts == 4){
                // remove last dot
                String add = address.substring(0, address.length() - 1);
                ans.add(add);
            }
            return;
        }
        if(parts > 4) return;
        for(int i = ind; i < s.length(); i++){
            String currStr = s.substring(ind, i + 1);

            if(currStr.length() > 3) break;
            // length is one
            if(i == ind){
                solve(s, i + 1, parts + 1, address + currStr + '.');
            }else{
                // not leading zero and withing the range
                if(s.charAt(ind) != '0' && Integer.parseInt(currStr) <= 255)
                    solve(s, i + 1, parts + 1, address + currStr + '.');
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return ans;
        solve(s, 0, 0, "");
        return ans;
    }
}