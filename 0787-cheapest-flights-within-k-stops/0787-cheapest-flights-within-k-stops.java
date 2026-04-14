class Pair{
    int node, wt;
    Pair(int n, int w){
        node = n;
        wt = w;
    }
}
class Tuple{
    int stops, node, dist;
    Tuple(int s, int n, int d){
        stops = s; node = n; dist = d;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int f[] : flights){
            int u = f[0], v = f[1], w = f[2];
            adj.get(u).add(new Pair(v, w));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));
        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.dist;

            for(Pair iter : adj.get(node)){
                int adjNode = iter.node;
                int edW = iter.wt;
                if(cost + edW < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edW;
                    q.offer(new Tuple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}