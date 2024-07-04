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
    void helper(TreeNode root,TreeNode parent,Set<Integer> set,List<TreeNode> res){
        if(root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if(set.contains(root.val)){
            if(parent != null){
                if(parent.left == root)
                    parent.left = null;
                else
                    parent.right = null;
            }
            root.left = null;
            root.right = null;
            if(left != null && !set.contains(left.val))
                res.add(left);
            if(right != null && !set.contains(right.val))
                res.add(right);
        }
        helper(left,root.left ==left?root:null,set,res);
        helper(right,root.right ==right?root:null,set,res);
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> set = Arrays.stream(to_delete).collect(HashSet::new,HashSet::add,HashSet::addAll);

        List<TreeNode> res = new ArrayList<>();
        if(!set.contains(root.val))
            res.add(root);
        helper(root,null,set,res);

        return res;
    }
}