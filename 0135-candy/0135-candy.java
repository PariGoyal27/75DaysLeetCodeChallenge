class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        // Arrays.sort(ratings); we can't sort the array it will not give the correct answer
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // compare with the left only
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        int total = candies[n-1];
        // compare with the right only
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            total += candies[i];
        }
        return total;
    }
}