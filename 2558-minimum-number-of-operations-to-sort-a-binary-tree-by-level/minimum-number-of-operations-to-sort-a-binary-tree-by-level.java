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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int ans=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<int[]> arr = new ArrayList<>();
            boolean []vis = new boolean[len];
            int indx=0;
            while(len-- > 0){
                TreeNode curr = queue.poll();
                arr.add(new int[]{curr.val,indx++});
                if(curr.left != null){
                    queue.add(curr.left);
                   
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }

            Collections.sort(arr,(a,b) -> a[0]-b[0]);
            int start=0;
            for(int i=0;i<vis.length;i++){

                if(!vis[i]){
                    if(arr.get(i)[1] != i){
                        int end =i;
                        int count=0;
                        while(!vis[end]){
                            vis[end] = true;
                            end = arr.get(end)[1];
                            count++;
                        }
                        ans+=count-1;
                    }
                }
            }
        }  
        return ans; 
    }
}