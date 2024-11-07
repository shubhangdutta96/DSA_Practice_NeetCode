class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(0) == '1' || s.charAt(n-1) == '1') {
            return false;
        }

        int farthest = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(farthest);
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int curr = q.poll();
                if(curr == n-1) {
                    return true;
                }

                for(int k=Math.max(curr + minJump, farthest + 1);
                k<=Math.min(curr+maxJump, n-1); k++) {
                    // check for redundant index using farthest
                    if(k > farthest && s.charAt(k) == '0') {
                        q.offer(k);
                    }
                }

                farthest = Math.max(farthest, curr+maxJump);
            }
        }

        return false;
    }
}
