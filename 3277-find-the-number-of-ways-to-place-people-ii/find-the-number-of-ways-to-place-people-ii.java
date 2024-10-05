class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b)-> a[0] != b[0] ? a[0]- b[0] : b[1]-a[1]);

        int count=0;

        for(int i=0;i<points.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i+1;j<points.length;j++){
                if(points[i][1] >= points[j][1]){
                    if(max == Integer.MIN_VALUE || max < points[j][1]){
                        count++;
                    }
                    max = Math.max(max,points[j][1]);
                }
            }
        }
        return count;
    }
}