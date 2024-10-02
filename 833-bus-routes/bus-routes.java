class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;
        Map<Integer ,Set<Integer> > busMap = new HashMap<>();
        List<Integer> startBus = new ArrayList<>();
        for(int i=0;i<routes.length;i++){

            Set<Integer> set = new HashSet<>();
            for(int j=0;j<routes[i].length;j++){
                if(routes[i][j] == source)
                    startBus.add(i);
                set.add(routes[i][j]);
            }
            busMap.put(i,set);
        }

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int j=i+1;j<routes.length;j++){
                Set<Integer> test= new HashSet<>(busMap.get(i));
                test.retainAll(busMap.get(j));
                if(test.size() > 0){
                    if(!adj.containsKey(i)){
                        adj.put(i,new ArrayList<>());
                    }
                    if(!adj.containsKey(j)){
                        adj.put(j,new ArrayList<>());
                    }
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> buses = new HashSet<>();
        for(int i=0;i<startBus.size();i++){
            buses.add(startBus.get(i));
            queue.add(startBus.get(i));
        }

        System.out.println(adj);
        int busCount=1;
        while(!queue.isEmpty()){
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                int bus = queue.poll();
                
                if(busMap.get(bus).contains(target)){
                    return busCount;
                }
                if(!adj.containsKey(bus))
                    continue;
                for(int i:adj.get(bus)){
                    if(!buses.contains(i)){
                        temp.add(i);
                        buses.add(i);
                    }
                }
            }
            queue = temp;
            busCount++;
        }
       

        return -1;

    }
}