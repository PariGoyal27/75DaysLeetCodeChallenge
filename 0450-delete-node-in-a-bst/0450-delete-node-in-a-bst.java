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
    TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {        
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // case 1: no child
            if (root.left == null && root.right == null)
                return null;

            // case 2: one child
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // case 3: two children
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}
// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root == null) return null;
//         if(root.val == key){
//             return helper(root);
//         }
//         TreeNode org = root;
//         while(root != null){
//             if(root.val > key){
//                 if(root.left != null && root.left.val == key){
//                     root.left = helper(root.left);
//                     break;
//                 }else{
//                     root = root.left;
//                 }
//             }
//             else{
//                 if(root.right != null && root.right.val == key){
//                     root.right = helper(root.right);
//                     break;
//                 }else{
//                     root = root.right;
//                 }
//             }
//         }
//         return org;
//     }

//     private TreeNode helper(TreeNode root) {
//         if (root.left == null)
//             return root.right;
//         if (root.right == null)
//             return root.left;
//         TreeNode rightChild = root.right;
//         TreeNode lastRight = findLastRight(root.left);
//         lastRight.right = rightChild;
//         return root.left;
//     }

//     private TreeNode findLastRight(TreeNode root) {
//         if (root.right == null)
//             return root;
//         return findLastRight(root.right);
//     }
// }