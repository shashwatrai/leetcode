class Solution {
    public void findAns(int freq[],int cnt,int l,List<Integer>arr){
        if(cnt == 0){
            arr.add(l);
            return;
        }
        for(int i=1;i<freq.length;i++){
            if(freq[i] > 0){
                freq[i]--;
                cnt--;
                findAns(freq,cnt,l*10+i,arr);
                freq[i]++;
                cnt++;
            }
        }
    }
    public void generate(int a, List<Integer>arr ){
        int []freq = new int[8];
        int cnt=0;
        while(a > 0){
            freq[a%10]++;
            cnt++;
            a/=10;
        }
        findAns(freq,cnt,0,arr);
    }
    public void findSums(int s, boolean []vis, List<List<Integer>>sums,List<Integer>temp){
        if(s == 0){
            sums.add(new ArrayList<>(temp));
            return;
        }

        for(int i=1;i<vis.length;i++){
            if(!vis[i]){
                vis[i] = true;
                temp.add(i);
                findSums(s-i,vis,sums,temp);
                vis[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public int nextBeautifulNumber(int n) {
        String []arr = {"","1","22","333","4444","55555","666666","7777777"};

        List<Integer> num = new ArrayList<>();

        for(int i=1;i<arr.length;i++){
            num.add(Integer.parseInt(arr[i]));
            boolean vis[] = new boolean[i];
            List<List<Integer>> sums =new ArrayList<>();
            findSums(i,vis,sums,new ArrayList<>());
            // System.out.println(sums);
            for(List<Integer> t : sums){
                String temp = "";
                for(int j:t){
                    temp += arr[j];
                }
                num.add(Integer.parseInt(temp));
            }
        }
        List<Integer> permutations = new ArrayList<>();
        for(int i: num){
            generate(i,permutations);
        }
        Collections.sort(permutations);
        // System.out.println(num);
        for(int i:permutations){
            if(i > n){
                return i;
            }
        }
        return -1;
    }
}