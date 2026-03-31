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
class Pair{
    TreeNode node;
    int row;
    Pair(TreeNode node, int row){
        this.node = node;
        this.row = row;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int x = p.row;

            map.put(x, node.val);
            if(node.left != null)
                q.offer(new Pair(node.left, x+1));
            if(node.right != null)
                q.offer(new Pair(node.right, x+1));
        }
        for(Integer e : map.values()){
            ans.add(e);
        }
        return ans;
    }
}