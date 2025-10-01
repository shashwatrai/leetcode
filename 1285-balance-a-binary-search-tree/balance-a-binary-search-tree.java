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
    public void traverse(TreeNode root, List<Integer> order){
        if(root == null)
            return;

        traverse(root.left,order);
        order.add(root.val);
        traverse(root.right,order);
    
    }
    public TreeNode prepare(List<Integer> order,int l, int r){

        if(l > r)
            return null;
        if(l==r){
            return new TreeNode(order.get(l));
        }

        int m = (l+r)/2;
        TreeNode left = prepare(order,l,m-1);
        TreeNode right = prepare(order,m+1,r);
        return new TreeNode(order.get(m),left,right);

    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> order = new ArrayList<>();

        traverse(root,order);

        return prepare(order,0,order.size()-1);
    }
}