class Solution {
    List<String> ans = new ArrayList<>();
    private void solve(String num, int target, int ind, String path, long eval, long prev){
        // Reached till end
        if(ind == num.length()){
            if(eval == target)
                ans.add(path);
            return;
        }
        for(int i = ind; i < num.length(); i++){
            // leading zero case
            // i != ind => current number has more than 1 digit because single 0 digit is allowed 
            if(i != ind && num.charAt(ind) == '0')
                break;

            String currStr = num.substring(ind, i+1);
            Long curr = Long.parseLong(currStr);

            // first number
            if(ind == 0){
                solve(num, target, i + 1, currStr, curr, curr);
            }else{
                // +
                solve(num, target, i + 1, path + '+' + currStr, eval + curr, curr);

                // -
                solve(num, target, i + 1, path + '-' + currStr, eval - curr, -curr);

                // *
                solve(num, target, i + 1, path + '*' + currStr, eval - prev + (curr * prev), curr * prev);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        solve(num, target, 0, "", 0, 0);
        return ans;
    }
}