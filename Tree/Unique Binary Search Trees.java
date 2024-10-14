class Solution {
    public int numTrees(int n) {
        int t[] = new int[n+1];
        Arrays.fill(t, -1);
        
        return solve(n, t);
    }

    public int solve(int n, int[] t) {
        int tree = 0;

        if(n == 0 || n == 1) {
            return 1;
        }

        if(t[n] != -1) {
            return t[n];
        }

        for(int i=1; i<=n; i++) {
            tree += solve(i-1, t) * solve(n-i, t);
        }

        t[n] = tree;
        return tree;
    }
}
