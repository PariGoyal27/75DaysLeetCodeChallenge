class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        // marking the row and col need to be set to zero
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        // setting rows that need to be set to zero
        for(int i = 0; i < r; i++){
            if(row[i]){
                for(int j = 0; j < c; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        // setting colm that need to be set to zero
        for(int j = 0; j < c; j++){
            if(col[j]){
                for(int i = 0; i < r; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}