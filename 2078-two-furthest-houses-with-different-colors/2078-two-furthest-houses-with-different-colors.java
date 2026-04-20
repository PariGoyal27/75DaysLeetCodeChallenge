class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        for(int i = 0; i < n-1; i++){
            if(colors[n-1] != colors[i]){
                maxDist = n-i-1;
                break;
            }
        }
        for(int i = n-1; i > 0; i--){
            if(colors[0] != colors[i]){
                maxDist = Math.max(maxDist, i);
                break;
            }
        }
        // for(int i = 0; i < n-1; i++){
        //     for(int j = n-1; j > i; j--){
        //         if(colors[i] != colors[j]){
        //             maxDist = Math.max(maxDist, j-i);
        //             break;// inner loop break
        //         }
        //     }
        // }
        return maxDist;
    }
}