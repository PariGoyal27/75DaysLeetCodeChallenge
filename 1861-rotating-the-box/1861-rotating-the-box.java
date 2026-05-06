class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] rotated = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rotated[i][j] = boxGrid[m-1-j][i];
            }
        }
        //for each column
        for(int j = 0; j < m; j++){
            // from bottom of column
            int ind = n-1;
            for(int i = n-1; i >= 0 && ind >= 0; i--){
                if(rotated[i][j] == '*'){
                    ind = i - 1;
                }else if(rotated[i][j] == '#'){
                    rotated[ind][j] = '#';
                    if(ind != i){
                        rotated[i][j] = '.';
                    }
                    ind--;
                }
            }
        }
        return rotated;
    }
}