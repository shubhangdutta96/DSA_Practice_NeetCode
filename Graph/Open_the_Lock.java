// BASIC DFS PROBLEM

class Solution {
    public int openLock(String[] deadend, String target) {
        int turns = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String start = "0000";
        Set<String> deadends = new HashSet<>();

        for(int i=0;i<deadend.length;i++){
            deadends.add(deadend[i]);
        }
        
        // BASE CASES
        if(deadends.contains(start)){
            return -1;
        }
        if(start.equals(target)){
            return 0;
        }

        q.offer(start);
        visited.add(start);

        // BFS.
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                String current = q.poll();

                for(int i=0;i<4;i++){
                    int num = Character.getNumericValue(current.charAt(i));

                    // now we have TWO choices at EACH position:
                    // 1. turn clockwise(+1)
                    // 2. turn anti-clockwise(-1)
                    
                    int clockWise = (num + 1 + 10) % 10;
                    int antiClockWise = (num - 1 + 10) % 10;
                    String newStr1 = current.substring(0, i) + clockWise + current.substring(i+1);
                    String newStr2 = current.substring(0, i) + antiClockWise + current.substring(i+1);

                    if(newStr1.equals(target) || newStr2.equals(target)){
                        return turns+1;
                    }

                    if(!deadends.contains(newStr1) && !visited.contains(newStr1)){
                        q.offer(newStr1);
                        visited.add(newStr1);
                        
                    }
                    if(!deadends.contains(newStr2) && !visited.contains(newStr2)){
                        q.offer(newStr2);
                        visited.add(newStr2);
                    }
                }
            }
            turns++;
        }

        return -1;
    }
}
