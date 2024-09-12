class MKAverage {

    TreeMap<Integer,Integer> left,middle,right;
    Queue<Integer> queue;
    int m,k;
    int leftCount,rightCount,middleCount,sum;
    public MKAverage(int m, int k) {
        left = new TreeMap<>();
        right = new TreeMap<>();
        middle = new TreeMap<>();
        queue  = new LinkedList<>();
        this.m = m;
        this.k = k;

        leftCount= rightCount = middleCount = sum = 0;
    }
    
    public void removeElement(){
        if(leftCount + rightCount + middleCount == m){
            int num = queue.poll();
            if(left.containsKey(num) ){
                if(left.get(num) == 1){
                    left.remove(num);
                }else{
                    left.merge(num,-1,Integer::sum);
                }
                leftCount--;
            }else if(right.containsKey(num)){
                if(right.get(num) == 1){
                    right.remove(num);
                }else{
                    right.merge(num,-1,Integer::sum);
                }
                rightCount--;
            }else{
                if(middle.get(num) == 1){
                    middle.remove(num);
                }else{
                    middle.merge(num,-1,Integer::sum);
                }
                middleCount--;
                sum-=num;
            }
        }
    }
    public void balance(){
        
        if(leftCount > k){
            int num  = left.lastKey();
            if(left.get(num) == 1){
                left.remove(num);
            }else{
                left.merge(num,-1,Integer::sum);
            }
            leftCount--;
            middle.merge(num,1,Integer::sum);
            middleCount++;
            sum+=num;
        }
        if(rightCount > k){
            int num  = right.firstKey();
            if(right.get(num) == 1){
                right.remove(num);
            }else{
                right.merge(num,-1,Integer::sum);
            }
            rightCount--;
            middle.merge(num,1,Integer::sum);
            middleCount++;
            sum+=num;
        } 
        if(middleCount > m-2*k){
            System.out.println((m-2*k));
            if(leftCount < k){
                int num  = middle.firstKey();
                if(middle.get(num) == 1){
                    middle.remove(num);
                }else{
                    middle.merge(num,-1,Integer::sum);
                }
                middleCount--;
                sum-=num;
                left.merge(num,1,Integer::sum);
                leftCount++; 
            }else{
                int num  = middle.lastKey();
                if(middle.get(num) == 1){
                    middle.remove(num);
                }else{
                    middle.merge(num,-1,Integer::sum);
                }
                middleCount--;
                sum-=num;
                right.merge(num,1,Integer::sum);
                rightCount++; 
            }
        }
        
    }
    public void addElement(int num) {
        removeElement();

        if(!left.isEmpty() && left.lastKey() >=  num){
            left.merge(num,1,Integer::sum);
            leftCount++;
        }else if(!right.isEmpty() && right.firstKey() <= num){
            right.merge(num,1,Integer::sum);
            rightCount++;
        }else {
            middle.merge(num,1,Integer::sum);
            middleCount++;
            sum+=num;
        }
        queue.add(num);
        balance();
        System.out.println(num +" "+left+"|"+leftCount+ " "+ middle +"|"+middleCount+" "+ right+"|"+rightCount);
    }
    
    public int calculateMKAverage() {
        
        if(leftCount + middleCount + rightCount == m){
            return sum/(m-2*k);
        }
        return -1;
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */