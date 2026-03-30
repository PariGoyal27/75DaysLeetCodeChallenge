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
    int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return diam;
    }
    private int solve(TreeNode node){
        if(node == null) return 0;
        int left = solve(node.left); // left height
        int right = solve(node.right); // right height
        diam = Math.max(diam, left + right); // path length = leftHeight + rightHeight
        return 1 + Math.max(left, right); // finding max as we want height not any path from left & right
    }
}