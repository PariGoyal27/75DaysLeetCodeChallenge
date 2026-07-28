class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;

        char[] arr = new char[n/2];
        for(int i = 0; i < n/2; i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);

        String firstHalf = new String(arr);
        StringBuilder sb = new StringBuilder(firstHalf);

        if(n % 2 != 0) sb.append(s.charAt(n/2));

        // As the second half is the mirror of first Half
        for(int i = n/2 - 1; i >= 0; i--){
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}