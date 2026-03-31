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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return ans;
    }
}
// class Solution {
//     List<Integer> ans;
//     // Recursive
//     // private void postorder(TreeNode node){
//     //     if(node == null) return;
//     //     postorder(node.left);
//     //     postorder(node.right);
//     //     ans.add(node.val);
//     // }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         ans = new ArrayList<>();
//         // postorder(root);
//         //Iterative
//         if(root == null) return ans;
//         Stack<TreeNode> st1 = new Stack<>();
//         // Stack<Integer> st2 = new Stack<>();
//         st1.push(root);
//         while(!st1.isEmpty()){
//             TreeNode node = st1.pop();
//             // st2.push(node.val);
//             ans.add(node.val);
//             if(node.left != null) st1.push(node.left);
//             if(node.right != null) st1.push(node.right);
//         }
//         // while(!st2.isEmpty()){
//         //     ans.add(st2.pop());
//         // }
//         Collections.reverse(ans);
//         return ans;
//     }
// }