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
    private int height(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);

        if(Math.abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(height(root) == -1) return false;
        return true;
    }
}

/**
class Solution {
    private int height(TreeNode node){
        if(node == null) return 0;
        int left = 1 + height(node.left);
        int right = 1 + height(node.right);

        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        if(diff <= 1){
            boolean left = isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return left && right;
        }else{
            return false;
        }
    }
}
 */