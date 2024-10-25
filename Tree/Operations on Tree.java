class LockingTree {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int lock[];
    int parents[];

    public LockingTree(int[] parent) {
        parents = parent;
        lock = new int[parent.length];

        for(int i=0; i<parent.length; i++) {
            if(parent[i] != -1) {
                if(!map.containsKey(parent[i])){
                    map.put(parent[i], new ArrayList<>()); 
                }
                map.get(parent[i]).add(i);
            }
        }
        
    }
    
    public boolean lock(int num, int user) {
        if(lock[num] == 0) {
            lock[num] = user;
            return true;
        }

        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num] == user) {
            lock[num] = 0;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
            if(lock[num] != 0) {
                return false;
            }
            if(!hasLockedAncestor(num)) {
                return false;
            }
            if(!allAncestorsAreUnlocked(num)) {
                return false;
            }

        unlockDescendants(num);
        lock[num] = user;
        return true;
    }

    public boolean allAncestorsAreUnlocked(int node) {
        boolean ans = true;
        if(parents[node] != -1) {
            if(lock[parents[node]] != 0) {
                return false;
            }
            ans &= allAncestorsAreUnlocked(parents[node]);
        }

        return ans;
    }

    public boolean hasLockedAncestor(int node) {
        boolean ans = false;
        if(map.containsKey(node)) {
            for(int i : map.get(node)) {
                if(lock[i] != 0) {
                    ans = true;
                }
                ans |= hasLockedAncestor(i);
            }
        }

        return ans;
    }

    public void unlockDescendants(int node) {
        if(map.containsKey(node)) {
            for(int i : map.get(node)) {
                if(lock[i] != 0) {
                    lock[i] = 0;
                }
                unlockDescendants(i);
            }
        }
    }
}
