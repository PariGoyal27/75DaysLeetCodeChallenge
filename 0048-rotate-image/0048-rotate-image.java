class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // first find transpose of the matrix
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //now reverse each row
        for(int i = 0; i < n; i++){
            int l = 0, r = n - 1;
            while(l < r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}