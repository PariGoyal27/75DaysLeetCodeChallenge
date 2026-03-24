class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int l = 0, r = n-1;
        int scr = 0, maxScore = 0;
        /*greed -> maximize power to increase score
        maximize power -> playing last(highest) token(power jyada se jyada bdh jaaye)
        if(that is not working) minimize power -> playing smallest token(jisse power jyada km na ho)
        */
        while(l <= r){
            if(power >= tokens[l]){
                power -= tokens[l];
                l++;
                scr++;
                maxScore = Math.max(scr, maxScore);
            }else if(scr >= 1){
                power += tokens[r];
                r--;
                scr--;
            }else
                break;
        }
        return maxScore;
    }
}