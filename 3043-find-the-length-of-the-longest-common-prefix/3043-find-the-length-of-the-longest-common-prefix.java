class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr1){
            int len = (int)Math.log10(num) + 1;
            int d = (int)Math.pow(10, len-1);
            
            while(d > 0){
                set.add(num / d);
                d /= 10;
            }
        }
        int ans = 0;
        for(int num : arr2){
            int len = (int)Math.log10(num) + 1;
            int d = (int)Math.pow(10, len-1);
            
            while(d > 0){
                if(set.contains(num/d)){
                    ans = Math.max(ans, (int)Math.log10(num/d) + 1);
                }
                d /= 10;
            }
        }
        return ans;
    }
}