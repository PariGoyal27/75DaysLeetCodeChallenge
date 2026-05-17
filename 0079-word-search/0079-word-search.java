class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][] visited;
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        boolean ans = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && solve(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean solve(char[][] grid, String word, int row, int col, int ind){
        if(ind >= word.length()) return true;

        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col])
            return false;

        if(grid[row][col] != word.charAt(ind)) return false;
        visited[row][col] = true;

        for(int i = 0; i < 4; i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            
            if(solve(grid, word, nrow, ncol, ind + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}