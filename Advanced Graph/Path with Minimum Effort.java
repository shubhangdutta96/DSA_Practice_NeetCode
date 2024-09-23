// DIIJKSTRA'S ALGORITHM

class Solution {
    int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        boolean visited[][] = new boolean[heights.length][heights[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.offer(new int[] {0, 0, 0});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int cost = curr[2];

            if(i == heights.length-1 && j == heights[0].length-1){
                return cost;
            }

            if(visited[i][j]) {
                continue;
            }
            visited[i][j] = true;

            for(int dir[] : directions) {
                int x = i+dir[0];
                int y = j+dir[1];

                if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && 
                !visited[x][y]) {
                    pq.offer(new int[] {x, y, 
                    Math.max(cost, Math.abs(heights[i][j] - heights[x][y]))});
                }
            }
        }

        return 0;
    }
}
