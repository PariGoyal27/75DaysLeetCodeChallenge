class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int net_gain = 0;
        for(int g : gain){
            net_gain += g;
            highest = Math.max(highest, net_gain);
        }
        return highest;
    }
}