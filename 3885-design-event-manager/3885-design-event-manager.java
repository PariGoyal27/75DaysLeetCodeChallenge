class EventManager {
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> map;
    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });
        map = new HashMap<>();
        for(int i = 0; i < events.length; i++){
            pq.offer(new int[]{events[i][0], events[i][1]});
            map.put(events[i][0], events[i][1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[]{eventId, newPriority});
    }
    
    public int pollHighest() {
        if(pq.isEmpty()) return -1;
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int id = arr[0];
            int p = arr[1];
            if(map.containsKey(id) && map.get(id) == p){
                map.remove(id);
                return id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */