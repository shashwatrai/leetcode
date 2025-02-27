class Solution {
    public long findDist(long a, long b,long R){
        return Math.min(Math.max(a,b) - Math.min(a,b),
            Math.min(a,b) + R - Math.max(a,b));
    }
    public boolean check(int [][]points,int k,long dist,TreeSet<Long> perimeter,long side){
        long R = (long)((long)4*(long)side);
        for(int i=0;i<points.length;i++){
            long curr =0L;
             if(points[i][1] == 0){
                curr = (long)points[i][0];
            }else if(points[i][0] == 0){
                curr = (long)((long)3*(long)side + side - points[i][1]);
            }
            else if(points[i][0] == side){
                curr = (long)((long)side + (long)points[i][1]);
            }
            else{
                curr = (long)((long)2*(long)side + (long)side - points[i][0]);
            }

            long start = curr;
            int count = k;
            List<Long> arr = new ArrayList<>();
            TreeSet<Long> vis = new TreeSet<>();
            while(count > 0){
                if(vis.contains(start%R))
                    break;
                Long c = vis.ceiling(start%R);
                Long f = vis.floor(start%R);
                if((c != null && c - start%R < dist) || (f != null && start%R - f < dist))
                    break;
                vis.add(start%R);
                arr.add(start);

                
                Long next = perimeter.ceiling(start+dist);
                if(next == null)
                    break;
                start = perimeter.ceiling(start+dist);
                count--;
            }
            // System.out.println(curr+" "+dist+" "+arr);
            boolean found = arr.size() >= k ;
            if(arr.size() >= k){
                for(int j=0;j<arr.size();j++){
                    if(findDist(arr.get((j+1)%arr.size())%R,arr.get(j)%R,R) < dist){
                        found = false;
                        break;
                    }
                }
            }
            if(found)
                return true;
        }

        return false;

    }
    public int maxDistance(int side, int[][] points, int k) {
        long l = 1L,r = (long)((long)2*(long)side);
        TreeSet<Long> perimeter = new TreeSet<>();
        
        for(int i=0;i<points.length;i++){
            if(points[i][1] == 0){
                perimeter.add((long)points[i][0]);
                perimeter.add((long)((long)4* (long)side + (long)points[i][0]));
            }else if(points[i][0] == 0){
                perimeter.add((long)((long)3*(long)side + side - points[i][1]));
                perimeter.add((long)((long)7*(long)side + side - points[i][1]));
            }
            else if(points[i][0] == side){
                perimeter.add((long)((long)side + (long)points[i][1]));
                perimeter.add((long)((long)5*(long)side + points[i][1]));
            }
            else{
                perimeter.add((long)((long)2*(long)side + side - points[i][0]));
                perimeter.add((long)((long)6*(long)side + side - points[i][0]));
            }
            // System.out.println(perimeter);
        }
        
        while(l <= r){
            long mid = (long)((long)l+(long)r)/2;

            if(check(points,k,(long)mid,perimeter,(long)side)){
                l = (long)(mid+1L);
            }else
                r = (long)(mid-1L);
        }
        return (int)r;
    }
}