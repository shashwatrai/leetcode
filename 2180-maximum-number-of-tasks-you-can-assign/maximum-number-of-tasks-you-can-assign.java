class Solution {
    public boolean isValid(int [] workers,int []tasks,int k,int pills,int strength){
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i:workers){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count=0;
        System.out.println(k);
        for(int i=k;i>=0;i--){
            Integer target = map.ceilingKey(tasks[i]);
            if(target != null){
                map.put(target,map.get(target)-1);
                if(map.get(target) == 0)
                    map.remove(target);
            }else{
                if(pills > 0){
                    target = map.ceilingKey(tasks[i]-strength); 
                    if(target != null){
                            pills--;
                            map.put(target,map.get(target)-1);
                            if(map.get(target) == 0)
                                map.remove(target);
                    }else
                        return false;
                }else
                    return false;
            }
        }
        return true;
    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
       
        int n = tasks.length;
        Arrays.sort(tasks);
        int l = 0,r= n-1;

        while(l<=r){
            int m = (l+r)/2;

            if(isValid(workers,tasks,m,pills,strength)){
                l= m+1;
            }else
                r= m-1;
        }

        return l;
    }
}