class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[]
    [] blueEdges) {
        int ans[] = new int[n];
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int redEdge[] : redEdges) {
            int u = redEdge[0];
            int v = redEdge[1];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new int[] {v, 0});
        }
        for(int blueEdge[] : blueEdges) {
            int u = blueEdge[0];
            int v = blueEdge[1];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new int[] {v, 1});
        }

        // Shortest Path - Dijkstra's Algo.
        for(int i=0; i<n; i++) {
            ans[i] = solve(adj, 0, i);
        }

        return ans;
    }

    public int solve(Map<Integer, List<int[]>> adj, int src, int dst) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int ans = Integer.MAX_VALUE;

        q.offer(new int[] {src, 0, -1});

        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int u = curr[0];
            int cost = curr[1];
            int color = curr[2];

            if(u == dst) {
                ans = Math.min(ans, cost);
                continue;
            }

            if(adj.get(u) != null) {
                for(int i[] : adj.get(u)) {
                    int v = i[0];
                    int nextColor = i[1];
                    String key = v + "," + nextColor;
                    if(nextColor != color && !visited.contains(key)) {
                        visited.add(key);
                        q.offer(new int[] {v, cost+1, nextColor});
                    }
                }
            }
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
