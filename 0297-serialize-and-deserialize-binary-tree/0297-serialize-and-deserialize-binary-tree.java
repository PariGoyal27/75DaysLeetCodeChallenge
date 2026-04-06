/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp == null){
                ans.append("n ");
                continue;
            }
            ans.append(temp.val + " ");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1; i < nodes.length; i++){
            TreeNode temp = q.poll();
            if(!nodes[i].equals("n")){
                temp.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(temp.left);
            }
            if(!nodes[++i].equals("n")){
                temp.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(temp.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));