class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();

        char []arr = new char[n];
        int []time = new int[n];
        int t=0;
        Arrays.fill(arr,'.');
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(dominoes.charAt(i) == 'L' ){
                q.add(i);
                arr[i] = 'L';
                time[i] = t;
            }
            else if(dominoes.charAt(i) == 'R'){
                q.add(i);
                arr[i] = 'R';
                time[i] = t;
            }
        }
        while(!q.isEmpty()){
            int x = q.size();
            t++;
            while(x-- > 0){
                int curr= q.poll();
                if(arr[curr] == 'L' && curr -  1 >= 0 ){
                    if(arr[curr-1] == 'R' && time[curr-1] == t){
                        arr[curr-1] ='.';
                    }else if(arr[curr-1] == '.'){
                        q.add(curr-1);
                        arr[curr-1] = 'L';
                        time[curr-1]=t;
                    }
                }
                if(arr[curr] == 'R' && curr +  1 < n ){
                    if(arr[curr+1] == 'L' && time[curr+1] == t){
                        arr[curr+1] ='.';
                    }else if(arr[curr+1] == '.'){
                        q.add(curr+1);
                        arr[curr+1] = 'R';
                        time[curr+1]=t;
                    }
                }
            }
        }
        return new String(arr);
    }
}