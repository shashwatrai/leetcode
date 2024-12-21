class Solution {

    public long traverse(Map<Integer,Set<Integer>> map,int curr,int parent, int []values,int k,int count[]){
        long sum= (long)values[curr];
        if(map.containsKey(curr)){
            for(int x : map.get(curr)){
                if(x == parent)
                    continue;
                sum += traverse(map,x,curr,values,k,count);
            }
        }
        if(sum%k == 0){
            sum =0;
            count[0]++;
        }
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        
        
        Map<Integer,Set<Integer>> map = new HashMap<>();

        for(int i[]:edges){
            if(!map.containsKey(i[0]))
                map.put(i[0],new HashSet<>());

            if(!map.containsKey(i[1]))
                map.put(i[1],new HashSet<>());

            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }

        int count[] = new int[1];
        traverse(map,0,-1,values,k,count);
        return count[0];
    }
}