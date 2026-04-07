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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        if(reverse) pushAll(top.left);
        else pushAll(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode root){
        while(root != null){
            st.push(root);
            if(reverse)
                root = root.right;
            else
                root = root.left;
        }
    }
}
// Space Optimal
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j > k) j = r.next();
            else i = l.next(); 
        }
        return false;
    }
}
// Blind search
// class Solution {
//     HashSet<Integer> hs = new HashSet<>();
//     public boolean findTarget(TreeNode root, int k) {
//         if(root == null) return false;

//         int newTarget = k - root.val;
//         if(hs.contains(newTarget)) return true;
//         hs.add(root.val);
//         return findTarget(root.left, k) || findTarget(root.right, k);
//     }
// }