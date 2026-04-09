class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    int[][] ans;
    int m, n;
    private void dfs(int[][] image, int row, int col, int color, int oldColor){
        ans[row][col] = color;
        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
            && image[nrow][ncol] == oldColor && ans[nrow][ncol] != color){
                dfs(image, nrow, ncol, color, oldColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        // Not changing the original data
        ans = image;
        
        dfs(image, sr, sc, color, oldColor);
        return ans;
    }
}

//BFS
// class Pair{
//     int row;
//     int col;
//     Pair(int r, int c){
//         row = r;
//         col = c;
//     }
// }
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int m = image.length;
//         int n = image[0].length;
//         boolean[][] visited = new boolean[m][n];

//         int oldColor = image[sr][sc];
//         if(oldColor == color) return image;

//         Queue<Pair> q = new LinkedList<>();
//         q.offer(new Pair(sr, sc));
//         image[sr][sc] = color;
//         visited[sr][sc] = true;

//         int[] drow = {-1, 0, 1, 0};
//         int[] dcol = {0, 1, 0, -1};
//         while(!q.isEmpty()){
//             int r = q.peek().row;
//             int c = q.peek().col;
//             q.poll();
//             for(int i = 0; i < 4; i++){
//                 int nrow = r + drow[i];
//                 int ncol = c + dcol[i];
//                 if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
//                 && !visited[nrow][ncol] && image[nrow][ncol] == oldColor){
//                     image[nrow][ncol] = color;
//                     q.offer(new Pair(nrow, ncol));
//                     visited[nrow][ncol] = true;
//                 }
//             }
//         }
//         return image;
//     }
// }