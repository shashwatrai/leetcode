class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        

        int max = Integer.MIN_VALUE;

        int min[] = new int[n];
        min[n-1] = Integer.MAX_VALUE;

        for(int i=n-2;i>=0;i--){
            min[i] = Math.min(min[i+1],arr[i+1]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            max = Math.max(arr[i],max);
            if(max <= min[i])
                count++;
        }
        return count;

        
    }
}