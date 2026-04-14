class Tuple{
    int dist;
    int row;
    int col;
    Tuple(int d, int r, int c){
        dist = d;
        row = r;
        col = c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        if(n == 1) return 1;
        int[][] dist = new int[n][n];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.offer(new Tuple(1, 0, 0));
        while(!pq.isEmpty()){
            Tuple cur = pq.poll();
            int dis = cur.dist;
            int r = cur.row;
            int c = cur.col;
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    int nrow = r + i;
                    int ncol = c + j;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n 
                    && grid[nrow][ncol] == 0
                    && dis + 1 < dist[nrow][ncol]){
                        dist[nrow][ncol] = dis + 1;
                        if(nrow == n-1 && ncol == n-1){
                            return dis + 1;
                        }
                        pq.offer(new Tuple(dis + 1, nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}