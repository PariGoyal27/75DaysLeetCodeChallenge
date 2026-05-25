class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int t = typed.length();
        if(t < n) return false;

        int i = 0, j = 0;
        while(j < t){
            if(i < n && name.charAt(i) == typed.charAt(j)){
                i++;
            }else if(j == 0 || typed.charAt(j) != typed.charAt(j-1)){
                return false;
            }
            j++;
        }
        return i == n;
    }
}
// class Solution {
//     public boolean isLongPressedName(String name, String typed) {
//         int n = name.length();
//         int t = typed.length();
//         if(t < n) return false;

//         int i = 0, j = 0;
//         while(i < n && j < t){
//             if(name.charAt(i) == typed.charAt(j)){
//                 i++;
//                 j++;
//             }else if(i > 0 && typed.charAt(j) == name.charAt(i-1)){
//                 j++;
//             }else{
//                 break;
//             }
//         }
//         if(i != n) return false;

//         while(j != t){
//             if(typed.charAt(j++) != name.charAt(n-1))
//                 return false;
//         }
//         return true;
//     }
// }