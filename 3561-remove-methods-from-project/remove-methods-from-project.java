class Solution {
    public void traverse1(Map<Integer,List<Integer>> adj, int curr, int arr[]){
        arr[curr] = 2;

        if(adj.containsKey(curr)){
            for(int i: adj.get(curr)){
                if(arr[i] == 2)
                    continue;
                
                traverse1(adj,i,arr);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int arr[] = new int[n];

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int edge[] : invocations){
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0], new ArrayList<>());
            
            adj.get(edge[0]).add(edge[1]);
        }

        traverse1(adj,k,arr);
        boolean flag = false;
        for(int edge[] : invocations){
            if(arr[edge[1]] == 2 && arr[edge[0]] == 0){
                flag = true;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
            if(flag || arr[i] == 0)
                ans.add(i);
            
        return ans;

    }
}