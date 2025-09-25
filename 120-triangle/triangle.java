class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int []prev = new int[triangle.get(triangle.size()-1).size()];

        Arrays.fill(prev,Integer.MAX_VALUE);
        prev[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            // System.out.println(Arrays.toString(prev));
            int curr[] = new int[prev.length];
            Arrays.fill(curr,Integer.MAX_VALUE);
            for(int j=0;j<triangle.get(i).size();j++){
                curr[j] = Math.min(curr[j],triangle.get(i).get(j) + 
                            Math.min(prev[j],j > 0 ? prev[j-1]:Integer.MAX_VALUE));
            }
            prev = curr;
           
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<prev.length;i++){
            ans = Math.min(ans,prev[i]);
        }
        return ans;
        
    }
}