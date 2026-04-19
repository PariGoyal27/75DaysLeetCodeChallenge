class Tuple{
    int row, col, color;
    Tuple(int r, int c, int cl){
        row = r;
        col = c;
        color = cl;
    }
}
class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();
        Arrays.sort(sources, (a,b) -> b[2] - a[2]);
        for(int i = 0; i < sources.length; i++){
            int r = sources[i][0];
            int c = sources[i][1];
            int color = sources[i][2];
            grid[r][c] = color;
            q.offer(new Tuple(r, c, color));
            vis[r][c] = true;
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Tuple cur = q.poll();
            int r = cur.row;
            int c = cur.col;
            int cl = cur.color;
            for(int i = 0; i < 4; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && !vis[nrow][ncol] && cl > grid[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        grid[nrow][ncol] = cl;
                        q.offer(new Tuple(nrow, ncol, cl));
                    }
            }
        }
        return grid;
    }
}
// class Tuple{
//     int row, col, color;
//     Tuple(int r, int c, int cl){
//         row = r;
//         col = c;
//         color = cl;
//     }
// }
// class Pair{
//     int a, b;
//     Pair(int a, int b){
//         this.a = a;
//         this.b = b;
//     }
// }
// class Solution {
//     public int[][] colorGrid(int n, int m, int[][] sources) {
//         int[][] grid = new int[n][m];
//         boolean[][] vis = new boolean[n][m];
//         Queue<Tuple> pq = new LinkedList<>();
//         for(int i = 0; i < sources.length; i++){
//             int r = sources[i][0];
//             int c = sources[i][1];
//             int color = sources[i][2];
//             grid[r][c] = color;
//             pq.offer(new Tuple(r, c, color));
//             vis[r][c] = true;
//         }
//         int[] dr = {-1, 0, 1, 0};
//         int[] dc = {0, 1, 0, -1};
//         while(!pq.isEmpty()){
//             int size = pq.size();
//             List<Pair> list = new ArrayList<>();
//             for(int j = 0; j < size; j++){
//                 Tuple cur = pq.poll();
//                 int r = cur.row;
//                 int c = cur.col;
//                 int cl = cur.color;
//                 for(int i = 0; i < 4; i++){
//                     int nrow = r + dr[i];
//                     int ncol = c + dc[i];
//                     if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
//                       && !vis[nrow][ncol] && cl > grid[nrow][ncol]){
//                         list.add(new Pair(nrow, ncol));
//                         grid[nrow][ncol] = cl;
//                         pq.offer(new Tuple(nrow, ncol, cl));
//                       }
//                 }
//             }
//             for(int i = 0; i < list.size(); i++){
//                 int r = list.get(i).a;
//                 int c = list.get(i).b;
//                 vis[r][c] = true;
//             }
//         }
//         return grid;
//     }
// }