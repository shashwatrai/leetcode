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
    public void inOrder(TreeNode root,List<Integer> res){
        if(root == null)
            return;
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);

    }
    public TreeNode prepareTree(List<Integer> res,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode left = prepareTree(res,start,mid-1);
        TreeNode right = prepareTree(res,mid+1,end);
        TreeNode node = new TreeNode(res.get(mid),left,right);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        inOrder(root,res);

        return prepareTree(res,0,res.size()-1);
    }
}