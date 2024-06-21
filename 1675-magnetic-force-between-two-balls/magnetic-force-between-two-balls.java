class Solution {
    public boolean isValid(int []arr,int m,int mid){
        int start = arr[0];
        int count=1;
       
        for(int i=1;i<arr.length && count < m;i++){
            if(arr[i] >= start+mid){
                start = arr[i];
                count++;
            }
        }
        
        return count ==m ? true:false;
    }
    public int maxDistance(int[] position, int m) {
            int n  = position.length;
            Arrays.sort(position);
            int l = 1;
            int r = position[n-1]-position[0];

            while(l<=r){
                int diff = (l+r)/2;
                
                if(isValid(position,m,diff)){
                    l = diff+1;
                }else
                    r = diff-1;
            }
            return r;
    }
}