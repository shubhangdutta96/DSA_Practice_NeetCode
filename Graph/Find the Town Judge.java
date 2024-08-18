class Solution {
	public int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0){
            return n;
        }
		int inDegree[] = new int[n+1];
        int outDegree[] = new int[n+1];
		for(int i[] : trust) {
			inDegree[i[0]]++;
            outDegree[i[1]]++;
		}

		for(int i[] : trust) {
			int sum = 0;
			if(inDegree[i[1]] == 0 && outDegree[i[1]] == n-1) {
				return i[1];		
			}
		}
        return -1;
    }
}

