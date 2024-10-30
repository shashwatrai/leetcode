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
    public void prepareGraph(TreeNode root,Map<TreeNode,Set<TreeNode>> adj,Map<TreeNode,Integer> inDegree , TreeNode parent){
        
        if(root == null){
            return;
        }
        if(!inDegree.containsKey(root))
            inDegree.put(root,0);
        
        if(!adj.containsKey(root)){
            adj.put(root,new HashSet<>());
        }

        if(parent != null){
            inDegree.put(parent,inDegree.getOrDefault(parent,0)+1);
            adj.get(root).add(parent);
        }

        prepareGraph(root.left,adj,inDegree,root);
        prepareGraph(root.right,adj,inDegree,root);
        
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode,Set<TreeNode>> adj = new HashMap<>();
        Map<TreeNode,Integer> inDegree = new HashMap<>();

        prepareGraph(root,adj,inDegree,null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        for(TreeNode i: inDegree.keySet()){
            if(inDegree.get(i) == 0)
                queue.add(i);
        }

        List<List<Integer>> res= new ArrayList<>();

        while(!queue.isEmpty()){
            int len = queue.size();

            List<Integer> temp= new ArrayList<>();
            while(len-- > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                for(TreeNode j: adj.get(node)){
                    inDegree.put(j,inDegree.get(j) - 1);
                    if(inDegree.get(j) == 0){
                        queue.add(j);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}