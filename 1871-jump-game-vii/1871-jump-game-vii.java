class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) == '1') return false;
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;

        int farthestProcessed = 0;

        while(!q.isEmpty()){
            int ind = q.poll();
            if(ind == n-1) return true;

            int start = Math.max(farthestProcessed + 1, ind + minJump);
            int end = Math.min(n - 1, ind + maxJump);
            for(int i = start; i <= end; i++){
                if(!vis[i] && s.charAt(i) == '0'){
                    if(i == n-1) return true;
                    q.offer(i);
                    vis[i] = true;
                }
            }
            farthestProcessed = ind + maxJump;
        }
        return false;
    }
}
// TLE -> 117/143
// class Solution {
//     Boolean[] dp;
//     private boolean solve(String s, int minJump, int maxJump, int i){
//         if(i == s.length() - 1){
//             return true;
//         }
//         if(s.charAt(i) == '1') return false;
//         if(dp[i] != null) return dp[i];

//         for(int k = minJump; k <= maxJump && i + k < s.length(); k++){
//             if(s.charAt(i + k) == '0'){
//                 if(solve(s, minJump, maxJump, i + k)){
//                     return dp[i] = true;
//                 }
//             }
//         }
//         return dp[i] = false;
//     }
//     public boolean canReach(String s, int minJump, int maxJump) {
//         dp = new Boolean[s.length()];
//         return solve(s, minJump, maxJump, 0);
//     }
// }