// Using BFS
class Pair{
    int row;
    int col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}
class Solution {
    boolean[][] visited;
    int m, n;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    private void bfs(int r, int c, char[][] grid){

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        visited[r][c] = true;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                    visited[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int islands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}
// Using DFS
// class Solution {
//     boolean[][] visited;
//     int[] drow = {-1, 0, 1, 0};
//     int[] dcol = {0, 1, 0, -1};
//     int m, n;
//     private void dfs(int r, int c, char[][] grid){
//         visited[r][c] = true;

//         for(int i = 0; i < 4; i++){
//             int nrow = r + drow[i];
//             int ncol = c + dcol[i];
//             if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
//             && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
//                 dfs(nrow, ncol, grid);
//             }
//         }
//     }
//     public int numIslands(char[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         visited = new boolean[m][n];

//         int islands = 0;

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == '1' && !visited[i][j]){
//                     dfs(i, j, grid);
//                     islands++;
//                 }
//             }
//         }
//         return islands;
//     }
// }