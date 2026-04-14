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
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            Tuple cur = pq.poll();
            int d = cur.dist;
            int r = cur.row;
            int c = cur.col;
            if(r == m-1 && c == n-1)
                return dist[r][c];
            for(int i = 0; i < 4; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n){
                    int newEffort = Math.max(d, Math.abs(heights[r][c] - heights[nrow][ncol]));
                    // dist[nrow][ncol] = d + heights[nrow][ncol];\
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.offer(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}