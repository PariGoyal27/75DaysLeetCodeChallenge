class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n - 1) == '1') return false;
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;

        int farthestProcessed = 0;
        while(!q.isEmpty()){
            int ind = q.poll();
            if(ind == n-1) return true;

            int start = Math.max(farthestProcessed + 1, ind + minJump);
            int end = ind + maxJump;
            
            for(int i = start; i <= end; i++){
                if(i < n && !vis[i] && s.charAt(i) == '0'){
                    q.offer(i);
                    vis[i] = true;
                }
            }
            farthestProcessed = ind + maxJump;
        }
        return false;
    }
}
// class Solution {
//     boolean[] vis;
//     private boolean solve(String s, int ind, int minJump, int maxJump){
//         if(ind >= s.length()) return false;
//         if(s.charAt(ind) == '1') return false;
//         if(ind == s.length() - 1) return true;
//         if(vis[ind]) return false;
//         vis[ind] = true;

//         boolean ans = false;
//         for(int i = ind + maxJump; i >= ind + minJump; i--){
//             ans = ans || solve(s, i, minJump, maxJump);
//         }
//         return ans;
//     }
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
//         if(s.charAt(n - 1) == '1') return false;
//         vis = new boolean[n];
//         return solve(s, 0, minJump, maxJump);
//     }
// }