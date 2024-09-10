class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;

        ListNode dummy = new ListNode(-1);
        dummy.next = temp;

        while(temp != null && temp.next != null) {
            ListNode nxt = temp.next;
            temp.next = new ListNode(commonDivisor(temp.val, temp.next.val));
            temp.next.next = nxt;
            temp = nxt;
        }

        return dummy.next;
    }

    public int commonDivisor(int a, int b) {
        if(a == 0) {
            return b;
        }

        return commonDivisor(b%a, a);
    }
}
