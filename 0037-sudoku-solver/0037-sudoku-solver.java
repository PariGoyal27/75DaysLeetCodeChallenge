class Solution {
    private boolean isValid(char c, char[][] board, int row, int col){
        // check in the current row
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c) return false;
        }
        // check in the current column
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c) return false;
        }
        // check in the current box
        int rowStart = 3 * (row / 3);
        int colStart = 3 * (col / 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[rowStart + i][colStart + j] == c) return false;
            }
        }
        return true;
    }
    private boolean solve(char[][] board){        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                // those places which are empty
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(c, board, i, j)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }
                            // backtrack
                            board[i][j] = '.';
                        }
                    }
                    // no number fits backtrack
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}