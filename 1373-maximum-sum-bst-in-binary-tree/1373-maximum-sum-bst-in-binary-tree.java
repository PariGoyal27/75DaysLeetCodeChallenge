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
class NodeValue{
    int maxSum, minNode, maxNode;
    NodeValue(int sum, int min, int max){
        this.maxSum = sum;
        this.minNode = min;
        this.maxNode = max;
    }
}
class Solution {
    int ans = 0;
    private NodeValue maxSumBSTHelper(TreeNode root){
        if(root == null)
            return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        NodeValue left = maxSumBSTHelper(root.left);
        NodeValue right = maxSumBSTHelper(root.right);
        
        if(root.val > left.maxNode && root.val < right.minNode){
            // A Valid BST
            int sum = root.val + left.maxSum + right.maxSum;
            ans = Math.max(ans, sum);
            return new NodeValue(sum, 
            Math.min(root.val, left.minNode),
            Math.max(root.val, right.maxNode));
        }else{
            // Invalid BST
            return new NodeValue(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return ans;
    }
}