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
    public TreeNode solve(int nums[],int l,int r){
        // System.out.println(l+" "+r);
        if(l > r)
            return null;
        if(l == r){
            return new TreeNode(nums[l]);
        }
        int indx = l;
        int max = nums[indx];
        for(int i=l;i<=r;i++){
            if(max < nums[i]){
                indx  = i;
                max = nums[i];
            }
        }
        TreeNode left = solve(nums,l,indx-1);
        TreeNode right = solve(nums,indx+1,r);
    
        TreeNode root = new TreeNode(nums[indx],left,right);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
}