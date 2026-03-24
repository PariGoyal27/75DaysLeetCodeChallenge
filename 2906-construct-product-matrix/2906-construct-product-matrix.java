class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long prefix = 1, suffix = 1;
        int mod = 12345;
        int[][] ans = new int[n][m];
        for(int[] row : ans)
            Arrays.fill(row, 1);

        for(int i = 0; i < n*m; i++){
            ans[i/m][i%m] = (int)prefix;
            prefix = (prefix * grid[i/m][i%m]) % mod;
        }
        for(int i = n*m-1; i >= 0; i--){
            ans[i/m][i%m] = (int)(ans[i/m][i%m] * suffix) % mod;
            suffix = (suffix * grid[i/m][i%m]) % mod;
        }
        return ans;
    }
}