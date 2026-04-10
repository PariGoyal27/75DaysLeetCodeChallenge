class Solution {
    boolean[][] visited;
    int m, n;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    private void dfs(int r, int c, int[][] grid){
        visited[r][c] = true;

        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
            && grid[nrow][ncol] == 1 && !visited[nrow][ncol]){
                dfs(nrow, ncol, grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        //Mark all the boundary lands visited first
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1)
                    if(grid[i][j] == 1 && !visited[i][j])
                        dfs(i, j, grid); //marking visiteed
            }
        }
        int area = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j])
                    area++;
            }
        }
        return area;
    }
}