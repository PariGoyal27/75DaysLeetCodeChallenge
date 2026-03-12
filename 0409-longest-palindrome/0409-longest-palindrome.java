class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        boolean odd = false; //If odd exists or not
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            int val = e.getValue();
            
            ans += val/2 * 2; //Works for both odd of even 3/2 * 2 = 2

            if(val % 2 == 1){
                odd = true;
            }
        }
        if(odd) ans++;
        return ans;
    }
}