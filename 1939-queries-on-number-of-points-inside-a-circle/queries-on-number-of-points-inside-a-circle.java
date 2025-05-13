class Node{
    int []point;
    int op;
    Node left, right;
}
class Solution {
    public void traverse(Node root, int []query,int ans[]){
        if(root == null)
            return;
        
        boolean isValid = (root.point[0] - query[0])* (root.point[0] - query[0]) + 
             (root.point[1] - query[1]) * (root.point[1] - query[1])  <= query[2] * query[2];
            
        if(isValid)
            ans[0]++;
        // System.out.println(Arrays.toString(root.point)+" "+Arrays.toString(query));
        if(root.op == 1){
            if(root.point[1] <= query[1] + query[2] && root.point[1] >= query[1] - query[2]){
                traverse(root.left,query,ans);
                traverse(root.right,query,ans);
            }else if(root.point[1] > query[1] + query[2]){
                traverse(root.left,query,ans);
            }else if(root.point[1] < query[1] - query[2]){
                traverse(root.right,query,ans);
            }
        }else{
            if(root.point[0] <= query[0] + query[2] && root.point[0] >= query[0] - query[2]){
                traverse(root.left,query,ans);
                traverse(root.right,query,ans);
            }else if(root.point[0] > query[0] + query[2]){
                traverse(root.left,query,ans);
            }else if(root.point[0] < query[0] - query[2]){
                traverse(root.right,query,ans);
            }
        }
    }
    public void test(Node root){
        if(root == null)
            return;
        
        test(root.left);
        System.out.println(Arrays.toString(root.point));
        test(root.right);
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        // Arrays.sort(points,(a,b) -> a[0] - b[0]);
        Node root = null;
        for(int i=0;i<points.length;i++){
            Node curr = new Node();
            curr.point  = points[i];
            if(root == null){
                curr.op = 0;
                root = curr;
            }else{
                Node temp = root,prev = null;
                System.out.println();
                while(temp != null){
                    prev = temp;
                    
                    if(temp.op == 0){
                        if(temp.point[0] > curr.point[0]){
                            temp = temp.left;
                        }else{
                            // System.out.println("right "+Arrays.toString(temp.point));
                            temp = temp.right;
                        }

                    }else{
                        if(temp.point[1] > curr.point[1]){
                            temp = temp.left;
                        }else{
                            // System.out.println("right "+Arrays.toString(temp.point));
                            temp = temp.right;
                        }
                    }
                }
                // System.out.println(Arrays.toString(prev.point)+" "+prev.op);
                if(prev.op == 0){
                    curr.op = 1;
                    if(prev.point[0] > curr.point[0]){
                        prev.left = curr;
                    }else
                        prev.right = curr;
                }else{
                    curr.op = 0;
                    if(prev.point[1] > curr.point[1]){
                        prev.left = curr;
                    }else{
                        // System.out.println("curr" + Arrays.toString(curr.point));
                        prev.right = curr;
                    }
                }
            }   
        }

        // test(root);
        int ans[] = new int[queries.length];

        for(int i=0;i<ans.length;i++){
            int res[] = new int[1];
            traverse(root,queries[i],res);
            ans[i] = res[0];
        }
        return ans;
    }
}