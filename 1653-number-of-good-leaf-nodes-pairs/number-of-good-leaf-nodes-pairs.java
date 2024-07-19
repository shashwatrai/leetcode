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
    public int traverse(TreeNode root,  Map<TreeNode , Map<Integer,Integer>> map,int distance){
    if(root == null)
      return 0;

    int left = traverse(root.left, map,distance);
    int right = traverse(root.right,map,distance);
    int curr=0;
    map.put(root, new HashMap<>());
    if(root.left != null && root.right != null){
      for(int l:map.get(root.left).keySet()){
        for(int r: map.get(root.right).keySet()){
          if(l+r+2 <= distance){
            curr += map.get(root.left).get(l) * map.get(root.right).get(r);
          }
        }
      }
      
      for(int l:map.get(root.left).keySet()){
        map.get(root).put(l+1,map.get(root).getOrDefault(l+1,0) + map.get(root.left).get(l));
      }
      for(int r:map.get(root.right).keySet()){
        map.get(root).put(r+1,map.get(root).getOrDefault(r+1,0)  + map.get(root.right).get(r));
      }
    }else if(root.left != null){

      for(int l:map.get(root.left).keySet()){
        map.get(root).put(l+1,map.get(root).getOrDefault(l+1,0) + map.get(root.left).get(l));
      }
    }else if(root.right != null){

      for(int r:map.get(root.right).keySet()){
        map.get(root).put(r+1,map.get(root).getOrDefault(r+1,0)  + map.get(root.right).get(r));
      }
    }else{
      map.get(root).put(0,1);
      map.get(root).put(0,1);
    }
    // System.out.println(root.val+" "+left+" "+curr+" "+right);
    return left +curr + right;
  }
    public int countPairs(TreeNode root, int distance) {
         Map<TreeNode , Map<Integer,Integer>> map = new HashMap<>();

    return traverse(root, map,distance);
    }
}