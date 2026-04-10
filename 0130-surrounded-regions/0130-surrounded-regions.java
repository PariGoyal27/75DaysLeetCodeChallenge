class Solution {
    boolean[][] visited;
    int m, n;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    private void dfs(int r, int c, char[][] board){
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
            && !visited[nrow][ncol] && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, board);
            }
        }
    }
    // private void dfsChange(int r, int c, char[][] board){
    //     board[r][r] = 'X';
    //     visited[r][c] = true;
    //     for(int i = 0; i < 4; i++){
    //         int nrow = r + drow[i];
    //         int ncol = c + dcol[i];
    //         if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
    //         && !visited[nrow][ncol] && board[nrow][ncol] == 'O'){
    //             dfsChange(nrow, ncol, board);
    //         }
    //     }
    // }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        char[][] dummy = board;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O' && !visited[i][j])
                        dfs(i, j, board);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}