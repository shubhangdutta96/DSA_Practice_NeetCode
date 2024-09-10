//  MULTI-SOURCE BFS
// Why Multi-Source BFS is Effective:
// It efficiently calculates the minimum distance from any land cell to the nearest water cell in a single pass.
// The BFS propagates distance values outward from all land cells at the same time, ensuring that the shortest path to each water cell is found without redundant calculations.

// for Example: 
1 0 0
0 0 0
0 0 1

// n the initial step, BFS starts from both (0, 0) and (2, 2) since they are land cells.
// In the first BFS layer, the cells adjacent to (0, 0) and (2, 2) are updated with a distance of 1.
// The BFS continues to spread out from these updated cells, updating further distances.

class Solution {
    public int maxDistance(int[][] grid) {
        int maxDistance = -1;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        if(q.isEmpty() || q.size() == n*n){
            return -1;
        }

        int directions[][] = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int current[] = q.poll();
            int i = current[0];
            int j = current[1];

            for(int dir[] : directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = grid[i][j] + 1;

                    q.offer(new int[] {x, y});
                    maxDistance = Math.max(maxDistance, grid[x][y] - 1);
                }
            }      
        }


        
        return maxDistance;
    }
}
