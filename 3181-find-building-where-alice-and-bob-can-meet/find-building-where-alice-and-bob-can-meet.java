class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        
        for(int i[]:queries){
            if(i[0] > i[1]){
                int t = i[1];
                i[1] = i[0];
                i[0] = t;
            }
        }

        int [][]q = new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }

        Arrays.sort(q,(x,y) ->  y[1] - x[1]);
        int []arr= new int[heights.length];
        int []ans= new int[q.length];
        int top = -1;
        int indx = heights.length-1;
        for(int x[] : q){
            while(x[1] < indx){
                while(top != -1 && heights[arr[top]] <= heights[indx]){
                    top--;
                }
                arr[++top]  = indx--;
            }

            if( x[1] == x[0] || heights[x[0]] < heights[x[1]]  ){
                ans[x[2]] = x[1];
            }else{
                int l = 0,r = top;
                while(l<=r){
                    
                    int m = (l+r)/2;
                    // System.out.println(l+" "+r+" "+(heights[arr[m]] >  heights[x[0]] ));
                    if(heights[arr[m]] >  heights[x[0]] )
                        l = m+1;
                    else
                        r = m-1;
                }
                
                ans[x[2]]  = r != -1 ? arr[r]:r;
            }
            // System.out.println(Arrays.toString(arr)+" "+x[0]+" "+x[1]+" "+Arrays.toString(ans));
        }
        return ans;
    }
}