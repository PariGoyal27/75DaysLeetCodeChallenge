class Solution {
    public String greatestLetter(String s) {
        HashSet<Character> hs = new HashSet<>();
        
        for(char ch : s.toCharArray()){
            hs.add(ch);
        }
        String max = "";
        for(int i = 0; i < 26; i++){
            char lower = (char)(i + 'a');
            char upper = (char)(i + 'A');
            if(hs.contains(lower) && hs.contains(upper)){
                String up = String.valueOf(upper);
                int res = up.compareTo(max);
                if(res > 0){
                    // upper comes after max
                    max = up;
                }
            }
        }
        return max;
    }
}