// Tough Question

// Union-Find Initialization:

// Create a Union-Find data structure to manage merging of accounts.
// par array for tracking parent of each account.
// rank array for balancing the union operations.

// Mapping Emails to Accounts:
// Use a HashMap to map each email to its account index.
// For each account, union all its emails with the first email of that account.

// Union Operation:
// For each email in the account, union the current account with the account of the previously encountered email using Union-Find operations.

// Grouping Emails by Parent:
// After processing all accounts, group emails by their root account (parent).

// Sorting and Preparing Results:
// For each group of emails, sort the emails and prepend the account name to create the final result.

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Integer> map = new HashMap<>();
        int par[] = new int[accounts.size()];
        int rank[] = new int[accounts.size()];

        for(int i=0; i<par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        
        // 1. Populating Map
        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if(!map.containsKey(email)) {
                    map.put(email, i);
                }
                else {
                    union(par, rank, i, map.get(email));
                }
            }
        }

        // 2. Making connection
        List<String>[] list = new ArrayList[accounts.size()];
        for(int i=0; i<accounts.size(); i++){
            list[i] = new ArrayList<String>();
        }

        for(String email : map.keySet()) {
            int parent = find(par, map.get(email));
            list[parent].add(email);
        }

        // 3. Final result 
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) {
            if(list[i].isEmpty()) {
                continue;
            }

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            Collections.sort(list[i]);

            for(String email : list[i]){
                temp.add(email);
            }
            ans.add(temp);
        }

        return ans;
    }

    public int find(int[] par, int x) {
        if(x != par[x]) {
            par[x] = find(par, par[x]);
        }

        return par[x];
    }

    public void union(int par[], int rank[], int a, int b) {
        int x = find(par, a);
        int y = find(par, b);

        if(rank[x] > rank[y]) {
            par[y] = x;
        }
        else if(rank[x] < rank[y]) {
            par[x] = y;
        }
        else {
            par[y] = x;
            rank[x]++;
        }
    }
}
