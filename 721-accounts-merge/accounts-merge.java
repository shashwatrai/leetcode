class Solution {

    public int findParent(int []parent,int a){
        if(parent[a] == -1)
            return a;
        return parent[a] = findParent(parent,parent[a]);
    }

    public void merge(int parent[], int a,int b){
        a = findParent(parent,a);
        b = findParent(parent,b);

        if (a!=b) {
            parent[b] = a;
        } 
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int []parent = new int[n];
        Arrays.fill(parent,-1);
        for(int i=1;i<n;i++){
            for(int j = 0;j<i;j++){
                
                if(accounts.get(j).get(0).compareTo(accounts.get(i).get(0)) == 0){
                    HashSet<String> hashSet = new HashSet(accounts.get(j));
                    for(int k = 1;k<accounts.get(i).size();k++){
                        if(hashSet.contains(accounts.get(i).get(k))){
                            if(parent[i] == -1)
                                parent[i] = j;
                            else {
                                merge(parent,i,j);
                            }
                        }
                    }
                     
                }

            }
        }
        for(int i=0;i<n;i++)
            findParent(parent,i);

        List<List<String>> ans  = new ArrayList<>();
        for(int i=0;i<n;i++){
            
            if(parent[i] == -1){
                HashSet<String> hash = new HashSet<>(accounts.get(i));
                for(int j = 0;j<n;j++){
                    if(parent[j] == i){
                        hash.addAll(accounts.get(j));
                    }
                }
                hash.remove(accounts.get(i).get(0));
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                List<String> temp2 = new ArrayList<>(hash);
                Collections.sort(temp2);
                temp.addAll(temp2);
                ans.add(temp);
            }
        }
        return ans;
    }
}