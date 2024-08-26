// Intuition:

// Safe Node Definition: A node is safe if every path starting from it leads to a terminal node or another safe node.
// Reverse Graph Advantage: By reversing the graph, you can trace backward from terminal nodes to determine which nodes eventually lead to these terminal nodes.

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer> > adj = new HashMap<>();
        int n = graph.length;
        int inDegree[] = new int[n];  
        
        // Graph Representation(reverse graph)
        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            inDegree[i] = graph[i].length;
            for(int v : graph[i]){
                adj.get(v).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();
            list.add(current);
            for(int i : adj.get(current)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    q.offer(i);
                }
            }
        }


        Collections.sort(list);
        
        return list;
    }
}
