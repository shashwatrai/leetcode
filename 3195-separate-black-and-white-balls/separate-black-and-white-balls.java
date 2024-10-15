class Solution {
    public long minimumSteps(String s) {
        char []arr = s.toCharArray();

        long count=0L;
        int last =-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '0'){
                count += (long) i - last -1;
                last++;
            }
        }
        return count;
    }
}