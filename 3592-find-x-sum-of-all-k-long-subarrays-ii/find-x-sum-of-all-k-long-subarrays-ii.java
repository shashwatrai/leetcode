class Pair {
    int val;
    int freq;

    Pair(int v, int f) {
        this.val = v;
        this.freq = f;
    }
}

class Solution {
    public int minHeapify(List<Pair> arr, int indx, Map<Integer, Integer> map) {

        Pair target = arr.get(indx);
        while (indx < arr.size()) {
            int left = 2 * indx + 1;
            int right = 2 * indx + 2;
            int minIndx = indx;
            if (left < arr.size() && arr.get(minIndx).freq > arr.get(left).freq) {
                minIndx = left;
            }
            
            if (right < arr.size() && arr.get(minIndx).freq > arr.get(right).freq) {
                minIndx = right;
            }

            
                if(left < arr.size() && (arr.get(minIndx).freq == arr.get(left).freq && arr.get(minIndx).val > arr.get(left).val)){
                    minIndx = left;
                }

                if(right < arr.size() && (arr.get(minIndx).freq == arr.get(right).freq && arr.get(minIndx).val > arr.get(right).val)){
                    minIndx = right;
                }
            
            // System.out.println(minIndx);
            if (minIndx != indx) {
                arr.set(indx, arr.get(minIndx));
                map.put(arr.get(indx).val, indx);
                arr.set(minIndx, target);
                indx = minIndx;
            } else {
                return indx;
            }
        }
        return indx;
    }

    public int minHeapAdd(List<Pair> arr, int indx, Map<Integer, Integer> map) {

        while (indx > 0) {
            int parent = (indx - 1) / 2;
            if (arr.get(parent).freq > arr.get(indx).freq
                    || (arr.get(parent).freq == arr.get(indx).freq && arr.get(parent).val > arr.get(indx).val)) {

                Pair temp = arr.get(parent);
                arr.set(parent, arr.get(indx));
                arr.set(indx, temp);
                map.put(temp.val, indx);
                indx = parent;
            } else {
                return indx;
            }
        }
        return indx;
    }

    public int maxHeapAdd(List<Pair> arr, int indx, Map<Integer, Integer> map) {
        
        boolean flag = arr.get(indx).val == 901299264; 

        while (indx > 0) {
            int parent = (indx - 1) / 2;
            // if(flag){
            //     System.out.println(arr.get(parent).val+" "+arr.get(parent).freq);
            // }
            if (arr.get(parent).freq < arr.get(indx).freq
                    || (arr.get(parent).freq == arr.get(indx).freq && arr.get(parent).val < arr.get(indx).val)) {

                Pair temp = arr.get(parent);
                arr.set(parent, arr.get(indx));
                arr.set(indx, temp);
                map.put(temp.val, indx);
                indx = parent;
            } else {
                return indx;
            }
        }
        return indx;
    }

    public int maxHeapify(List<Pair> arr, int indx, Map<Integer, Integer> map) {

        Pair target = arr.get(indx);
        while (indx < arr.size()) {
            int left = 2 * indx + 1;
            int right = 2 * indx + 2;
            int minIndx = indx;
            if (left < arr.size() && arr.get(minIndx).freq < arr.get(left).freq) {
                minIndx = left;
            }

            if (right < arr.size() && arr.get(minIndx).freq < arr.get(right).freq) {
                minIndx = right;
            }

            
                if(left < arr.size() && (arr.get(minIndx).freq == arr.get(left).freq && arr.get(minIndx).val < arr.get(left).val))
                    minIndx = left;
                if(right < arr.size() && (arr.get(minIndx).freq == arr.get(right).freq && arr.get(minIndx).val < arr.get(right).val))
                    minIndx = right;
            

            if (minIndx != indx) {
                arr.set(indx, arr.get(minIndx));
                map.put(arr.get(indx).val, indx);
                arr.set(minIndx, target);
                indx = minIndx;
            } else {
                return indx;
            }
        }
        return indx;
    }

