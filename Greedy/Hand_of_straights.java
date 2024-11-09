class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }

        boolean ans = true;
        for(int i=0; i<n; i++) {
            if(map.get(hand[i]) > 0) {
                int next = hand[i]+1;
                boolean flag = true;
                for(int j=0; j<groupSize-1; j++) {
                    if(map.containsKey(next) && map.get(next) > 0) {
                        map.put(next, map.get(next)-1);
                        next += 1;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    map.put(hand[i], map.get(hand[i])-1);
                }
            }
        }

        for(int val : map.values()) {
            if(val != 0) {
                return false;
            }
        }
        return true;
    }
}
