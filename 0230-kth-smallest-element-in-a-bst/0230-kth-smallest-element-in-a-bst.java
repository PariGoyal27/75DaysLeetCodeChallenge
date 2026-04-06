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
    int ans = -1;
    int cnt;
    private void inorder(TreeNode root){
        if(root == null) return;
        if(cnt == 0) return;

        inorder(root.left);
        cnt--;
        if(cnt == 0) { 
//cnt ko zero krna is necessary kyuki 1 ko agr base condition me rkh doge to wrong answer milega
            ans = root.val;
            return;
        }
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inorder(root);
        return ans;
    }
}