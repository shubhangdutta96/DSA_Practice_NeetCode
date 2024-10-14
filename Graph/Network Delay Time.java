// Classic DIJKSTRA'S ALGORITHM problem
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int time[] : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(new int[] {v, w});
        }

        int ans = 0;
        int delay[] = new int[n+1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[] {k, 0});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int u = curr[0];
            int cost = curr[1];

            if(cost > delay[u]) {
                continue;
            }

            if(map.containsKey(u)) {
                for(int i[] : map.get(u)) {
                    int v = i[0];
                    int newCost = cost + i[1];

                    if(newCost < delay[v]) { // RELAXATION STEP
                        delay[v] = newCost;
                        pq.offer(new int[] {v, newCost});
                    }
                }
            }

        }
        
        for(int i=1; i<delay.length; i++) {
            if(delay[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, delay[i]);
        }

        return ans;
    }
}
