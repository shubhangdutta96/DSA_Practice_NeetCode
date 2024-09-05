// The problem uses a greedy approach to merge triplets. Here's the concise logic:

// You have multiple triplets, and you want to merge them to match the target triplet.
// 1. You initialize three values x, y, and z to track progress toward the target values u, v, and w.

// 2. For each triplet:
   // a. If all elements in the triplet can contribute towards the target values (i.e., they do not exceed the target values), update x, y, and z by taking the maximum of the current values and the triplet elements.
// 3.  If at any point x, y, and z match u, v, and w, return true.
// 4. If after processing all triplets, the values still match the target, return true; otherwise, return false.

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int u = target[0];
        int v = target[1];
        int w = target[2];

        int x = 0;
        int y = 0;
        int z = 0;

        for(int triplet[] : triplets) {
            int a = triplet[0];
            int b = triplet[1];
            int c = triplet[2];

            if(triplets.length == 1) {
                if(a == u && b == v && c == w){
                    return true;
                }
                else {
                    return false;
                }
            }

            if(Math.max(x, a) <= u && Math.max(y, b) <= v && Math.max(z, 
            c) <= w) {
                x = Math.max(x, a);

                y = Math.max(y, b);

                z = Math.max(z, c);
            }

            
            
            if(x == u && y == v && z == w){
                return true;
            }
        }

        return x==u && y==v && z==w;
    }
}
