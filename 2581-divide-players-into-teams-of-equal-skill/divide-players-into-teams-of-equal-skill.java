class Solution {
    public long dividePlayers(int[] skill) {
        int max = 0;
        int min = 1001;
        for(int i: skill){
            max = Math.max(i,max);
            min = Math.min(i,min);
        }

        int n = skill.length;

        int []freq = new int[max+1];
        for(int i:skill)    
            freq[i]++;
        long ans = 0L;
        for(int i=1;i<=max;i++){
            if(freq[i] == 0)
                continue;
            int x = i;
            int y = min + max - i;
            if(y > freq.length)
                return -1;
            if(x == y ){
                if(freq[x]%2 == 0){
                    ans += (long)((long)(freq[x]/2) * (long)x * (long)x);
                    freq[x] = 0;
                }else
                    return -1L;
            }else{
                if(freq[x] == freq[y]){
                    ans += (long)(((long)freq[x]) *(long) x * (long)y);
                    freq[x] = 0;
                    freq[y] = 0;
                }else{
                    return -1;
                }
            }
            
        }
        return ans;
        

    }
}