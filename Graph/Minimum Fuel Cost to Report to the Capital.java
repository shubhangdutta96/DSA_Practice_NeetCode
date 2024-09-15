// EXPLANATION
// roads = [[1, 0], [4, 0], [5, 0], [3, 1], [2, 3], [6, 4]];
// DFS and Fuel Calculation:
// Starting DFS from the capital node 0:
// DFS explores nodes 1, 4, and 5.

// At node 1:
// DFS goes to node 3.

// At node 3:
// DFS explores node 2.

// At node 2: No more unvisited nodes, so return 1 passenger.
// Fuel calculation: To bring 1 passenger from node 2 to node 3, since each vehicle can carry 2 passengers (seats = 2), it needs 1 trip.

// At node 3: After visiting node 2, return 2 passengers (node 3 + 1 from node 2).
// Fuel calculation: To bring 2 passengers from node 3 to node 1, it needs 1 trip.

// At node 1: After visiting node 3, return 3 passengers (node 1 + 2 from node 3).
// Fuel calculation: To bring 3 passengers from node 1 to node 0, it needs 2 trips.

// At node 4:
// DFS goes to node 6.
// At node 6: No more unvisited nodes, so return 1 passenger.
// Fuel calculation: To bring 1 passenger from node 6 to node 4, it needs 1 trip.
// At node 4: After visiting node 6, return 2 passengers (node 4 + 1 from node 6).
// Fuel calculation: To bring 2 passengers from node 4 to node 0, it needs 1 trip.

// At node 5:
// At node 5: No more unvisited nodes, so return 1 passenger.
// Fuel calculation: To bring 1 passenger from node 5 to node 0, it needs 1 trip.

// Total Fuel Calculation:
// Let's sum up the trips (fuel):
// From node 2 to node 3: 1 trip
// From node 3 to node 1: 1 trip
// From node 1 to node 0: 2 trips
// From node 6 to node 4: 1 trip
// From node 4 to node 0: 1 trip
// From node 5 to node 0: 1 trip

// Total trips (fuel) = 1 + 1 + 2 + 1 + 1 + 1 = 7


class Solution {
    long fuel = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = roads.length;
        

        // Graphical representation
        for(int road[] : roads) {
            int u = road[0];
            int v = road[1];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1, adj, seats);

        return fuel;
    }

    public int dfs(int node, int parent, Map<Integer, ArrayList<Integer>> adj, 
    int seats) {
        int passengers = 0;

        if(adj.get(node) != null) {
            for(int child : adj.get(node)) {
                if(child != parent) {
                    int p = dfs(child, node, adj, seats);
                    passengers += p;
                    fuel += (p + seats - 1) / seats;
                }
            }
        }

        return passengers+1;       
    }
}
