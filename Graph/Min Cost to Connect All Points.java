class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int pointConnected = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[] {0, 0});

        while(pointConnected < n) {
            int curr[] = pq.poll();
            int cost = curr[0];
            int idx = curr[1];
            int x = points[idx][0];
            int y = points[idx][1];

            if(visited[idx]) {
                continue;
            }
            visited[idx] = true;
            totalCost += cost;
            pointConnected++;

            for(int i=0; i<n; i++) {
                int point[] = points[i];
                int a = point[0];
                int b = point[1];

                if(!visited[i]) {
                    int dist = Math.abs(x-a) + Math.abs(y-b);
                    pq.offer(new int[] {dist, i});
                }
            }
        }

        return totalCost;
    }
}
