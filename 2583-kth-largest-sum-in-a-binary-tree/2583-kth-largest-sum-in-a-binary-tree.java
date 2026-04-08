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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(); //min-heap
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if(tmp.left != null)
                    q.offer(tmp.left);
                if(tmp.right != null)
                    q.offer(tmp.right);
            }
            level++;
            pq.offer(sum);
            if(pq.size() > k){
                pq.poll();
            }
        }
        if(level < k) return -1;
        return pq.peek();
    }
}