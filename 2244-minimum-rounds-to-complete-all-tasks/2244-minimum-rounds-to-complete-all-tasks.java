class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int rounds = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int val = e.getValue();
            if(val == 1) return -1;
            if(val % 3 == 0)
                rounds += val/3;
            else if(val % 3 == 1)
                rounds += (val-4)/3 + 2;
            else
                rounds += val/3 + 1; 
        }
        return rounds;
    }
}