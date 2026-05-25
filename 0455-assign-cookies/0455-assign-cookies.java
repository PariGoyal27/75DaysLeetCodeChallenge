class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n1 = g.length, n2 = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(s[j] >= g[i]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i;
    }
}