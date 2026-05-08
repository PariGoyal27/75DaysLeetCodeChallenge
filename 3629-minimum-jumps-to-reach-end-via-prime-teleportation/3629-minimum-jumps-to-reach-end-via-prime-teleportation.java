class Solution {
    int max ;
    // maxN can be the maximum number in the array
    boolean isPrime[];
    private void sieve(){
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for(int i = 2; i <= max; i++){
            if(isPrime[i]){
                if((long)i * i <= max)
                for(int j = i * i; j <= max; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        isPrime = new boolean[max + 1];
        sieve();
        // Applying BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        // to have a check on visited prime
        HashSet<Integer> seen = new HashSet<>();
        int jumps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int idx = q.poll();

                if(idx == n-1) return jumps;
                // jump to i-1
                if(idx > 0 && !visited[idx - 1]){
                    q.offer(idx - 1);
                    visited[idx - 1] = true;
                }
                // jump to i + 1
                if(idx < n - 1 && !visited[idx + 1]){
                    q.offer(idx + 1);
                    visited[idx + 1] = true;
                }
                if(!isPrime[nums[idx]] || seen.contains(nums[idx])) {
                    // first check if that is a prime or not and seen prime or not
                    continue;
                }
                // teleportation
                seen.add(nums[idx]);
                for(int multiple = nums[idx]; multiple <= max; multiple += nums[idx]){
                    if(map.containsKey(multiple)){
                        for(Integer j : map.get(multiple)){
                            if(!visited[j]){
                                q.offer(j);
                                visited[j] = true;
                            }
                        }
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}