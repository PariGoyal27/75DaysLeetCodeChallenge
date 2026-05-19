class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!isValid(board, i, j, board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c){
        int rowStart = 3 * (row / 3);
        int colStart = 3 * (col / 3);

        for(int i = 0; i < 9; i++){
            // check current row
            if(col != i && board[row][i] == c) return false;
            // check current col
            if(row != i && board[i][col] == c) return false;
            // check current box
            if(rowStart + i / 3 != row && colStart + i % 3 != col)
            if(board[rowStart + i / 3][colStart + i % 3] == c) return false;
        }
        // for(int i = 0; i < 3; i++){
        //     for(int j = 0; j < 3; j++){
        //         if(rowStart + i != row && colStart + j != col)
        //             if(board[rowStart + i][colStart + j] == c) return false;
        //     }
        // }
        return true;
    }
}