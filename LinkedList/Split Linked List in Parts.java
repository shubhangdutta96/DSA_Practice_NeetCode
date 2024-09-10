class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        int quotient = len / k;
        int remainder = len % k;
        int tempArr[] = new int[k];
        for(int i=0; i<k; i++) {
            tempArr[i] = quotient;
        }

        int i = 0;
        while(remainder > 0) {
            tempArr[i]++;
            remainder--;
            i++;
        }

        ListNode ans[] = new ListNode[k];
        temp = head;
        for(int j=0; j<k; j++){
            ListNode start = new ListNode(-1);
            start.next = temp;
            ListNode st = start.next;
            int partition = tempArr[j];

            if(partition == 0) {
                ans[j] = null;
                continue;
            }
            
            int tempLen = 1;

            while(tempLen != partition) {
                tempLen++;
                temp = temp.next;
            }

            ListNode end = temp.next;
            temp.next = null; 
            ans[j] = st;
            temp = end;
        }

        return ans;
    }
}
