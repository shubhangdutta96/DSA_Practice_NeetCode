class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans = Integer.MAX_VALUE;
        // Graph Representation
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int flight[] : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new int[] {v, cost});
        }   

        Queue<int[]> q = new LinkedList<>();
        int costToV[] = new int[n];
        Arrays.fill(costToV, Integer.MAX_VALUE);

        q.offer(new int[] {src, 0, 0});
        costToV[src] = 0;

        while(!q.isEmpty()) {
            int current[] = q.poll();
            int u = current[0];
            int cost = current[1];
            int stops = current[2];

            if(u == dst) {
                ans = Math.min(ans, cost);
                continue;
            }

            if(adj.get(u) != null && stops <= k) {
                for(int i[] : adj.get(u)) {
                    int v = i[0];
                    int newCost = i[1] + cost;

                    // Relaxation step (Dijkstra's Algorithm)
                    if(newCost < costToV[v]) {  
                        costToV[v] = newCost;
                        q.offer(new int[] {v, newCost, stops+1});
                    }
                }
            }
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
