// Track Last Occurrences:
// First, traverse the string to record the last index where each character appears.

// Two-Pointer Partitioning:
// Use two pointers, start and end, to define the current partition.
// As you iterate through the string, update end to the maximum last occurrence of any character encountered so far.
// When the current index i matches end, you have found the end of a partition. Record its length (end - start + 1) and move start to the next position.

class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastOccurence[] = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(int k=0; k<s.length(); k++) {
            lastOccurence[s.charAt(k) - 'a'] = k;
        }

        int start = 0, end = 0;;
        for(int i=0; i<s.length(); i++) {
            end = Math.max(end, lastOccurence[s.charAt(i)-'a']);

            if(i == end) {
                ans.add(end-start+1);
                start = i+1;
            }
        }

        return ans;
    }
}
