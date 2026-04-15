class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if(words[startIndex].equals(target)) return 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(words[i].equals(target)){
                int diff = Math.abs(i - startIndex);
                // min of ((i - start), n - (i - start))
                minDiff = Math.min(minDiff, Math.min(diff, n - diff));
            }
        }
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}
// class Solution {
//     public int closestTarget(String[] words, String target, int startIndex) {
//         int n = words.length;
//         if(words[startIndex].equals(target)) return 0;
//         int left = (startIndex - 1 + n) % n;
//         int right = (startIndex + 1) % n;
//         int cnt = 1;

//         while(right != startIndex){
//             if(words[left].equals(target)) return cnt;
//             if(words[right].equals(target)) return cnt;
//             left = (left - 1 + n) % n;
//             right = (right + 1) % n;
//             cnt++;
//         }
//         return -1;
//     }
// }