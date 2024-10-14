class Pair{
    int val;
    int group;
    Pair(int v,int g){
        this.val = v;
        this.group = g;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                pq.add(new Pair(nums.get(i).get(j),i));
            }
        }
        Pair []arr = new Pair[pq.size()];

        for(int i=0;i<arr.length;i++){
            arr[i] = pq.poll();
        }
        Map<Integer,Integer> map = new HashMap<>();
        int start, end;
        int aS , eS;
        aS = eS = -1;
        end =start=0;
        while(end < arr.length){
            map.put(arr[end].group,map.getOrDefault(arr[end].group,0)+1);

            // System.out.println(map +" "+(map.size() == nums.size()));
            while(map.size() == nums.size()){
                if(aS == -1 || (eS-aS) > (arr[end].val - arr[start].val)){
                    aS = arr[start].val;
                    eS = arr[end].val;
                }
                map.put(arr[start].group,map.get(arr[start].group)-1);
                if(map.get(arr[start].group) == 0)
                    map.remove(arr[start].group);
                start++;

            }
            end++;
        }
        return new int[]{aS,eS};
    }
}