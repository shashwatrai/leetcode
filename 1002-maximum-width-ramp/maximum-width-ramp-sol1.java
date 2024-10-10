class Pair{
    int indx;
    int len;

    Pair(int i,int l){
        this.indx = i;
        this.len = l;
    }
}
class Solution {
    public int maxWidthRamp(int[] nums) {
        TreeMap<Integer,Pair> tMap = new TreeMap<>();
        int n = nums.length;
        int ans = 0;
        for(int i= n-1;i>=0;i--){
           
            Integer indx = tMap.ceilingKey(nums[i]);
            int temp = 0;
            if(indx != null){
                temp = tMap.get(indx).len + tMap.get(indx).indx - i;
            }

            
            ans = Math.max(ans, temp);
            
            tMap.put(nums[i],new Pair(i,temp));
        }
        return ans;
    }
}
