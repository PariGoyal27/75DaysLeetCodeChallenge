class Pair{
    int node;
    long time;
    Pair(long t, int n){
        node = n;
        time = t;
    }
}
class Solution {
    int mod = (int)(1e9 + 7);
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] r : roads){
            int u = r[0], v = r[1], w = r[2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.time, b.time)
        );
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int node = cur.node;
            long time = cur.time;

            if(time > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                long edT = it.time;
                if(time + edT < dist[adjNode]){
                    dist[adjNode] = time + edT;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                }else if(time + edT == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}