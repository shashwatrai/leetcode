class Solution {
    public void buildSegment(int [][]arr, char s[], int start, int end,int curr){
        if(start > end)
            return;
        if(start == end){
            arr[curr] = new int[]{1,1,1};
            return;
        }

        int middle = (start + end) /2;

        buildSegment(arr, s, start,  middle, 2*curr + 1);
        buildSegment(arr, s, middle + 1, end, 2*curr + 2);
        process(arr, s, curr, start, middle, end);

    }

    public void process(int arr[][],char []s, int curr,int start, int middle, int end){
        arr[curr][0] = Math.max(arr[2*curr+1][0],arr[2*curr+2][0]);
        if(s[middle] == s[middle+1]){
            arr[curr][0] = Math.max(arr[curr][0], arr[2*curr+1][2] + arr[2*curr +2][1] );
        }

        arr[curr][1] = arr[2*curr+1][1];
        if(middle - start + 1 == arr[2*curr+1][1] && s[start] == s[middle+1]){
            arr[curr][1] = arr[2*curr+1][1] + arr[2*curr+2][1];
        }

        arr[curr][2] = arr[2*curr+2][2];
        if(end - middle == arr[2*curr+2][2] && s[end] == s[middle]){
            arr[curr][2] = arr[2*curr+1][2] + arr[2*curr+2][2];
        }
    }

    public void update(int [][]arr,char []sArr,int start,int end,int curr,char c,int x){
        if(start == end){
            sArr[x] = c;
            return;
        }

        int middle  = (start + end)/2;

        if(middle  < x){
            update(arr, sArr, middle + 1, end, 2 * curr + 2, c, x);
        }else
            update(arr, sArr, start, middle, 2*curr+1, c, x);
        process(arr, sArr, curr, start, middle , end);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int arr[][] = new int[4*n][3];

        buildSegment(arr, s.toCharArray(), 0,n-1,0);

        int k = queryIndices.length;
        int ans[] = new int[k];
        char []sArr = s.toCharArray();
        for(int i=0;i<k;i++){
            update(arr,sArr,0,n-1,0,queryCharacters.charAt(i),queryIndices[i]);
            ans[i] = arr[0][0];
        }
        return ans;
    }
}