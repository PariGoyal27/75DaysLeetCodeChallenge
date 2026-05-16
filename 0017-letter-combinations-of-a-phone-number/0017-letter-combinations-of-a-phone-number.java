class Solution {
    List<String> ans = new ArrayList<>();
    private void solve(String digits, int ind, StringBuilder sb, Map<Integer, String> map){
        if(ind == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String s1 = map.get(digits.charAt(ind) - '0'); // 2 -> "abc"
        for(int i = 0; i < s1.length(); i++){
            sb.append(s1.charAt(i));
            solve(digits, ind + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        solve(digits, 0, new StringBuilder(), map);
        return ans;
    }
}