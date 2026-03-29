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
    private int solve(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = 1 + solve(node.left);
        int right = 1 + solve(node.right);

        return Math.max(left, right);
    }
    public int maxDepth(TreeNode root) {
        return solve(root);
    }
}