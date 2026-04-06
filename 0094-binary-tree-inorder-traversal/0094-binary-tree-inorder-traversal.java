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
 //Inorder - Using Threaded Binary tree - Morris Traversal
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr; // Creating thread
                    curr = curr.left; // moving left
                }else{
                    prev.right = null; // removing thread
                    ans.add(curr.val);
                    curr = curr.right; // curr can move right now
                }
            }
        }
        return ans;
    }
}
// Recursive and Iterative
// class Solution {
//     private List<Integer> ans;
//     //Recursive
//     // private void inorder(TreeNode node){
//     //     if(node == null) return;
//     //     inorder(node.left);
//     //     ans.add(node.val);
//     //     inorder(node.right);
//     // }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         ans = new ArrayList<>();
//         // inorder(root);
//         if(root == null) return ans;
//         //Iterative
//         Stack<TreeNode> st = new Stack<>();
//         TreeNode node = root;

//         while(true){
//             if(node != null){
//                 st.push(node);
//                 node = node.left;
//             }else{
//                 if(st.isEmpty()) break;
//                 node = st.pop();
//                 ans.add(node.val);
//                 node = node.right;
//             }
//         }
//         return ans;
//     }
// }