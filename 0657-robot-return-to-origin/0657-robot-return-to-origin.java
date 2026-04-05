class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int lr = 0, ud = 0;
        
        for(int i = 0; i < n; i++){
            char ch = moves.charAt(i);
            if(ch == 'L') lr++;
            else if(ch == 'R') lr--;
            else if(ch == 'U') ud++;
            else ud--;
        }
        return lr == 0 && ud == 0;
    }
}