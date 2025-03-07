class Solution {
    public int[] closestPrimes(int left, int right) {

            boolean arr[] = new boolean [1000001];
            arr[0]=arr[1] = true;
            HashSet<Integer> set1 = new HashSet<>();
            for(int i=2;i<arr.length;i++){
                if(!arr[i]){
                    set1.add(i);
                    for(int j=i+i ;j<arr.length;j+=i){
                        arr[j] = true;
                    }
                }
            }
            TreeSet<Integer> set = new TreeSet<>(set1);
            Integer l = set.ceiling(left);
            Integer r = set.floor(right);
            if(l == null || r == null )
                return new int[]{-1,-1};
            int min = Integer.MAX_VALUE,a =-1,b=-1;
            while(l <= r){
                Integer next = set.ceiling(l+1);
                if(next == null || next > r){
                    break;
                }
                if(min > next- l){
                    min = next - l;
                    a = l;
                    b = next;
                }
                l = next;
            } 
            return new int[]{a,b};
    }
}