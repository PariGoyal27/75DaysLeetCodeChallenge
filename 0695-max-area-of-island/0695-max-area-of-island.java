class Solution {
    boolean[][] visited;
    int m, n;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    private int dfs(int r, int c, int[][] grid){
        visited[r][c] = true;
        int area = 1;
        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
            && grid[nrow][ncol] == 1 && !visited[nrow][ncol]){
                area += dfs(nrow, ncol, grid);
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }
}