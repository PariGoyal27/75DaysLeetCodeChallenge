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

// O((logN)^2)
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if(lh == rh) return (1 << lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int getLeftHeight(TreeNode root){
        int cnt = 1;
        while(root.left !=  null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    private int getRightHeight(TreeNode root){
        int cnt = 1;
        while(root.right !=  null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
}

// O(N) Solution
// class Solution {
//     private int count(TreeNode node){
//         if(node == null) return 0;
//         int left = count(node.left);
//         int right = count(node.right);
//         return 1 + left + right;
//     }
//     public int countNodes(TreeNode root) {
//         if(root == null) return 0;
//         return count(root);
//     }
// }