    public Pair removeTopFromMinHeap(List<Pair> arr, Map<Integer, Integer> minMap) {
        Pair p = arr.get(0);

        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            int key = arr.get(0).val;
            minMap.put(key, minHeapify(arr, 0, minMap));
        }
        return p;
    }

    public Pair removeTopFromMaxHeap(List<Pair> arr, Map<Integer, Integer> maxMap) {
        Pair p = arr.get(0);

        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            int key = arr.get(0).val;
            maxMap.put(key, maxHeapify(arr, 0, maxMap));
        }
        return p;
    }

    public long[] findXSum(int[] nums, int k, int x) {

        List<Pair> min = new ArrayList<>();
        List<Pair> max = new ArrayList<>();

        Map<Integer, Integer> maxMap = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();

        long ans[] = new long[nums.length - k + 1];
        long temp = 0L;
        int start = 0;
        // System.out.println(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // if(nums[i] == 901299264)
            //     System.out.println("apperance "+i+" "+(minMap.containsKey(nums[i]) || min.size() < x));
            if (minMap.containsKey(nums[i]) || min.size() < x) {
                temp = (long) (temp + (long) nums[i]);
                if (minMap.containsKey(nums[i])) {
                    int indx = minMap.get(nums[i]);
                    min.get(indx).freq++;
                    // if(nums[i] == 901299264)
                    //     System.out.println("came "+min.get(indx).freq);
                    minMap.put(nums[i], minHeapify(min, indx, minMap));
                } else {
                    min.add(new Pair(nums[i], 1));
                    minMap.put(nums[i], minHeapAdd(min, min.size() - 1, minMap));
                }
            } else {
                if (maxMap.containsKey(nums[i])) {
                    int indx = maxMap.get(nums[i]);
                    max.get(indx).freq++;
                    maxMap.put(nums[i], maxHeapAdd(max, indx, maxMap));
                } else {
                    max.add(new Pair(nums[i], 1));
                    maxMap.put(nums[i], maxHeapAdd(max, max.size() - 1, maxMap));
                }
                if (max.get(0).freq > min.get(0).freq ||
                        (max.get(0).freq == min.get(0).freq && max.get(0).val > min.get(0).val)) {
                    Pair p = removeTopFromMinHeap(min, minMap);
                    // if(nums[i] == 901299264)
                    //     System.out.println("came "+p.val);
                    minMap.remove(p.val);
                    temp = (long) (temp - (long) ((long) p.freq * (long) p.val));
                    max.add(p);
                    maxMap.put(p.val, maxHeapAdd(max, max.size() - 1, maxMap));
                    p = removeTopFromMaxHeap(max, maxMap);
                    // if(nums[i] == 901299264)
                    //     System.out.println("came "+p.val+" "+i) ;
                    maxMap.remove(p.val);
                    temp = (long) (temp + (long) ((long) p.freq * (long) p.val));
                    min.add(p);
                    minMap.put(p.val, minHeapAdd(min, min.size() - 1, minMap));
                }
            }
            // if(i-k+1 ==156 ){
            //     for(int y:minMap.keySet()){
            //         System.out.print("{"+y+":"+min.get(minMap.get(y)).freq+" "+minMap.get(y)+"},");
            //     }
            //     System.out.println();
            //     for(int y:maxMap.keySet()){
            //         System.out.print("{"+y+":"+max.get(maxMap.get(y)).freq+" "+maxMap.get(y)+"},");
            //     }
            //     // System.out.println();
            // }
            if (start + k - 1 == i) {
                ans[i - k + 1] = temp;
                if (minMap.containsKey(nums[start])) {
                    int indx = minMap.get(nums[start]);
                    min.get(indx).freq--;

                    temp = (long) (temp - (long) nums[start]);
                    minMap.put(nums[start], minHeapAdd(min, indx, minMap));
                    // System.out.println("["+min.get(0).val+" "+min.get(0).freq+"]");
                    if (max.isEmpty() || ((max.get(0).freq > min.get(0).freq ||
                            (max.get(0).freq == min.get(0).freq && max.get(0).val > min.get(0).val)))) {
                        Pair p = removeTopFromMinHeap(min, minMap);
                        minMap.remove(p.val);
                        temp = (long) (temp - (long) ((long) p.freq * (long) p.val));
                        if (p.freq != 0) {
                            max.add(p);
                            maxMap.put(p.val, maxHeapAdd(max, max.size() - 1, maxMap));
                        }
                        if (!max.isEmpty()) {
                            p = removeTopFromMaxHeap(max, maxMap);
                            maxMap.remove(p.val);
                            temp = (long) (temp + (long) ((long) p.freq * (long) p.val));
                            min.add(p);
                            minMap.put(p.val, minHeapAdd(min, min.size() - 1, minMap));
                        }
                    }
                } else {
                    int indx = maxMap.get(nums[start]);
                    max.get(indx).freq--;
                    
                    int key = max.get(indx).val;
                    maxMap.put(key, maxHeapify(max, indx, maxMap));
                    indx = maxMap.get(key);
                    if(max.get(indx).freq == 0){
                        max.set(indx,max.get(max.size()-1));
                        max.remove(max.size()-1);
                        maxMap.remove(key);
                        if(max.size() != indx){
                            key = max.get(indx).val;
                            maxMap.put(key,maxHeapAdd(max,indx,maxMap));
                        }
                    }
                }
                start++;
            }
            // if (temp < 0L)
            //     System.out.println(temp);
            //  System.out.println(" | "+minMap+" "+maxMap);
        }
        // for (long i : ans) {
        //     if (i < 0L)
        //         System.out.println(i);
        // }
        return ans;
    }
}