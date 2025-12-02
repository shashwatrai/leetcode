class Solution {
    public long inverse(long a, long b,long R){

        long r = 1L;

        while(b > 0){
            if(b%2L == 1L){
                r = (r%R * a%R)%R;
            }
            a = (a%R * a%R)%R;
            b = (b/2L);
        }
        return r;

    }
    public int countTrapezoids(int[][] points) {
        long R = 1_000_000_007L;
        Map<Integer,Long> map = new HashMap<>();
        long in = inverse(2L,R-2L,R);
        for(int point[]:points){
            map.put(point[1],map.getOrDefault(point[1],0L)+1L);
        }

        long sum = 0L;
        for(int i:map.keySet()){
            long l = map.get(i);
            l = ((l%R * (l-1L+R)%R)%R * in%R)%R;
            map.put(i, l);
            sum = (sum%R + l%R)%R;
        }

        // System.out.println(map);
        long ans = 0L;

        for(int i:map.keySet()){
            ans = (ans%R + (map.get(i)%R * (sum - map.get(i) + R)%R)%R)%R;
        }

        return (int)((ans%R * in%R)%R);

    }
}