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
    public int traverse(TreeNode root,List<List<Integer>> res){
        
        if(root == null){
            return -1;
        }
        
        int lh = traverse(root.left , res);
        int rh = traverse(root.right,res);
        int ch = Math.max(lh,rh)+1;

        if(res.size() <= ch){
            res.add(new ArrayList<>());
        }
        res.get(ch).add(root.val);
        return ch;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> res= new ArrayList<>();
        traverse(root,res);
        return res;
    }
}