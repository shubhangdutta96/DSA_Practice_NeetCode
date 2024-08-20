class Solution {
    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        return 1 + helper(n, 1, 1);
    }

    public int helper(int n, int count, int copy){
        if(count == n){
            return 0;
        }
        if(count > n){
            return 1000;
        }

        // paste
        int paste = 1 + helper(n, count+copy, copy);

        // copy + paste
        int copyAndPaste = 2 + helper(n, count+count, count); 

        return Math.min(paste, copyAndPaste);
    }

}
