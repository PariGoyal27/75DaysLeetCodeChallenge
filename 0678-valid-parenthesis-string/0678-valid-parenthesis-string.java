class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0, max = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                min++;
                max++;
            }else if(ch == ')'){
                min--;
                max--;
            }else{
                min--; // treating * as ')' and if it becomes -ve in future treating as empty 
                max++; // treating * as '('
            }
            if(min < 0) min = 0;
            if(max < 0) return false; // already doing +1 in this if still -ve then not possible
        }
        return min == 0;
    }
}