// Direction Handling:
// The robot can move in four directions ({{0, 1}, {1, 0}, {0,-1}, {-1, 0}}) N E S W, represented by a clockwise directions array.
// Based on the command -1 (turn right) or -2 (turn left), the robot's direction is updated using modulo arithmetic to cycle between the four directions.

// Movement Execution:
// For each positive command (move steps forward), the robot moves step by step in the current direction.
// If an obstacle is encountered (stored in a Set for quick lookup), the robot stops before the obstacle.

// Max Distance Calculation:
// After each move, the robot's Euclidean distance from the origin is calculated using (𝑥2 + 𝑦2), and the maximum distance is updated.
  
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int directions[][] = {{0, 1}, {1, 0}, {0,-1}, {-1, 0}}; 
        // clockwise directions - N E S W 
        int d = 0;  // 'd' is the pointer to move the robot in all four directions
        int x = 0;  // current location of the robot in x-axis
        int y = 0;  // current location of the robot in y-axis

        Set<String> set = new HashSet<>();  // for checking quickly 
        for(int i[] : obstacles){
            set.add(i[0] + "," + i[1]);
        }

        for(int i=0; i<commands.length; i++){
            if(commands[i] == -1) { // clockwise
                d = (d + 1 + 4) % 4;  // %4: to prevent it from out of bounf excep.
            }

            else if(commands[i] == -2) { // anti-clockwise
                d = (d - 1 + 4) % 4;
            }

            else {
                int k[] = directions[d];

                for(int j=0; j<commands[i]; j++) {
                    x += k[0];
                    y += k[1];

                    if(set.contains(x + "," + y)) {
                        x -= k[0];
                        y -= k[1];
                        break;
                    }

                    
                    max = Math.max(max, (int) Math.pow(x, 2) + (int) Math.pow(y, 2));
                }
            }
        }

        return max;
    }
}
