package Weekly_Homework;

public class E160_IntersectionOf2LinkedList {
	public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    	}
    }
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lA = 0;
        int lB = 0;
        
        while (pointerA != null) {
            pointerA = pointerA.next;
            lA++;
        }
        while (pointerB != null) {
            pointerB = pointerB.next;
            lB++;
        }
        
        pointerA = headA;
        pointerB = headB;
        if (lA > lB) {
            for (int i = 0; i < lA - lB; i++) {
                pointerA = pointerA.next;
            }
        }
        else {
            for (int i = 0; i < lB - lA; i++) {
                pointerB = pointerB.next;
            }
        }
        
        for (int i = 0; i < Math.min(lA, lB); i++) {
            if (pointerA == pointerB) {
                return pointerA;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        
        return null;
    }
}
