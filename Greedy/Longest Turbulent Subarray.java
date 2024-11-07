class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int i = 0;
        int j = 1;
        int n = arr.length;
        boolean j_1Flag = false;
        boolean jFlag = false;
        int maxLen = 1;

        while(j < n) {
            if(j == i+1) {
                if(arr[i] > arr[j]) {
                    j_1Flag = true;
                }
                else if(arr[i] < arr[j]) {
                    jFlag = true;
                }
                else {
                    i = j;
                    j++;
                    continue;
                }
            } else {
                if(j_1Flag && arr[j] > arr[j-1]) {
                    jFlag = true;
                    j_1Flag = false;
                } else if(jFlag && arr[j-1] > arr[j]) {
                    j_1Flag = true;
                    jFlag = false;
                } else {
                    maxLen = Math.max(maxLen, j-i);
                    i = j-1;
                    j_1Flag = false;
                    jFlag = false;
                    continue;
                }
            }
            
            // maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }
}
