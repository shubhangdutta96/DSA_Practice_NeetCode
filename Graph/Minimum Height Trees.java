class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int degree[] = new int[n];
        List<Integer> ans = new ArrayList<>();

        if(n == 1) {
            ans.add(0);
            return ans;
        }

        // Graph creation
        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(v);
            map.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }

        int remainingLeaves = n;
        while(remainingLeaves > 2) {
            int leavesCount = q.size();
            remainingLeaves -= leavesCount;

            for(int k=0; k<leavesCount; k++) {
                int leaf = q.poll();

                for(int i : map.get(leaf)) {
                    degree[i]--;
                    if(degree[i] == 1) {
                        q.offer(i);
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;



        // for(int i=0; i<n; i++) {
        //     Set<Integer> visited = new HashSet<>();
        //     int height = dfs(i, visited, map);

        //     if(height == max) {
        //         ans.add(i);
        //     }
        //     else if(height < max) {
        //         ans.clear();
        //         ans.add(i);
        //         max = height;
        //     }
        // }

    // public int dfs(int src, Set<Integer> visited, 
    // Map<Integer, List<Integer>> map) {
    //     int max = 0;
    //     visited.add(src);

    //     for(int i : map.get(src)) {
    //         if(!visited.contains(i)) {
    //             int curr = dfs(i, visited, map);
    //             max = Math.max(max, curr);
    //         }
    //     }
        
    //     return max+1;
    }
}
