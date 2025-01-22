class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int []arr = new int[triangle.get(triangle.size()-1).size()];
        arr[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            int curr[] = new int[arr.length];
            for(int j=0;j<triangle.get(i).size();j++){
                curr[j] = triangle.get(i).get(j) + Math.min(j<i?arr[j]:Integer.MAX_VALUE, j > 0 ? arr[j-1]:Integer.MAX_VALUE);
            }
            // System.out.println(Arrays.toString(curr));
            arr = curr;
        }
        int ans=Integer.MAX_VALUE;
        for(int i:arr)
            ans = Math.min(i,ans);
        return ans;

    }
}