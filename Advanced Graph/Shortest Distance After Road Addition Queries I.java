class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n-1; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(i+1);
        }

        int ans[] = new int[queries.length];
        int m = queries.length;
        for(int i=0; i<m; i++) {
            int query[] = queries[i];
            int u = query[0];
            int v = query[1];
            map.get(u).add(v);
            ans[i] = shortestDist(map, 0, n-1, n);
        }

        return ans;
    }

    public int shortestDist(Map<Integer, List<Integer>> map, int src, 
    int dst, int n) {
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dis[src] = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int u = q.poll();
                if(u == dst) {
                    return dis[u];
                }
                if(map.get(u) != null) {
                    for(int v : map.get(u)) {
                        // relaxation step
                        if(dis[v] > dis[u]+1) {
                            dis[v] = dis[u]+1;
                            q.offer(v);
                        }
                        
                    }
                }
            }
        }

        return dis[dst];
    }
}
