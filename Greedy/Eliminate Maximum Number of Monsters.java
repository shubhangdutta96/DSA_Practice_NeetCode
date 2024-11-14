class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int kill = 1;
        int time[] = new int[n];
        for(int i=0; i<n; i++) {
            time[i] = (dist[i] + speed[i]-1) / speed[i];
        }
        Arrays.sort(time);

       
        for(int i=1; i<n; i++) {
            if(i >= time[i]) {
                return kill;
            }

            kill++;
        }

        return kill;
    }
}
