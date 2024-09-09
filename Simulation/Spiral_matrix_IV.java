class Solution {
    public int[][] spiralMatrix(int row, int col, ListNode head) {
        int[][] ans = new int[row][col];

        for(int i[] : ans) {
            Arrays.fill(i, -1);
        }

        int topBoundary = 0, 
        rightBoundary = col-1, 
        bottomBoundary = row-1, 
        leftBoundary = 0;

        while(head != null) {
                for(int i=leftBoundary; i<=rightBoundary && head != null; i++) {
                    ans[topBoundary][i] = head.val;
                    head = head.next;
                }
                topBoundary++;

                for(int i=topBoundary; i<=bottomBoundary && head != null; i++) {
                    ans[i][rightBoundary] = head.val;
                    head = head.next;
                }
                rightBoundary--;

                for(int i=rightBoundary; i>=leftBoundary && head != null; i--) {
                    ans[bottomBoundary][i] = head.val;
                    head = head.next;
                }
                bottomBoundary--;

                for(int i=bottomBoundary; i>=topBoundary && head != null; i--) {
                    ans[i][leftBoundary] = head.val;
                    head = head.next;
                }
                leftBoundary++;
        }

        return ans;
    }
}
