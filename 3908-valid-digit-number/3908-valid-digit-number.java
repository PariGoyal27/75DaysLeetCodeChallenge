class Solution {
    public boolean validDigit(int n, int x) {
        String s = Integer.toString(n);
        char ch = (char)(x + '0');
        int idx = s.indexOf(ch);
        if(idx == 0 || idx == -1) return false;
        return true;
    }
}
// class Solution {
//     public boolean validDigit(int n, int x) {
//         String s = Integer.toString(n);
//         if(s.charAt(0) - '0' == x) return false;
//         for(int i = 1; i < s.length(); i++){
//             if(s.charAt(i) - '0' == x) return true;
//         }
//         return false;
//     }
// }