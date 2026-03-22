class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int fives = 0;
        int tens = 0;
        for(int i = 0; i < n; i++){
            if(bills[i] > 5 && fives == 0)
                return false;
            if(bills[i] == 5) fives++;
            if(bills[i] == 10) {
                tens++;
                fives--;
            }
            if(bills[i] == 20){
                if(tens >= 1 && fives >= 1){
                    tens--;
                    fives--;
                }else if(fives >= 3){
                    fives -= 3;
                }else
                    return false;
            }
        }
        return true;
    }
}