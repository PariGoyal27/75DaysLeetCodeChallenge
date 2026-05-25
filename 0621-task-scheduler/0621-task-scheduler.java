class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks){
            map[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < 26; i++){
            if(map[i] > 0)
                pq.offer(map[i]);
        }

        int time = 0;

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            // at once we are taking n+1 tasks out
            for(int i = 1; i <= n+1; i++){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int f : temp){
                if(f > 0){
                    pq.offer(f);
                }
            }
            if(pq.isEmpty())
                time += temp.size();
            else
                time += n + 1;
        }
        return time;
    }
}