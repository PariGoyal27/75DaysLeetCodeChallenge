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
    List<List<Integer>> result;
    private void preorder(TreeNode root, int target, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        target -= root.val;
        //is leaf?
        if(root.left == null && root.right == null){
            if(target == 0) result.add(new ArrayList<>(list));
        }
        preorder(root.left, target, list);
        preorder(root.right, target, list);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        preorder(root, targetSum, new ArrayList<>());
        return result;
    }
}