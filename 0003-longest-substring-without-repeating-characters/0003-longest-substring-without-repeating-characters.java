class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();//Character and its index
        while(j < n){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= i){
                i = map.get(ch) + 1;//If occured previously then moving it forward
            }
            maxLen = Math.max(maxLen, j-i+1);
            map.put(ch, j); // keeping map updated
            j++;
        }
        return maxLen;
    }
}