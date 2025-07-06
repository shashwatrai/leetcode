class Solution {
    public int possibleStringCount(String word, int k) {
        List<Integer> arr = new ArrayList<>();
        int n = word.length();
        int l = 0;
        char c = '-';
        for(int i=0;i<n;i++){
            if(c == word.charAt(i))
                l++;
            else{
                arr.add(l);
                c = word.charAt(i);
                l = 1;
            }
        }

        arr.add(l);

        
        long prev[] = new long[k];

        for(int i=1;i<=arr.get(1) && i < k;i++)
            prev[i] = 1L;

        long R = 1_000_000_007;
       
        long total = arr.get(1);
        for(int i=2;i<arr.size();i++){
            total = ((total%R) * (arr.get(i)%R))%R;
            int start = i-1;
            long temp  = start < k ? prev[start]: 0L;
            long curr[] = new long[k];
            for(int j=i;j<k;j++){
                curr[j] = temp;
                if(j-start + 1 > arr.get(i)){
                    temp = (temp%R - prev[start++]%R + R)%R;
                }
                temp = (temp%R + prev[j]%R)%R;
            }
            
            prev = curr;
            // System.out.println(Arrays.toString(prev));
           
            
        }
        
        long validSum = 0L;
        for(long i: prev){
            validSum  = (validSum%R + i%R)%R;
        }
        
        return (int)(((total%R - validSum%R + R)%R));
        
    
    }
}