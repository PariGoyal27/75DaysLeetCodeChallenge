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
    List<Integer> ans;
    //Recursive
    // private void preorder(TreeNode node){
    //     if(node == null) return;
    //     ans.add(node.val);
    //     preorder(node.left);
    //     preorder(node.right);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        // preorder(root);
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
            ans.add(top.val);
        }
        return ans;
    }
}