class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        HashSet<Integer> hashA = new HashSet<>();
        HashSet<Integer> hashB = new HashSet<>();
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            hashA.add(A[i]);
            hashB.add(B[i]);
            if(A[i] == B[i]){
                cnt += 1;
            }else{
                if(hashB.contains(A[i])){
                    cnt += 1;
                }
                if(hashA.contains(B[i])){
                    cnt += 1;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}