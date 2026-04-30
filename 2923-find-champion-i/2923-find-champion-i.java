class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;

        for(int i = 0; i < n; i++){
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(i != j && grid[i][j] != 1){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }
}