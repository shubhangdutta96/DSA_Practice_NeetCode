class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int color[] = new int[n];
        for(int i=0; i<n; i++) {
            color[i] = -1;
        }

        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;

                while(!q.isEmpty()) {
                    int curr = q.poll();
                    int newColor = 1 - color[curr];

                    if(graph[i].length != 0) {
                        for(int k : graph[curr]){
                            if(color[k] == -1){
                                q.offer(k);
                                color[k] = newColor;
                            }
                            else if(color[k] == color[curr]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
