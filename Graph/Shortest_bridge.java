// Identify the First Island:

// Use Depth-First Search (DFS) to find and mark all cells of the first island as 2.
// While doing so, collect the cells into a queue.
// Breadth-First Search (BFS) to Find the Shortest Bridge:

// Perform BFS from the cells of the first island, expanding layer by layer.
// Track the number of expansion steps (or layers) until a cell from the second island (marked as 1) is reached.
// Result:

// The number of BFS steps taken to reach the second island represents the shortest bridge between the two islands.

class Solution {
    public int shortestBridge(int[][] grid) {
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length && !found; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, q, visited);
                    found = true;
                    break;
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

        // bfs
        while(!q.isEmpty()){
            int size = q.size();
    
            for(int k=0;k<size;k++){
                int current[] = q.poll();
                int i = current[0];
                int j = current[1];
                
                for(int dir[] : directions){
                    int x = i + dir[0];
                    int y = j + dir[1];

                    

                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length){
                        if(grid[x][y] == 1){
                            return step;
                        }
                        if(grid[x][y] == 0 && !visited.contains(x + "," + y)){
                            visited.add(x + "," + y);
                            q.offer(new int[] {x, y});
                        }
                        
                    }
                }
            }
            step++;
        }

        return step;
    }

    public void dfs(int[][] grid, int i, int j, Queue<int[]> q, Set<String> visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return;
        }

        grid[i][j] = 2;
        q.offer(new int[] {i, j});
        visited.add(i + "," + j);

        dfs(grid, i-1, j, q, visited);
        dfs(grid, i, j+1, q, visited);
        dfs(grid, i+1, j, q, visited);
        dfs(grid, i, j-1, q, visited);
    }
}
