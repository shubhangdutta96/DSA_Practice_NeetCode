class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, 
    int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<manager.length; i++) {
            if(manager[i] != -1) {
                map.putIfAbsent(manager[i], new ArrayList<>());
                map.get(manager[i]).add(i);
            }
        }
                
        return dfs(map, headID, informTime);
    }

    public int dfs(Map<Integer, List<Integer>> map, int i, int[] informTime) {
        int time = 0;
        if(map.get(i) != null) {
            for(int k : map.get(i)) {
                time = Math.max(time, dfs(map, k, informTime));
            }
        }
        
        return time+informTime[i];
    }
}
