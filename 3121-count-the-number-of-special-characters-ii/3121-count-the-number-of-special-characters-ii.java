class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];              
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch))
                lastLower[ch - 'a'] = i;
            else if(firstUpper[ch - 'A'] == -1)
                firstUpper[ch - 'A'] = i;
        }      
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            // first condition - both should exist
            if(lastLower[i] != -1 && firstUpper[i] != -1){
                // last occurence of lower should be before first occurence of upper
                if(lastLower[i] < firstUpper[i]){
                    cnt++;
                }
            }
        }
        return cnt;                                                   
    }
}