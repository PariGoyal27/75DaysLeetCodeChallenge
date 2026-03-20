//Bottom up
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        //Copy last row
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        //Go Upwards
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
//Memo + recursion Integer not int because list is of type Integer
// class Solution {
//      private int solve(List<List<Integer>> list, int i, int j, Integer[][] dp){
//         int m = list.size();
//         // if(j > i || i >= m) // No need boundry Checks because it won't go there  
//         //     return Integer.MAX_VALUE-1;
//         if(i == m-1)
//             return dp[i][j] = list.get(i).get(j);
//         if(dp[i][j] != null) return dp[i][j];
//         int down = solve(list, i+1, j, dp);
//         int right = solve(list, i+1, j+1, dp);
//         return  dp[i][j] = list.get(i).get(j) + Math.min(down, right);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         Integer[][] dp = new Integer[n][n];
//         // for(int[] row : dp)
//         //     Arrays.fill(row, -1);
//         return solve(triangle, 0, 0, dp);
//     }
// }
//Recursion TLE -> 27/46
// class Solution {
//      private int solve(List<List<Integer>> list, int i, int j){
//         int m = list.size();
//         if(i == m-1)
//             return list.get(i).get(j);
//         int down = solve(list, i+1, j);
//         int right = solve(list, i+1, j+1);
//         return  list.get(i).get(j) + Math.min(down, right);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         return solve(triangle, 0, 0);
//     }
// }