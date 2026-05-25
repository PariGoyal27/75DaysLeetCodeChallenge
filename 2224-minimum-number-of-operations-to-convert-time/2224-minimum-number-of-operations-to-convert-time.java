class Solution {
    public int convertTime(String current, String correct) {
        int h1 = Integer.valueOf(current.substring(0, 2));
        int m1 = Integer.valueOf(current.substring(3, 5));
        int h2 = Integer.valueOf(correct.substring(0, 2));
        int m2 = Integer.valueOf(correct.substring(3, 5));

        // if(m1 > m2){
        //     h2 -= 1;
        //     m2 += 60;
        // }        
        // int req = (h2 - h1) * 60 + m2 - m1;
        int req = (h2 * 60 + m2) - (h1 * 60 + m1);

        int[] mins = {60, 15, 5, 1};
        int ans = 0;
        for(int min : mins){
            ans += req / min;
            req = req % min;
            if(req == 0) break;
        }
        return ans;
    }
}