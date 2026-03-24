class Solution {
    public int brokenCalc(int startValue, int target) {
        int cnt = 0;
        //Thinking backward from target to startValue
        while(target > startValue){
            if(target % 2 == 0)
                target /= 2;
            else
                target += 1;

            cnt++;
        }
        // if(target <= startValue)
        cnt += startValue - target;
        return cnt;
    }
}