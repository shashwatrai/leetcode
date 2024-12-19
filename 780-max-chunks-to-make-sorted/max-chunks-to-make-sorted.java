class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        int count=0;
        for(int i=0;i<n;i++){
            max = Math.max(arr[i],max);
            if(max == i)
                count++;
        }
        return count;

        
    }
}