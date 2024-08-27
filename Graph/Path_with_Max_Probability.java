class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();


        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(adj.get(u) == null){
                adj.put(u, new ArrayList<>());
            }
            if(adj.get(v) == null){
                adj.put(v, new ArrayList<>());
            }
            adj.get(u).add(new double[]{v, succProb[i]});
            adj.get(v).add(new double[]{u, succProb[i]});
        }

        double newCost = 0;
        double ans = 1;

        // bfs
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[1], a[1]) );

        pq.offer(new double[] {start, 1.0});
        while(!pq.isEmpty()){
            double current[] = pq.poll();
            double cost = current[1];
            int u = (int) current[0];

            if(u == end){
                return cost;
            }

            if(!visited.add(u)){
                continue;
            }
            visited.add(u);

            if(adj.get(u) != null){
                for(double i[] : adj.get(u)){
                    int v = (int) i[0];
                    if(!visited.contains(v)){
                        pq.offer(new double[] {v, cost*i[1]});
                    }
                }
            }
        }
        
        return newCost;
    }
}
