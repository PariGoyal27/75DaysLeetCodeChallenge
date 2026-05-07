class Solution {
    boolean visited[];
    private boolean solve(int[] arr, int i){
        if(i < 0 || i >= arr.length) return false;
        if(arr[i] == 0) return true;
        if(visited[i]) return false;
        visited[i] = true;
        return solve(arr, i + arr[i]) || solve(arr, i - arr[i]);
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        visited = new boolean[n];
        return solve(arr, start);
    }
}