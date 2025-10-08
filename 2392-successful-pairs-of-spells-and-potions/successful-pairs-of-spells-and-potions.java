class Solution {
    public int find(int []arr,int t){
        int  l = 0, r = arr.length-1;

        while(l<=r){
            int m  = (l+r)/2;

            if(arr[m] >= t)
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);

        int ans[] = new int[spells.length];

        for(int i=0;i<ans.length;i++){
            int t = (int)Math.ceil((double)((double)success/(double)spells[i]));

            ans[i] = potions.length - find(potions,t);
        }
        return ans;
    }
}