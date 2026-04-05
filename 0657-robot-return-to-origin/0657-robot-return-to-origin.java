class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int l = 0, r = 0, u = 0, d = 0;
        for(int i = 0; i < n; i++){
            char ch = moves.charAt(i);
            if(ch == 'L') l++;
            else if(ch == 'R') r++;
            else if(ch == 'U') u++;
            else d++;
        }
        return l == r && u == d;
    }
}