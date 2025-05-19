class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        int xor = 0;
        for(int i=0;  i<arr.length;i++){
            xor ^= arr[i];
            right.put(xor,right.getOrDefault(xor,0)+1);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            Map<Integer,Integer> temp = new HashMap<>();
            temp.put(arr[i],1);
            for(int j:left.keySet()){
                temp.put(j^arr[i],temp.getOrDefault(j^arr[i],0)+left.get(j));
            }
            left =temp;
            temp = new HashMap<>();
            for(int j:right.keySet()){
                if(j == arr[i] && right.get(j) > 1)
                    temp.put(j^arr[i],temp.getOrDefault(j^arr[i],0)+right.get(j)-1);
                else if(j!=arr[i])
                    temp.put(j^arr[i],temp.getOrDefault(j^arr[i],0)+right.get(j));
            }
            right =temp;
            // System.out.println(left+"\t"+right);
            for(int j:left.keySet()){
                if(!right.containsKey(j))
                    continue;
                ans+= left.get(j)*right.get(j);
            }
        }
        return ans;
    }
}