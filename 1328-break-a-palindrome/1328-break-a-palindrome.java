class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";
        StringBuilder sb = new StringBuilder(palindrome);
        boolean allA = true;
        for(int i = 0; i < n/2; i++){
            if(sb.charAt(i) != 'a'){
                sb.setCharAt(i, 'a');
                allA = false;
                break;
            }
        }
        if(allA){
            sb.setCharAt(n-1, 'b');
        }
        return sb.toString();
    }
}