class Solution {
    boolean[] vis;
    private boolean solve(int[] arr, int ind){
        if(ind >= arr.length || ind < 0) return false;
        if(arr[ind] == 0) return true;
        if(vis[ind]) return false;

        vis[ind] = true;
        return solve(arr, ind + arr[ind]) || solve(arr, ind - arr[ind]);
    }
    public boolean canReach(int[] arr, int start) {
        vis = new boolean[arr.length];
        return solve(arr, start);
    }
}