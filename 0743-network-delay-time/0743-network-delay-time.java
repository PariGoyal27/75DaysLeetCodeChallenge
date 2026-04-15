class Pair{
    int node, time;
    Pair(int t, int n){
        time = t;
        node = n;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0], v = t[1], w = t[2];
            adj.get(u).add(new Pair(w, v)); // directed graph
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        // source node is k
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(0, k));
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int node = cur.node;
            int time = cur.time;

            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int edT = it.time;
                if(time + edT < dist[adjNode]){
                    dist[adjNode] = time + edT;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        int totalTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == (int)1e9) return -1;
            totalTime = Math.max(totalTime, dist[i]);
        }
        return totalTime;
    }
}