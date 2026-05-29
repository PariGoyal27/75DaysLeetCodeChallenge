class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            sb.append(ch - 'a' + 1);
        }
        int num = 0;
        for(int i = 0; i < sb.length(); i++){
            num += sb.charAt(i) - '0';
        }
        int sum = 0;
        while(k-- > 1){
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            num = sum;
            sum = 0;
        }
        return num;
    }
}