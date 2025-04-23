class Solution {
    public int findSum(int t){
        int r = 0;
        while(t > 0){
            r += t%10;
            t/=10;
        }
        return r;
    }
    public int countLargestGroup(int n) {
        int []arr = new int[37];

        for(int i=1;i<=n;i++){
            arr[findSum(i)]++;
        }
        int ans =0,max = -1 ;
        for(int i:arr){
            if(i > 0 ){
                if(max < i){
                    max = i;
                    ans = 1;
                }else if(max == i){
                    ans++;
                }
            }
        }
        return ans;
    }
}