class Solution {
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new int[] {v, cost});
            adj.get(v).add(new int[] {u, cost});
        }

        Set<Integer> visited = new HashSet<>();
        dfs(1, adj, visited);
        return ans;
    }

    public void dfs(int src, Map<Integer, ArrayList<int[]>> adj, Set<Integer> visited) {
        if(visited.contains(src)) {
            return;
        }
        visited.add(src);
        for(int[] i : adj.get(src)) {
            ans = Math.min(i[1], ans);
            dfs(i[0], adj, visited);
        }
    }
}
