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
    private int count(TreeNode node){
        if(node == null) return 0;
        int left = count(node.left);
        int right = count(node.right);
        return 1 + left + right;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return count(root);
    }
}