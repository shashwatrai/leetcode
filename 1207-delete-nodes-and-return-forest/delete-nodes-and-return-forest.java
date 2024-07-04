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
    TreeNode helper(TreeNode root,Set<Integer> set,List<TreeNode> res){
        if(root == null)
            return null;

        root.left = helper(root.left,set,res);
        root.right = helper(root.right,set,res);

        if(set.contains(root.val)){
            if(root.left != null)
                res.add(root.left);
            if(root.right != null)
                res.add(root.right);
            return null;
        }
        return root;
        
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> set = Arrays.stream(to_delete).collect(HashSet::new,HashSet::add,HashSet::addAll);

        List<TreeNode> res = new ArrayList<>();
        
            
        TreeNode ans = helper(root,set,res);
        if(ans != null )
            res.add(ans);
        return res;
    }
}