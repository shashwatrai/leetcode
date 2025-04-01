class Solution {
    public long power(long a, long b){
        long res=1L;
        long R = (long)1e9+7;
        while(b > 0L){
            if((b%2L) == 1){
                res = ((res%R)*(a%R))%R;
            }
            a = (a*a)%R;
            b/=2L;
        }
        return res;
    }
    public int maximumScore(List<Integer> nums, int k) {
        int []arr = new int[100001];
        arr[1]=0;
        for(int i =2;i<arr.length;i++){
            if(arr[i]==0){
                for(int j=i;j<arr.length;j+=i){
    arr[j]++;

                }
            }
        }

        int n = nums.size();
        int []next = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(n);
        for(int i=n-1;i>=0;i--){
            while(st.peek() != n && arr[nums.get(st.peek())] <= arr[nums.get(i)]){
                st.pop();
            }

            next[i]=st.peek();
            st.push(i);
        }
        st.clear();
        int []prev = new int[n];
        st.push(-1);
        for(int i =0;i<n;i++){
            while(st.peek() != -1 && arr[nums.get(st.peek())] < arr[nums.get(i)]){
               st.pop(); 
            }
            //System.out.println(arr[nums.get(i)]+" "+st);
            prev[i] = st.peek();
            st.push(i);
        }
        
        //System.out.println(Arrays.toString(prev));
         long score=1L;
         long R = (long)1e9 + 7L;
         PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> a!=b ?nums.get(b)-nums.get(a): a-b);
        for(int i=0;i<n;i++)
            pq.add(i);
         while(!pq.isEmpty()){
            int curr= pq.poll();
            long len = Math.min((long)k,(long)(next[curr]-curr)*(long)(curr-prev[curr]));
           //System.out.println(arr[nums.get(curr)]+" "+curr+" "+len+" "+nums.get(curr));
            //for(int j=0;j<Math.min(len,k);j++){
            System.out.println(power((long)nums.get(curr),len));
            score = ((score%R)* power((long)nums.get(curr),len)%R)%R;
                //System.out.println(score);
         //  } //score = ((score % R) * ((long)nums.get(curr)* (long)Math.min(len,k))%R)%R;
            k -= (int)len;

            if(k == 0)
                break;
         }
        return (int)score;

    }
}