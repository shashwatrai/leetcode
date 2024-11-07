class Solution {

    public int findParent(int a, int []parent){
        if( a == parent[a])
            return a;
        return parent[a] = findParent(parent[a],parent);
    }

    public void merge(int a,int b,int []parent){
        a = findParent(a,parent);
        b = findParent(b,parent);

        if(a != b){
            parent[b] = a;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        List<Set<String>> processing = new ArrayList<>();
        for(int i=0;i<n;i++){
            HashSet<String> set = new HashSet<>();
            for(int j=1;j<accounts.get(i).size();j++)
                set.add(accounts.get(i).get(j));
            processing.add(set);
        }
        // System.out.println(processing);
        int []parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                boolean flag = false; 
                for(String s: processing.get(i)){
                    if(processing.get(j).contains(s)){
                        flag = true;
                        break;
                    }
                }
                if(flag ){
                    merge(i,j,parent);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            findParent(i,parent);
            set.add(parent[i]);
        }
        List<List<String>> res= new ArrayList<>();
        // System.out.println(Arrays.toString(parent)+" "+set);
        for(int i:set){
            TreeSet<String> x = new TreeSet<>();
            for(int j=0;j<n;j++){
                if(parent[j] == i){
                    for(int l = 1;l<accounts.get(j).size();l++){
                        // System.out.println(j+" "+accounts.get(j));
                        x.add(accounts.get(j).get(l));
                    }
                }
            }
            List<String> arr = new ArrayList<>();
            arr.add(accounts.get(i).get(0));
            arr.addAll(x);
            res.add(arr);
        }
        return res;


    }
}