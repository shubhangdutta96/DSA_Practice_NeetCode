class Solution {
    Map<Integer, List<Integer>> map;
    int size;

    public int[] findSubtreeSizes(int[] parent, String s) {
        map = new HashMap<>();

        // Build the tree representation
        for(int i=1; i<parent.length; i++) {
            map.putIfAbsent(parent[i], new ArrayList<>());
            map.get(parent[i]).add(i);
        }

        for(int i=1; i<parent.length; i++) {
            int ancestor = dfs(i, parent, s, i);

            if(ancestor != -1 && map.containsKey(ancestor) && 
            !map.get(ancestor).contains(i)) {
                // add new edge
                map.get(ancestor).add(i);

                // remove previous edge
                map.get(parent[i]).remove(Integer.valueOf(i)); 
            }
        }

        // answer calculation
        int ans[] = new int[parent.length];
        ans[0] = parent.length;
        for(int i=1; i<parent.length; i++) {
            size = 0;
            traversal(i);
            ans[i] = size;
        }

        return ans;
    }

    public int dfs(int i, int[] parent, String s, int j) {
        int ans = -1;

        if(parent[i] == -1) {
            return -1;
        }

        // check for ancestor's alphabet
        if(s.charAt(parent[i]) == s.charAt(j)) {
            return ans = parent[i];
        }

        return dfs(parent[i], parent, s, j);
    }

    public void traversal(int node) {
        size++;
        
        if(!map.containsKey(node)) {
            return;
        }

        for(int i : map.get(node)) {
            traversal(i);
        }

        return;
    }
}
