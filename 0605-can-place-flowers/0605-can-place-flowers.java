class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Stack<Integer> st = new Stack<>();
        int size = flowerbed.length;
        int cnt = 0;

        for(int i = 0; i < size; i++){
            if(flowerbed[i] == 0){
                boolean isLeftEmpty = (i == 0) || flowerbed[i-1] == 0;
                boolean isRightEmpty = (i == size-1) || flowerbed[i+1] == 0;

                if(isLeftEmpty && isRightEmpty){
                    flowerbed[i] = 1;
                    cnt++;
                }
            }
        }
        return cnt >= n;
    }
}