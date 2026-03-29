class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        char[] ch1 = s1.toCharArray();
        swap(ch1, 0, 2);
        if(String.valueOf(ch1).equals(s2)) return true;
        swap(ch1, 1, 3);
        if(String.valueOf(ch1).equals(s2)) return true;
        swap(ch1, 0, 2);
        if(String.valueOf(ch1).equals(s2)) return true;

        return false;
    }
    private void swap(char[] arr, int i, int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
// class Solution {
//     public boolean canBeEqual(String s1, String s2) {
//         if(s1.charAt(0) == s2.charAt(0)){
//             if(s1.charAt(2) != s2.charAt(2))
//                 return false;
//         }else if(s1.charAt(0) == s2.charAt(2)){
//             if(s1.charAt(2) != s2.charAt(0))
//                 return false;
//         }else
//             return false;

//         if(s1.charAt(1) == s2.charAt(1)){
//             if(s1.charAt(3) != s2.charAt(3))
//                 return false;
//         }else if(s1.charAt(1) == s2.charAt(3)){
//             if(s1.charAt(3) != s2.charAt(1))
//                 return false;
//         }else
//             return false;    

//         return true;
//     }
// }