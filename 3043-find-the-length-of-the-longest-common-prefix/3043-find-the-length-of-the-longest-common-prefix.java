class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr1){            
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }
        int ans = 0;
        for(int num : arr2){            
            while(num > 0){
                if(set.contains(num)){
                    ans = Math.max(ans, digitCount(num));
                }
                num /= 10;
            }
        }
        return ans;
    }
    private int digitCount(int num){
        int cnt = 0;
        while(num > 0){
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}