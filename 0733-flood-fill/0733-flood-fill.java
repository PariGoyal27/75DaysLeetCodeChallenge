class Pair{
    int row;
    int col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;
        visited[sr][sc] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                && !visited[nrow][ncol] && image[nrow][ncol] == oldColor){
                    image[nrow][ncol] = color;
                    q.offer(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
        return image;
    }
}