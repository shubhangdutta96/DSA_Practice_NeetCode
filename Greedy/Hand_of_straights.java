// Greedy Approach Hints:

// Sort the Cards:
// Start by sorting the array of card values. Sorting helps you easily identify consecutive sequences since consecutive numbers will be adjacent in a sorted array.

// Use a Min-Heap (Priority Queue):
// A min-heap (or just a sorted list with a pointer) can be helpful to track the smallest card available to start a new group.
// For each card in the sorted list, try to start a new group or continue an existing one.

// Track Frequency:
// Use a frequency map (or HashMap) to keep track of how many times each card value appears.
// As you form groups, decrement the count of each card used. If you can't use a card to complete a group, then it's impossible to rearrange the cards as required.

// Form Groups from the Smallest Card:
// Always try to form a group starting with the smallest card that is still available. This is where the greedy nature comes in—you always make the locally optimal choice by starting with the smallest available card.

// Check Group Validity:
// For each card used to start a group, ensure that the next W-1 consecutive cards exist and are available. If at any point, you can't complete a group, then the answer is "No" (return false).


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
