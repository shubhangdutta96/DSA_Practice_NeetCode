// * Each node has at most one parent (no child should appear in both       leftChild and rightChild of different nodes).
// * There is exactly one root node (a node that has no parent).
// * The tree is fully connected (all nodes are reachable from the root without cycles).

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild,
    int[] rightChild) {
        int par[] = new int[n];
        Arrays.fill(par, -1);
        int rank[] = new int[n];
        Arrays.fill(rank, 0);

        for(int i=0; i<n; i++) {
            if(leftChild[i] != -1) {
                if(par[leftChild[i]] != -1) {
                    return false;
                }
                par[leftChild[i]] = i;
            }
            if(rightChild[i] != -1) {
                if(par[rightChild[i]] != -1) {
                    return false;
                }
                par[rightChild[i]] = i;
            }
        }

        int rootCount = 0;
        int root = -1;
        for(int i=0; i<n; i++) {
            if(par[i] == -1) {
                root = i;
                rootCount++;
            }
        }

        // Condition 1. : A node with no parent(root node of the tree)
        if(rootCount != 1) {
            return false;
        }

        // Conditions 2. : There is no cycle 
        boolean visited[] = new boolean[n];
        if(!dfs(root, leftChild, rightChild, visited)) {
            return false;
        }

        // Condition 3. : All node are connected(ie. all node are reachable)
        for(boolean nodeVisited : visited) {
            if(!nodeVisited) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int[] leftChild, int[] rightChild, boolean 
    visited[]) {
        if(node == -1) {
            return true;
        }
        if(visited[node]) {
            return false;
        }

        visited[node] = true;

        return dfs(leftChild[node], leftChild, rightChild, visited) && 
        dfs(rightChild[node], leftChild, rightChild, visited);
    }
}
