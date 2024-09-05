class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, TreeSet<Integer>> xMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yMap = new HashMap<>();

        for(int i[]:obstacles){
          if(!xMap.containsKey(i[0])){
            xMap.put(i[0],new TreeSet<>());
          }
          xMap.get(i[0]).add(i[1]);

          if(!yMap.containsKey(i[1])){
            yMap.put(i[1],new TreeSet<>());
          }
          yMap.get(i[1]).add(i[0]);
        }

        int maxAns = Integer.MIN_VALUE;
        int []directions = {1,2,3,4};

        int posX = 0,posY =  0, d = 0;

        for(int i:commands){
          if(i >0 ){

            switch(directions[d]){
              case 1: 
                if(xMap.containsKey(posX)){
                  Integer test = xMap.get(posX).higher(posY);
                  if(test != null ){
                    posY = Math.min(posY+i,test -1);
                  }else{
                    posY+=i;
                  }
                }else 
                  posY+=i;
                break;
              case 2:
                if(yMap.containsKey(posY)){
                  Integer test = yMap.get(posY).higher(posX);
                  if(test != null ){
                    posX =  Math.min(posX+i,test -1);
                  }else{
                    posX+=i;
                  }
                }else 
                  posX+=i;
                break;

              case 3:
                if(xMap.containsKey(posX)){
                  Integer test = xMap.get(posX).lower(posY);
                  if(test != null ){
                    posY = Math.max(posY-i,test +1);
                  }else{
                    posY-=i;
                  }
                }else 
                  posY-=i;
                break;

            case 4:
              if(yMap.containsKey(posY)){
                Integer test = yMap.get(posY).lower(posX);
                if(test != null ){
                  posX =  Math.max(posX-i,test+1);
                }else{
                  posX-=i;
                }
              }else 
                posX-=i;
              break;

            }

          }else{
            if(i == -1){
              d = (d+1)%4;
            }else{
              d = (d+3)%4;
            }
          }
        //   System.out.println(posX+" " + posY+" "+d);
          maxAns = Math.max(maxAns,posX*posX + posY*posY);
        }
        return maxAns;
    }
}