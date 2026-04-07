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
    public TreeNode bstFromPreorder(int[] preorder) {
        // a pointer in the form of array
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0}); 
    }
    private TreeNode bstFromPreorder(int[] A, int ub, int[] i){
        if(i[0] == A.length || A[i[0]] > ub) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstFromPreorder(A, root.val, i);
        root.right = bstFromPreorder(A, ub, i);
        return root;
    }
}