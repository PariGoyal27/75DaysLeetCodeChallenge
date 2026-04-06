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
// Preorder - Using threaded binary tree
class Solution{
    public List<Integer> preorderTraversal(TreeNode root){
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
                    prev.right = curr;
                    ans.add(curr.val); // when you have marked a thread
                    curr = curr.left;
                }else{
                    prev.right = null; //remove thread
                    curr = curr.right; //curr can move right
                }
            }
        }
        return ans;
    }
}

// class Solution {
//     List<Integer> ans;
//     //Recursive
//     // private void preorder(TreeNode node){
//     //     if(node == null) return;
//     //     ans.add(node.val);
//     //     preorder(node.left);
//     //     preorder(node.right);
//     // }
//     public List<Integer> preorderTraversal(TreeNode root) {
//         ans = new ArrayList<>();
//         // preorder(root);
//         if(root == null) return ans;
//         Stack<TreeNode> st = new Stack<>();
//         st.push(root);
//         while(!st.isEmpty()){
//             TreeNode top = st.pop();
//             if(top.right != null) st.push(top.right);
//             if(top.left != null) st.push(top.left);
//             ans.add(top.val);
//         }
//         return ans;
//     }
// }