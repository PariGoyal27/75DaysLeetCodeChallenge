class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        solve(s, 0, new ArrayList<>());
        return result;
    }
    private void solve(String s, int ind, List<String> temp){
        if(ind == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s, ind, i)){
                temp.add(s.substring(ind, i + 1));
                solve(s, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}