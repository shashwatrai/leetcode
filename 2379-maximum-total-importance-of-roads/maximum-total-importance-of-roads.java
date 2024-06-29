class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int deg[]= new int[n];

        for(int i=0;i<roads.length;i++){
            deg[roads[i][0]]++;
            deg[roads[i][1]]++;
        }

        Arrays.sort(deg);

        long sum=0;
        for(int i=1;i<=n;i++){
            sum += (long)deg[i-1] * i;
        }

        return sum;
    }
}