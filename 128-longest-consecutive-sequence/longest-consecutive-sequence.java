class Solution {
    public int findParent(int a, int []parent){
        if(a== parent[a])
            return a;
        return parent[a] = findParent(parent[a],parent);
    }
    public void merge(int a,int b,int []parent,int []sizes){
        a =  findParent(a,parent);
        b =  findParent(b,parent);
        if(a!=b){
            parent[b] = a;
            sizes[a] +=sizes[b];
        }
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        if(n == 0)
            return 0;
        int []sizes = new int[n];
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            sizes[i] = 1;
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]))
                continue;
            map.put(nums[i],i);

            if(map.containsKey(nums[i]-1)){
                merge(i,map.get(nums[i]-1),parent,sizes);
            }

            if(map.containsKey(nums[i]+1)){
                merge(map.get(nums[i]+1),i,parent,sizes);
            }
        }
        int size = 1;
        for(int i:sizes){
            size  = Math.max(size,i);
        }
        return size;
    }
}