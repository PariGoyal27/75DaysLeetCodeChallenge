/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt = 0;
    public int countDominantNodes(TreeNode root) {        
        dfs(root);
        return cnt; 
    }
    private int dfs(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int max = Math.max(root.val, Math.max(left, right));

        if(max == root.val) cnt++;
        return max; 
    }
}
// class Solution {
//     public int countDominantNodes(TreeNode root) {
//         HashMap<TreeNode, Integer> map = new HashMap<>();
//         assignWeights(root, map);
        
//         return countDominants(root, map);
//     }
//     private int countDominants(TreeNode root, HashMap<TreeNode, Integer> map){
//         if(root == null) return 0;
//         int cnt = 0;
//         if(map.containsKey(root))
//             cnt = root.val == map.get(root) ? 1 : 0; 
        
//         int left = countDominants(root.left, map);
//         int right = countDominants(root.right, map);
//         return cnt + left + right; 
//     }
//     private int assignWeights(TreeNode root, HashMap<TreeNode, Integer> map){
//         if(root == null) return 0;
//         int max = root.val;
//         int left = assignWeights(root.left, map);
//         int right = assignWeights(root.right, map);
//         map.put(root, Math.max(max, Math.max(left, right)));

//         return map.get(root);
//     }
// }©leetcode