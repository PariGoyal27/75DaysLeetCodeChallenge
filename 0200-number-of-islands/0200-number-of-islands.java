class Solution {
    boolean[][] visited;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    int m, n;
    private void dfs(int r, int c, char[][] grid){
        visited[r][c] = true;

        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
            && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                dfs(nrow, ncol, grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int islands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}