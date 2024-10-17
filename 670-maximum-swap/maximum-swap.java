class Solution {
    public int maximumSwap(int num) {
        int []firstOcc = new int[10];
        int []lastOcc = new int[10];
        Integer indx[] = new Integer[10];
        for(int i=0;i<10;i++){
            indx[i] = i;
        }
        Arrays.fill(firstOcc,-1);
        Arrays.fill(lastOcc,-1);
        String numStr = Integer.valueOf(num).toString();
        for(int i=0;i<numStr.length();i++){
            if(firstOcc[numStr.charAt(i) - '0'] == -1){
                firstOcc[numStr.charAt(i) - '0'] = i;
            }

            lastOcc[numStr.charAt(i) - '0'] = i;
        }

        Arrays.sort(indx,(a,b) -> Integer.compare(firstOcc[a],firstOcc[b]));

        char src = '-',target='-';
        for(int i=0;i<10;i++){
            if(firstOcc[indx[i]] == -1)
                continue;
            for(int j = 9;j > indx[i] ;j--){
                if(lastOcc[j] > firstOcc[indx[i]]){
                    src  = (char)('0' + indx[i]);
                    target = (char)('0'+j);
                    break;
                }
            }
            if(src != '-')
                break;
        }
        // System.out.println(src+" "+target+" "+Arrays.toString(freq));
        // System.out.println(Arrays.toString(indx));
        if(src == '-')
            return num;
        int a = 0,b=0;
        char []arr = numStr.toCharArray();
        while(a<arr.length){
            if(arr[a] == src){
                for(b=a+1;b<arr.length;b++){
                    if(arr[b] == target){
                        arr[a] = target;
                        arr[b] = src;
                        break;
                    }
                    
                }
                a = b;
            }else{
                a++;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}