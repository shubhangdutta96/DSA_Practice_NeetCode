class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0){
            return n;
        }
        int count = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        // Graph Representation
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }

            if(!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }

            map.get(u).add(v);
            map.get(v).add(u);
        }

        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]){
                dfs(map, visited, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(Map<Integer, ArrayList<Integer>> map, boolean[] visited, int i){
        visited[i] = true;
        for(int j : map.get(i)){
            if(!visited[j]){
                dfs(map, visited, j);
            }
        }
    }
}
