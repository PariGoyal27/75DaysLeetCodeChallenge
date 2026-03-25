class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long totalSum = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                totalSum += grid[i][j];
            }
        }
        if(totalSum % 2 == 1) return false;
        long target = totalSum / 2;
        long prefixSum = 0l;
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n; j++){
                prefixSum += grid[i][j];
            }
            if(prefixSum == target) return true;
        }
        prefixSum = 0l;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                prefixSum += grid[j][i];
            }
            if(prefixSum == target) return true;
        }
        return false;
    }
}