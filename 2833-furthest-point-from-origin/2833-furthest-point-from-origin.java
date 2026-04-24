class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'L') left++;
            if(moves.charAt(i) == 'R') right++;
        }
        StringBuilder sb = new StringBuilder();
        char ch = left > right ? 'L' : 'R';
        int cnt = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == '_'){
                sb.append(ch);
                if(ch == 'L') cnt--;
                else cnt++;
            }
            else{
                sb.append(moves.charAt(i));
                if(moves.charAt(i) == 'L') cnt--;
                else cnt++;
            }
        }
        return Math.abs(cnt);
    }
}