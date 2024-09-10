class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int arr1[] = new int[edges.length];
        int arr2[] = new int[edges.length];
        int ans = -1;

        for(int i=0; i<arr1.length; i++) {
            arr1[i] = -1;
            arr2[i] = -1;
        }

        dfs(edges, node1, arr1, 0);
        dfs(edges, node2, arr2, 0);


        int currMin = Integer.MAX_VALUE;
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] == -1 || arr2[i] == -1) {
                continue;
            }

            int min = Math.max(arr1[i], arr2[i]);
            if(min < currMin) {
                currMin = min;
                ans = i;
            }
        }    

        return ans;    
    }

    public void dfs(int[] edges, int node, int arr[], int x) {
        if(node == -1 || arr[node] != -1) {
            return;
        }
        arr[node] = x;
        dfs(edges, edges[node], arr, x+1);
    }
}
