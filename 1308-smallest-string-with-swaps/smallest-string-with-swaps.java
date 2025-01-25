class Solution {

    public int findParent(int a,int []parent){
        if(parent[a] == a)
            return a;
        
        return parent[a] = findParent(parent[a],parent);
    }

    public void merge(int a,int b,int []parent){
        a = findParent(a,parent);
        b = findParent(b,parent);

        if(a!=b){
            parent[b] = a;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char []arr = s.toCharArray();

        int []parent  = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        
        for(List<Integer> pair: pairs){
            merge(pair.get(0),pair.get(1),parent);
        }
        for(int i=0;i<n;i++){
            findParent(i,parent);
        }
        Integer sorted[] = new Integer[n];
        for(int i=0;i<n;i++)
            sorted[i] = i;
        Arrays.sort(sorted,(a,b)->arr[a]-arr[b]);
        Map<Integer,LinkedList<Character>> map  = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(parent[sorted[i]])){
                map.put(parent[sorted[i]],new LinkedList<>());
            }
            map.get(parent[sorted[i]]).add(arr[sorted[i]]);
        }
        for(int i=0;i<n;i++){
            arr[i] = map.get(parent[i]).pop();
        }
        return new String(arr);
    }
}