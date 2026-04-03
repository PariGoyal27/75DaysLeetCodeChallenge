class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums;
        Integer[] arr = new Integer[n]; // Integer as we need to pass it to the sort fn

        for(int i = 0; i < n; i++)
            arr[i] = nums[i];
        
        Arrays.sort(arr, (a, b) -> {
            int ra = reflect(a);
            int rb = reflect(b);
            if(ra == rb)
                return a - b;
            return ra - rb;
        });

        for(int i = 0; i < n; i++)
            nums[i] = arr[i];
            
        return nums;
    }
    private int reflect(int x){
        int res = 0;
        while(x > 0){
            res = (res << 1) | (x & 1);
            x >>= 1;
        }
        return res;
    }
}