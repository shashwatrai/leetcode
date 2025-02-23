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
    public TreeNode construct(int []preorder,int postorder[],
            Map<Integer,Integer> premap,Map<Integer,Integer> postmap,
            int s1,int e1,int s2,int e2){
        // System.out.println(s1+" "+e1+" "+s2+" "+e2);
        if(s1 == preorder.length || s2 == postorder.length || s1 > e1 || s2 > e2)
            return null;
        else if(s1 == e1 && s2 == e2)
            return new TreeNode(preorder[s1]);

        
        int mid2 = postmap.get(preorder[s1+1]);
        int mid1 = s1+ mid2-s2+1;
        TreeNode left = construct(preorder,postorder,premap,postmap,s1+1,mid1,s2,mid2);
        TreeNode right = construct(preorder,postorder,premap,postmap,mid1+1,e1,mid2+1,e2-1);
        return new TreeNode(preorder[s1],left,right);
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer,Integer> postMap = new HashMap<>();
        Map<Integer,Integer> preMap = new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            postMap.put(postorder[i],i);
            preMap.put(preorder[i],i);
        }
        return construct(preorder,postorder,preMap,postMap,0,preorder.length-1,0,postorder.length-1);
    }
}