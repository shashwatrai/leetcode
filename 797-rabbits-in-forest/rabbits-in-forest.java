class Solution {
    public int numRabbits(int[] answers) {
        int ans[] = new int[1001];

        for(int i:answers){
            ans[i]++;
        }
        int res=0;

        for(int i=0;i<1000;i++)
            res += (i+1)*((ans[i]+i)/(i+1));
        
        return res;
    }
}