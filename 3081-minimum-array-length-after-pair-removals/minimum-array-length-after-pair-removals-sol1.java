class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();

        int vis[] = new int[n];

        Arrays.fill(vis,-1);

        int l = 0,r = n-1;
        while(l < r){
            if(nums.get(l).intValue() != nums.get(r).intValue()){
                vis[l] = r;
                vis[r] = l;
                r--;
                l++;
            }else
                break;
        }

        int indx =0;
        while(l < r && indx < n){
            if(vis[indx] != -1 && nums.get(indx).intValue() != nums.get(l).intValue() && nums.get(vis[indx]).intValue() != nums.get(r).intValue()){
                int temp = vis[indx];
                vis[indx] = l;
                vis[l] = indx;
                vis[r] = temp;
                vis[temp] = r;
                
                l++;
                r--;

            }
            indx++;
        }
        
        return r - l + 1;   
    }
}
