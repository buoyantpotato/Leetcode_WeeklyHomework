package Weekly_Homework;

public class M328_OddEvenLinkedList {
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    	}
    }
    
	public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        int n = 2;
        
        while (even != null && even.next != null) {
            n++;
            if (n % 2 == 0) {
                even = even.next;
            }
            else {
                ListNode temp = even.next;
                even.next = even.next.next;
                temp.next = odd.next;
                odd.next = temp;
                odd = temp;
            }
        }
        
        return head;
    }
}
