class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();

        // direct prerequisites
        boolean preReq[][] = new boolean[numCourses][numCourses];
        for(int pre[] : prerequisites){
            preReq[pre[0]][pre[1]] = true;
        }

        // Floyd-Warshall Algorithm to find all pairs reachability.
        // If there is an indirect path from course i to course j through some
        // intermediate course k, then preReq[i][j] will also be true.

        // indirect prerequisites
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(preReq[i][k] && preReq[k][j]){
                        preReq[i][j] = true;
                    }
                }   
            }
        }

        for(int query[] : queries){
            int u = query[0];
            int v = query[1];

            ans.add(preReq[u][v]);
        }

        return ans;
    }
}
