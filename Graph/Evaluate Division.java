class Solution {

    class Node {
        String key;
        double val;
        Node(String k, double v) {
            key = k;
            val = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double
    [] values, List<List<String>> queries) {
        Map<String, List<Node>> adj = new HashMap<>();

        for(int i=0; i<equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);

            if(!adj.containsKey(x)) {
                adj.put(x, new ArrayList<>());
            }
            adj.get(x).add(new Node(y, values[i]));

            if(!adj.containsKey(y)) {
                adj.put(y, new ArrayList<>());
            }
            adj.get(y).add(new Node(x, 1/values[i]));
        }

        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            ans[i] = dfs(x, y, adj, visited);
        }

        return ans;
    }

    public double dfs(String src, String dst, Map<String, List<Node>> 
    adj, Set<String> visited) {
        if(!adj.containsKey(src) && !adj.containsKey(dst)) {
            return -1.0;
        }
        if(src.equals(dst)) {
            return 1.0;
        }

        visited.add(src);

        if(adj.get(src) != null) {
            for(Node n : adj.get(src)) {
                String s = n.key;
                double val = n.val;

                if(!visited.contains(s)) {
                    double ans = dfs(s, dst, adj, visited);
                    if(ans != -1.0) {
                        return ans * val;
                    }
                }
            }
        }

        return -1.0;
    }
}
