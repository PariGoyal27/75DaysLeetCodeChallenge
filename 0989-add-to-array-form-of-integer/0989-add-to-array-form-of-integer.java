class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> ans = new ArrayList<>();
        int carry = 0;

        for(int i = n-1; i >= 0; i--){
            int rem = k % 10;
            int t = num[i] + rem + carry;
            if(t > 9) {
                carry = 1;
                t = t % 10;
            }
            else carry = 0;
            ans.add(t);
            k /= 10;
        }
        k = carry + k;
        while(k > 0){
            ans.add(k % 10);
            k /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}