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
    int ans = 0, maxDepth = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        solve(root, 1);
        return ans;
    }
    private void solve(TreeNode root, int depth){
        if(root == null) return;

        if(depth > maxDepth){
            maxDepth = depth;
            ans = root.val;
        }
        else if(depth == maxDepth){
            ans += root.val;
        }
        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
    }
}
// class Solution {
//     public int deepestLeavesSum(TreeNode root) {
//         int depth = maxDepth(root);
//         return solve(root, depth);
//     }
//     private int solve(TreeNode root, int depth){
//         if(root == null) return 0;
//         if(depth == 1){
//             return root.val;
//         }
//         int left = solve(root.left, depth-1);
//         int right = solve(root.right, depth-1);
//         return left + right;
//     }
//     private int maxDepth(TreeNode root){
//         if(root == null) return 0;
//         int left = maxDepth(root.left);
//         int right = maxDepth(root.right);
//         return 1 + Math.max(left, right);
//     }
// }