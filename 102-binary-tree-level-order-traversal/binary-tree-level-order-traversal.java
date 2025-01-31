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
    public void traverse(TreeNode root,List<List<Integer>> res, int level){
        if(root == null)
            return ;
        
        if(res.size() == level)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        traverse(root.left,res,level+1);
        traverse(root.right,res,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root,res,0);
        return res;
    }
}