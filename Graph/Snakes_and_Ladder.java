class Solution {
    public int snakesAndLadders(int[][] board) {
        int ans = 0;
        int n = board.length;
        boolean visited[] = new boolean[n * n];
        visited[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 0});  // int[] = {cell_Value, moves}

        while(!q.isEmpty()){
            int current[] = q.poll();
            int value = current[0];
            int moves = current[1];

            for(int i=1;i<=6;i++){
                int nextValue = value  + i;
                int cords[] = getCoordinates(nextValue, board.length);
                int nextSquare = board[cords[0]][cords[1]];

                if(nextSquare > -1){
                    nextValue = nextSquare;
                }

                if(nextValue > n * n){
                    break;

                }
                if(nextValue == n * n){
                    return moves+1;

                }
                if(!visited[nextValue]){
                    visited[nextValue] = true;
                    q.offer(new int[] {nextValue, moves+1});
                }
            }
        }
        return -1;
    }

    public int[] getCoordinates(int square, int n) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;  // Reverse column order for odd rows
        }
        return new int[]{n - 1 - r, c};  // Convert to (row, col)
    }
}
