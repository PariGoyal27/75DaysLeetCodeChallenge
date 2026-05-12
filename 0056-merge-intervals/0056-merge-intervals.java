// O(nlogn + n)
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(ans.isEmpty() || start > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(start, end));
            }else{
                int last = ans.size()-1;
                int max = Math.max(end, ans.get(last).get(1));
                ans.get(last).set(1, max);
            }
        }
        int[][] result = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;
    }
}
// O(nlogn + 2n)
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         int n = intervals.length;
//         Arrays.sort(intervals, (a, b) -> {
//             if(a[0] != b[0])
//                 return a[0] - b[0];
//             return a[1] - b[1];
//         });

//         List<List<Integer>> ans = new ArrayList<>();

//         for(int i = 0; i < n; i++){
//             int start = intervals[i][0];
//             int end = intervals[i][1];
//             if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
//                 continue;
//             }
//             for(int j = i+1; j < n; j++){
//                 if(intervals[j][0] <= end){
//                     end = Math.max(end, intervals[j][1]);
//                 }else{
//                     break;
//                 }
//             }
//             ans.add(Arrays.asList(start, end));
//         }
//         int[][] result = new int[ans.size()][2];
//         for(int i = 0; i < ans.size(); i++){
//             result[i][0] = ans.get(i).get(0);
//             result[i][1] = ans.get(i).get(1);
//         }
//         return result;
//     }
// }