class Solution {
    public void helper(List<Integer> arr, int indx, int k, List<Integer> ans, List<List<Integer>> finalAns){
        if(ans.size() == k){
            finalAns.add(new ArrayList<>(ans));
            return ;
        }

        for(int i=indx ;i + k - ans.size() - 1< arr.size() ;i++){
            ans.add(arr.get(i));
            helper(arr,i+1,k,ans,finalAns);
            ans.remove(ans.size() -1);
        }
    }

    public List<List<Integer>> generateSelection(List<Integer> res,int k){
        List<List<Integer>> finalArr = new ArrayList<>();
        helper(res,0,Math.min(res.size(),k),new ArrayList<>(),finalArr);
        return finalArr;
    }
    public int traverse(int mask,int n,int k,Map<Integer,Set<Integer>> adj,int []inDegree,Map<Integer,Integer> map){
        if(mask == 0)
            return 0;
        
        if(map.containsKey(mask))
            return map.get(mask);

        
        List<Integer> prerequistes = new ArrayList<>();


        for(int i=0;i<n;i++){
            // System.out.println((mask & (1<<i))+" "+inDegree[i] +" "+((mask & (1<<i)) != 0 && inDegree[i] == 0));
            if((mask & (1<<i)) != 0 && inDegree[i] == 0){
                
                prerequistes.add(i);
            }
        }
        
        List<List<Integer>> selections = generateSelection(prerequistes,k);
        Integer ans = Integer.MAX_VALUE;
        // System.out.println(" prerequistes:"+ prerequistes+" "+selections);
        for(List<Integer> curr: selections){
            int newmask = mask;
            int newInDegree[] = inDegree.clone();
            for(int i:curr){
                newmask = newmask ^ (1<<i);
                newInDegree[i]--;
                if(!adj.containsKey(i))
                    continue;
                for(int j: adj.get(i)){
                    newInDegree[j]--;
                }
            }
            // System.out.println(mask+" "+newmask+" "+curr+" "+Arrays.toString(newInDegree));
            ans = Math.min(1+traverse(newmask,n,k,adj,newInDegree,map),ans);
        }
        map.put(mask,ans);
        return ans;
    }
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        Map<Integer,Set<Integer>> adj = new HashMap<>();
        int []inDegree = new int[n];

        for(int i[]:relations){
            if(!adj.containsKey(i[0]-1))
                adj.put(i[0]-1,new HashSet<>());
            adj.get(i[0]-1).add(i[1]-1);
            inDegree[i[1]-1]++;
        }
        System.out.println(Arrays.toString(inDegree));
        int mask = 0;
        for(int i=0;i<n;i++){
            mask |= 1<<i;
        }

        return traverse(mask,n,k,adj,inDegree,new HashMap<>());
    }
}