// Using BFS
class Quad{
    int r, c, pr, pc;
    Quad(int r, int c, int pr, int pc){
        this.r = r;
        this.c = c;
        this.pr = pr;
        this.pc = pc;
    }
}
class Solution {
    int m, n;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][] vis;
    private boolean bfs(int row, int col, char[][] grid){
        Queue<Quad> q = new LinkedList<>();
        q.offer(new Quad(row, col, -1, -1));
        vis[row][col] = true;
        while(!q.isEmpty()){
            Quad cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            for(int i = 0; i < 4; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && grid[nrow][ncol] == grid[r][c]){
                    if(!vis[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        q.offer(new Quad(nrow, ncol, r, c));             
                    }else if(nrow != cur.pr || ncol != cur.pc) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j]){
                    if(bfs(i, j, grid)) // parentI -> pi
                        return true;
                }
            }
        }
        return false;
    }
}

// Using dfs
// class Solution {
//     int m, n;
//     int[] dr = {-1, 0, 1, 0};
//     int[] dc = {0, 1, 0, -1};
//     boolean[][] vis;
//     private boolean dfs(int row, int col, int p_row, int p_col, char[][] grid){
//         vis[row][col] = true;
//         for(int i = 0; i < 4; i++){
//             int nrow = row + dr[i];
//             int ncol = col + dc[i];
//             if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
//             && grid[nrow][ncol] == grid[row][col]){
//                 if(!vis[nrow][ncol]){
//                     if(dfs(nrow, ncol, row, col, grid)){
//                         return true;
//                     }
//                 }else if(nrow != p_row || ncol != p_col) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public boolean containsCycle(char[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         vis = new boolean[m][n];
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(!vis[i][j]){
//                     if(dfs(i, j, -1, -1, grid)) // parentI -> pi
//                         return true;
//                 }
//             }
//         }
//         return false;
//     }
// }