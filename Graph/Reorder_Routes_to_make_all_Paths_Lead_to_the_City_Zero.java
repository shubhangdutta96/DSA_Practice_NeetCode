class Solution {
    public int minReorder(int n, int[][] connections) {
        // Graph representation using an adjacency list.
        // Each node is associated with a list of its neighbors.
        // Positive neighbors represent roads in the original direction.
        // Negative neighbors represent roads that can be reversed.
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Build the graph with both directions for each road.
        for (int[] connection : connections) {
            int u = connection[0]; // starting city
            int v = connection[1]; // destination city

            // Add the road in its original direction (u -> v)
            adj.get(u).add(v);

            // Add the reverse direction as a negative value (v -> -u)
            // This helps identify roads that could be reversed.
            adj.get(v).add(-u);
        }

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0); 
        int count = 0;

        // BFS 
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                int absRoad = Math.abs(neighbor); // Get the absolute value of the neighbor (ignore direction for now)
                if (!visited.contains(absRoad)) {
                    visited.add(absRoad); 
                    q.offer(absRoad); 

// If the neighbor is positive, it means the road is in its original direction and needs to be reversed for making the graph reachable from city 0.
                    if (neighbor > 0) {
                        count += 1; 
                    }
                }
            }
        }

        return count;
    }
}
