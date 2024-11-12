class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();
        char ch[] = senate.toCharArray();
        int n = ch.length;

        for(int i=0; i<n; i++) {
            if(ch[i] == 'D') {
                dQ.offer(i);
            } else {
                rQ.offer(i);
            }
        }

        while(!dQ.isEmpty() && !rQ.isEmpty()) {
            int a = dQ.poll();
            int b = rQ.poll();

            if(a < b) {
                dQ.offer(a+n);
            } else {
                rQ.offer(b+n);
            }
        }

        return dQ.isEmpty() ? "Radiant" : "Dire";
    }
}
