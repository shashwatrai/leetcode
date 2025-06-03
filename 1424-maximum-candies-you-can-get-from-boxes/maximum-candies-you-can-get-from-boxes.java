class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        int foundBoxes[] = new int [n];
        int foundKeys[] = new int [n];
        for(int i=0;i<n;i++)
            if(status[i] == 1)
                foundKeys[i] = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean []vis = new boolean[n];

        for(int j:initialBoxes){
            if(status[j] == 1)
                foundKeys[j] = 1;
            foundBoxes[j] = 1;
            queue.add(j);
        }

        while(!queue.isEmpty()){
            // System.out.println(queue);
            int curr = queue.poll();

            for(int j: containedBoxes[curr]){
                foundBoxes[j] = 1;
                queue.add(j);
            }
            for(int j: keys[curr])
                if(j != curr)
                    foundKeys[j] = 1;
        }

        for(int j:initialBoxes){
            if(foundKeys[j] == 1 && foundKeys[j] == 1)
                queue.add(j);
        }
        int ans=0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans += candies[curr];
            candies[curr ] =0;

            for(int j:containedBoxes[curr]){
                if(foundKeys[j] == 1 && foundBoxes[j] == 1)
                    queue.add(j);
            }
        }
        return ans;
    }
}