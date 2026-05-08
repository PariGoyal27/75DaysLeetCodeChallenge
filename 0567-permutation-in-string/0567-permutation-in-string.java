class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length(); // k is the window size
        int[] f1 = new int[26];
        for(int i = 0; i < k; i++){
            f1[s1.charAt(i) - 'a']++;
        }
        int[] f2 = new int[26];
        int i = 0, j = 0;
        while(j < s2.length()){
            f2[s2.charAt(j) - 'a']++;
            if(j - i + 1 < k){ // not reached to the window size k
                j++;
            }else{
                // reached window size
                if(Arrays.equals(f1, f2)) return true;
                f2[s2.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }
        return false;
    }
}