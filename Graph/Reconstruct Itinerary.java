class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();

        // grpahical representation
        for(int i=0; i<tickets.size(); i++) {
            List<String> ticket = tickets.get(i);

            String u = ticket.get(0);
            String v = ticket.get(1);

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);
        }
        for(String s : adj.keySet()) {
            Collections.sort(adj.get(s));
        }

        List<String> ans = new ArrayList<>();
        dfs("JFK", adj, ans, tickets.size());

        return ans;
    }

    public void dfs(String src, Map<String, List<String>> adj, 
    List<String> ans, int n) {
        List<String> dest = adj.get(src);

        while(dest != null && dest.size() > 0) {
            String dst = dest.remove(0);;
            dfs(dst, adj, ans, n);
        }

        ans.add(0, src);
    }
}
