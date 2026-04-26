class Solution {
    int m, n;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][] vis;
    private boolean dfs(int row, int col, int p_row, int p_col, char[][] grid){
        vis[row][col] = true;
        for(int i = 0; i < 4; i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
            && grid[nrow][ncol] == grid[row][col]){
                if(!vis[nrow][ncol]){
                    if(dfs(nrow, ncol, row, col, grid)){
                        return true;
                    }
                }else if(nrow != p_row || ncol != p_col) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j]){
                    if(dfs(i, j, -1, -1, grid)) // parentI -> pi
                        return true;
                }
            }
        }
        return false;
    }
}