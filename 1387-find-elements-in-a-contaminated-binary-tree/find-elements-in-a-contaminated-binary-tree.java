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
class FindElements {
    Set<Integer> vals;
    public void traverse(TreeNode root, int curr, Set<Integer> set){
        if(root == null)
           return;
        root.val = curr;
        set.add(curr);
        traverse(root.left, 2*curr +1,set);
        traverse(root.right, 2*curr + 2,set);
    }
    public FindElements(TreeNode root) {
        vals = new HashSet<>();
        traverse(root, 0, vals);
    }
    
    public boolean find(int target) {
        return vals.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */