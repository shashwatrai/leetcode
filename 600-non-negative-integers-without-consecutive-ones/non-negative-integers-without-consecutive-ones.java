class Solution {

    public int calculate(int []arr,int n){
        int next2spower = n+1;
        next2spower |= next2spower >>> 1;
        next2spower |= next2spower >>> 2;
        next2spower |= next2spower >>> 4;
        next2spower |= next2spower >>> 8;
        next2spower |= next2spower >>> 16;

        int indx = (int)(Math.log(next2spower+1)/Math.log(2));

        if(n+1 == (next2spower+1)/2 )
            return indx > 1 ? arr[indx-2] : 0;

        System.out.println(indx+" "+next2spower+" "+(next2spower+1)+" "+Arrays.toString(arr));

        int ans = Math.max(0,n + 1 -  (next2spower+1)/2 - (next2spower+1)/4)
                             + (indx > 1 ? arr[indx-2] : 0) 
                             + calculate(arr,Math.min(n-(next2spower+1)/2, (next2spower+1)/4));
        return ans;
    }
    public int findIntegers(int n) {
        int []arr = new int[32];

        arr[0] = 0;

        for(int i=1;i<32;i++){
            arr[i] = (int)Math.pow(2,i-1) +( i>1 ? arr[i-2] : 0)+ (i > 1 ? arr[i-1] : 0);
        }

        int next2spower = n;
        next2spower |= next2spower >>> 1;
        next2spower |= next2spower >>> 2;
        next2spower |= next2spower >>> 4;
        next2spower |= next2spower >>> 8;
        next2spower |= next2spower >>> 16;

        int indx = (int)(Math.log(next2spower+1)/Math.log(2));
        System.out.println(indx+" "+next2spower+" "+(next2spower+1)+" "+Arrays.toString(arr));
        int ans = calculate(arr,n);
        return n+1-ans;
    }
}