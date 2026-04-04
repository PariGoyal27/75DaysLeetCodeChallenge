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
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
                parent.put(curr.left, curr);
            }
            if(curr.right != null){
                q.offer(curr.right);
                parent.put(curr.right, curr);
            }
        }
    }
    private TreeNode searchStart(TreeNode root, int start){
        if(root == null) return null;
        if(root.val == start){
            return root;
        }
        TreeNode left = searchStart(root.left, start);
        if(left != null) return left;
        return searchStart(root.right, start);        
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);
        // First we need to search for start node
        TreeNode startNode = searchStart(root, start);
        System.out.println(startNode.val);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(startNode);
        visited.add(startNode);
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if(parent.get(curr) != null && !visited.contains(parent.get(curr))){
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
            if(!q.isEmpty())
                minutes++;
        }
        return minutes;
    }
}