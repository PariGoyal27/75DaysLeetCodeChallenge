class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] used = new boolean[n];
        used[0] = true;

        int steps = 0;
        HashSet<Integer> seen = new HashSet<>();

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int ind = q.poll();
                if(ind == n-1) return steps;
                //i + 1
                if(ind + 1 < n && !used[ind + 1]){
                    q.offer(ind + 1);
                    used[ind + 1] = true; 
                }
                // i - 1
                if(ind - 1 >= 0 && !used[ind - 1]){
                    q.offer(ind - 1);
                    used[ind - 1] = true;
                }
                // j
                if(!seen.contains(arr[ind])){
                    for(int idx : map.get(arr[ind])){
                        if(!used[idx]){
                            q.offer(idx);
                            used[idx] = true;
                        }
                    }
                    seen.add(arr[ind]);
                }
            }
            steps++;
        }
        return steps;
    }
}