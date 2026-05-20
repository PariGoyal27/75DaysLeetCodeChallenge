class Solution {
    List<String> ans = new ArrayList<>();
    private void solve(String s, int ind, int parts, String address){
        if(parts == 4){
            if(ind == s.length()){
                // remove last dot
                String add = address.substring(0, address.length() - 1);
                ans.add(add);
            }
            return;
        }
        for(int i = ind; i < Math.min(ind + 3, s.length()); i++){
            String currStr = s.substring(ind, i + 1);

            // leading zero for length 2 or 3
            if(currStr.length() > 1 && currStr.charAt(0) == '0')
                break;
            
            if(Integer.parseInt(currStr) <= 255){
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