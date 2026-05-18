class Solution {
    public String decodeString(String s) {
        Stack<Integer> cnt = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + ch-'0';
            }else if(ch == '['){
                cnt.push(num);
                str.push(curr);

                // starting new string
                curr = new StringBuilder();
                num = 0;
            }else if(ch == ']'){
                int repeat = cnt.pop();
                StringBuilder prev = str.pop();
                while(repeat-- > 0){
                    prev.append(curr);
                }
                curr = prev;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}