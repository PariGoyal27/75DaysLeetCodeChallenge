/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //To have the track of parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        int cur_level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(cur_level == k)
                break;
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
            cur_level++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}