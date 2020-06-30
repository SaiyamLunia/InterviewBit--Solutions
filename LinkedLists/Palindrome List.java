/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
*/


public class Solution {
    public int lPalin(ListNode A) {
        if(A == null || A.next == null)
            return 1;
        ListNode p1 = A, p2 = A;
		
		while (p2 != null && p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}

		p2 = p1;
        ListNode rev = reverse(p2); 
        p1 = A;
		p2 = rev;
		while (p1 != null) {
			if(p1.val != p2.val)
				return 0;
			p1 = p1.next;
			p2 = p2.next;
		}
        return 1;
    }
    
    public ListNode reverse(ListNode A) {
        ListNode rev = null, current = A, next = null;
        while(current != null) {
            next = current.next;
            current.next = rev;
            rev = current;
            current = next;
        }
        return rev;
    }
}
