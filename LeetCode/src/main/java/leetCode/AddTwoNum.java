/*
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

package leetCode;

public class AddTwoNum {
	public ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode head = new ListNode(0);
		ListNode curr = head;
		int carry = 0;
		while(l1!=null || l2 !=null || carry !=0){
			int val=carry;
			carry=0;
			if (l1!=null){
				val += l1.val;
				l1 = l1.next;
			}
			if (l2 !=null){
				val += l2.val;
				l2 = l2.next;
			}
			if (val >=10){
				val = val -10;
				carry=1;
			}
			curr.next=new ListNode(val);
			curr = curr.next;
		}
		return head.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		AddTwoNum ts=new AddTwoNum();
		ListNode l3=ts.addTwoNumbers(l1, l2);
		ListNode.printNodes(l3);
	}
}
