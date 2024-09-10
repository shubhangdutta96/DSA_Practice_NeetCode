class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null) {

            if(!set.contains(curr.val)) {
                dummy.next = curr;
                dummy = dummy.next;
            }

            curr = curr.next;
        }

        dummy.next = null;
        return prev.next;
    }
}
