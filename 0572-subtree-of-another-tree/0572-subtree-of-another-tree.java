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
    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null || q == null) return p == q;

        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return root == subRoot;
        if(isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}