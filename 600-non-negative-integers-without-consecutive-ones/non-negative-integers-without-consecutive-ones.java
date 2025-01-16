class Solution {

    public int findAns(int []arr,int n){
        if(n == 0)
            return 1;
        int next = n;
        next |= next >>> 1;
        next |= next >>> 2;
        next |= next >>> 4;
        next |= next >>> 8;
        next |= next >>> 16;

        int indx  = (int)(Math.log((next+1))/Math.log(2));
        if(next == n){
            return arr[indx];
        }
        System.out.println(n+" "+next + " "+indx+" "+Arrays.toString(arr));
        return arr[indx-1] + findAns(arr,Math.min(n-(next+1)/2,(next+1)/4 - 1));
    }
    public int findIntegers(int n) {
    
        int arr[] = new int[32];

        arr[0] = 1;

        for(int i=1;i<32;i++)
            arr[i] = arr[i-1] + ( i> 1? arr[i-2] : 1);

        
        return findAns(arr,n);
    }
}