class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<hand.length; i++){
            pq.offer(hand[i]);
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }

        while(!pq.isEmpty()){
            int frontier = pq.poll();
            int n = groupSize;
            if(map.get(frontier) == 0){
                continue;
            }

            while(n > 0){
                if(map.containsKey(frontier) && map.get(frontier) > 0) {
                    map.put(frontier, map.get(frontier)-1);
                    frontier++;
                }
                else if((map.containsKey(frontier) && map.get(frontier) == 0)
                || !map.containsKey(frontier)) {
                    return false;
                }
                
                n--;
            }
        }

        return true;
    }
}
