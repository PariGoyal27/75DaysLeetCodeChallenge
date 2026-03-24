class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int total = 0;
        int sum = neededTime[0], maxTime = neededTime[0];
        for(int i = 1; i < n; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                sum += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
            }else{
                total += sum - maxTime;
                sum = neededTime[i];
                maxTime = sum;
            }
        }
        return total + sum - maxTime;
    }
    /**public int minCost(String colors, int[] neededTime){
        int n = colors.length(), cnt = 0;
        int max_time = neededTime[0];
        for(int i = 1 ; i < n ; i++){
            if(colors.charAt(i) == colors.charAt(i - 1)){
                cnt += Math.min(max_time, neededTime[i]);
                max_time = Math.max(max_time, neededTime[i]);
            }else{
                max_time = neededTime[i];
            }
        }
        return cnt;
    } */
}