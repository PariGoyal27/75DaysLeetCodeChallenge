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
    List<String> ans = new ArrayList<>();

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    private void solve(TreeNode root, StringBuilder sb){
        if(root == null) return;
        int len = sb.length();
        if(isLeaf(root)){
            sb.append(root.val);
            ans.add(sb.toString());
        }else{
            sb.append(root.val + "->");
            solve(root.left, sb);
            solve(root.right, sb);
        }
        //Length before appending
        sb.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return ans;
    }
}