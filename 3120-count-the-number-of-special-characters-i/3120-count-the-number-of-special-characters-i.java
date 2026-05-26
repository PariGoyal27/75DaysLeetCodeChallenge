class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs = new HashSet<>();
        int cnt = 0;
        for(char ch : word.toCharArray()){
            hs.add(ch);
        }
        for(int i = 0; i < 26; i++){
            char lower = (char)(i + 'a');
            char upper = (char)(i + 'A');
            if(hs.contains(lower) && hs.contains(upper))
                cnt++;
        }
        return cnt;
    }
}