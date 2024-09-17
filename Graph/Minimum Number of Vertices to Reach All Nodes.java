// a very simple TOPLOLOGICAL SORT based problem

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int inDegree[] = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(List<Integer> edge : edges) {
            inDegree[edge.get(1)]++; 
        }

        for(int i=0; i<n; i++) {
            if(inDegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
