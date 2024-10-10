class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        if(n == 1) {
            if(hasApple.get(0)) {
                return 0;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(map, visited, 0, hasApple);
    }

    public int dfs(Map<Integer, List<Integer>> map, 
    Set<Integer> visited, int node, List<Boolean> hasApple) {
        visited.add(node);
        int totalTime = 0;

            for(int neighbor : map.get(node)) {
                if(!visited.contains(neighbor)) {
                    int time = dfs(map, visited, neighbor, hasApple);

                    if (time > 0 || hasApple.get(neighbor)) {
                        totalTime += time + 2; 
                    }
                }
            }

        return totalTime;
    }
}
