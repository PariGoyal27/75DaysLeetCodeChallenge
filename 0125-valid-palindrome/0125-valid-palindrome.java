class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
            }
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
                sb.append(ch);
            }
        }
        String str = sb.toString();
        String rev = sb.reverse().toString();
        return str.equals(rev);
    }
}