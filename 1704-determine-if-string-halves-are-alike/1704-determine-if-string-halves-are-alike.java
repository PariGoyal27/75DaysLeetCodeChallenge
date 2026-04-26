class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int cnt = 0;
        String vowel = "aeiouAEIOU";
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(vowel.indexOf(ch) != -1){
                if(i < n/2) cnt++;
                else cnt--;
            }
        }
        return cnt == 0;
    }
}