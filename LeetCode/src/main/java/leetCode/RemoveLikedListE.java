package leetCode;
/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */

public class RemoveLikedListE {
	public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next=head;
        ListNode curr = head;
        ListNode prev = root;
        while(curr!=null){
            if(curr.val==val) prev.next=curr.next;
            else prev=curr;    
            curr=curr.next;
        }
        return root.next;
    }
	
	

	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(6);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(4);
		ListNode n6=new ListNode(5);
		ListNode n7=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		ListNode.printNodes(n1);
		
		RemoveLikedListE re = new RemoveLikedListE();
		int val=6;
		ListNode head = n1;
		ListNode res = re.removeElements(head, val);
		ListNode.printNodes(res);
	}

}

//class ListNode{
//	int val;
//	ListNode next;
//	
//	ListNode(int x){
//		val=x;
//	}
//	
//	public static void printNodes(ListNode n){
//		while (n!=null){
//			System.out.print(n.val+"->");
//			n=n.next;
//		}
//		System.out.println();
//	}
//}
