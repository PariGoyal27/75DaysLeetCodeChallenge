class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiag = new boolean[2 * n - 1];
        boolean[] lowerDiag = new boolean[2 * n - 1];
        solve(0, board, n, leftRow, upperDiag, lowerDiag);
        return ans;
    }
    private void solve(int col, char[][] board, int n, boolean[] leftRow, boolean[] upperDiag, boolean[] lowerDiag){
        if(col == n){
            // board is a char 2d array
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row = 0; row < n; row++){
            if(!leftRow[row] && !upperDiag[row + col] && !lowerDiag[n - 1 + col - row]){
                board[row][col] = 'Q';
                leftRow[row] = true;
                upperDiag[row + col] = true;
                lowerDiag[n - 1 + col - row] = true;

                solve(col + 1, board, n, leftRow, upperDiag, lowerDiag);

                board[row][col] = '.';
                leftRow[row] = false;
                upperDiag[row + col] = false;
                lowerDiag[n - 1 + col - row] = false;
            }
        }
    }
}
// class Solution {
//     List<List<String>> ans = new ArrayList<>();

//     public List<List<String>> solveNQueens(int n) {
//         char[][] board = new char[n][n];
//         for(int i = 0; i < n; i++){
//             Arrays.fill(board[i], '.');
//         }
//         solve(0, board, n);
//         return ans;
//     }
//     private void solve(int col, char[][] board, int n){
//         if(col == n){
//             // board is a char 2d array
//             List<String> temp = new ArrayList<>();
//             for(int i = 0; i < board.length; i++){
//                 temp.add(new String(board[i]));
//             }
//             ans.add(temp);
//             return;
//         }
//         for(int row = 0; row < n; row++){
//             if(isSafe(row, col, board, n)){
//                 board[row][col] = 'Q';
//                 solve(col + 1, board, n);
//                 board[row][col] = '.';
//             }
//         }
//     }
//     private boolean isSafe(int row, int col, char[][] board, int n){
//         int r = row;
//         int c = col;
//         // check in upper diagonal
//         while(row >= 0 && col >= 0){
//             if(board[row][col] == 'Q') return false;
//             row--;
//             col--;
//         }
//         row = r;
//         col = c;
//         // check on left side
//         while(col >= 0){
//             if(board[row][col] == 'Q') return false;
//             col--;
//         }
//         row = r; 
//         col = c;
//         // check lower diagonal
//         while(row < n && col >= 0){
//             if(board[row][col] == 'Q') return false;
//             row++;
//             col--;
//         }
//         return true;
//     }
// }