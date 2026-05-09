class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int i = q.poll();
                if(i == n-1) return steps;
                // i-1
                if(i - 1 >= 0 && !visited[i - 1]){
                    q.offer(i - 1);
                    visited[i - 1] = true;
                }
                //i + 1
                if(i + 1 < n && !visited[i + 1]){
                    q.offer(i + 1);
                    visited[i + 1] = true;
                }
                // j
                if(map.containsKey(arr[i])){
                    for(int j : map.get(arr[i])){
                        if(!visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                    map.remove(arr[i]);
                }
            }
            steps++;
        }
        return steps;
    }
}