class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long arr[] = new long[26];
        long R = (long)1e9 + 7;
        for(int i=0;i<s.length();i++)
            arr[s.charAt(i)-'a']++;

        while(t > 0){
            // System.out.println(Arrays.toString(arr));
            while(t > 0 && arr[25] > 0L){
                t--;
                long temp = arr[25];
                arr[25] = 0;
                for(int i = 24;i>=0;i--){
                    arr[i+1] = arr[i];
                    arr[i] = 0;
                }
                arr[0] = (arr[0]%R + temp%R)%R;
                arr[1] = (arr[1]%R + temp%R)%R ;
            }
            int shift=0;
            for(int i=25;i>=0;i--){
                if(arr[i] > 0){
                    shift = 25-i;
                    break;
                }
            }
            shift = Math.min(shift,t);
            if(shift  == 0)
                break;
            for(int i=25-shift;i>=0;i--){
                arr[i+shift] = arr[i];
                arr[i] = 0;
            }
            // System.out.println(t+" "+shift);
            t-=shift;
        }
        // System.out.println(Arrays.toString(arr));
        long ans = 0L;
       
        for(int i=0;i<26;i++)
            ans= (ans%R + arr[i]%R)%R;
        return (int)ans;
    }
}