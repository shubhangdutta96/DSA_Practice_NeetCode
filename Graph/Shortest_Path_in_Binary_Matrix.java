// Use BFS Instead of Dijkstra’s Algorithm:
// Since the problem involves unweighted grid traversal, there's no need for the priority queue or Dijkstra's algorithm. A simple Breadth-First Search (BFS) is sufficient and more efficient.
// BFS will explore all nodes level by level, ensuring that the first time we reach the bottom-right corner, we’ve found the shortest path.
// 2. Use a boolean[][] Array for Visited Cells:
// Use a boolean[][] array. This will reduce both the time complexity and memory overhead associated with handling strings.

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        int directions[][] = {{-1, -1}, {-1, 0}, {-1, +1}, {0, +1}, {+1, +1}, {+1, 0}, 
        {+1, -1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[] {0, 0, 1});

        while(!q.isEmpty()){
            int size = q.size();

                int current[] = q.poll();
                int i = current[0];
                int j = current[1];
                int len = current[2];

                if(i == m-1 && j == n-1){
                    return len;
                }

                for(int dir[] : directions){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0 && 
                    !visited[x][y]) {
                        q.offer(new int[] {x, y, len+1});
                        visited[x][y] = true;
                    }
                }
        }

        return -1;
    }
}
