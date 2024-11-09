class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int diff[] = new int[n];

        for(int i=0; i<n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        
        int req = 0;
        int tank = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            req += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0) {
                ans = i+1;
                tank = 0;
            }
        }

        return req >= 0 ? ans : -1;
    } 
}
