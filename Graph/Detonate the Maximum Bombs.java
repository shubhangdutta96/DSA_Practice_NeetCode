class Solution {
    public int maximumDetonation(int[][] bombs) {
        int m = bombs.length;
        int ans = 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Graphical representation
        for(int i=0; i<m; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];
            for(int j=i+1; j<m; j++) {
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                int r2 = bombs[j][2];

                long dist = (long)Math.pow((x1-x2), 2) + (long)Math.pow((y1-y2), 2);
                long r3 = (long)Math.pow(r1, 2);
                long r4 = (long) Math.pow(r2, 2);

                if(dist <= r3) {
                    adj.get(i).add(j);
                }
                if(dist <= r4) {
                    adj.get(j).add(i);
                }
            }
        }

        //DFS
        for(int i=0; i<m; i++) {
            int count = dfs(i, new HashSet<>(), adj);

            // Updating 'ans'
            if(count > ans) {
                ans = count;
            }
        }

        return ans;
    }

    public int dfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> adj) {
        if(visited.contains(i)) {
            return 0;
        }
        visited.add(i);

        if(adj.get(i) != null) {
            for(int k : adj.get(i)) {
                dfs(k, visited, adj);
            }
        }

        return visited.size();
    }
}
