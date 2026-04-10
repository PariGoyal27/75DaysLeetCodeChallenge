class Tuple{
    int r;
    int c;
    int t;
    Tuple(int r, int c, int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        Queue<Tuple> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0 && !visited[i][j]){
                    visited[i][j] = true;
                    q.offer(new Tuple(i, j, 0));
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int t = q.peek().t;
            q.poll();
            ans[r][c] = t;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n
                && mat[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new Tuple(nr, nc, t + 1));
                }
            }
        }
        return ans;
    }
}