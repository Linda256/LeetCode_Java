package leetCode;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 */

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode swapPairs(ListNode head) {

		/*
		 * while curr is not null
		 * if curr.next is not null
		 * 		swapNodes(curr,curr.next)
		 * 		curr=curr.next;
		 * else curr=curr.next;
		 */
		if (head.next==null) return head;
		ListNode newHead =new ListNode(0);
		newHead.next=swapNodes(head,head.next);
		ListNode curr=head;
		while (curr.next!=null&&curr.next.next!= null){
			ListNode temp=curr;
			curr=curr.next;
			ListNode next=curr.next;
			temp.next=swapNodes(curr,next);
		}
		return newHead.next;
	}

	public static ListNode swapNodes(ListNode l1,ListNode l2){
		ListNode temp=l2;
		l1.next=l2.next;
		temp.next=l1;
		return temp;
	}
	
//Method 1
	public  static ListNode reverseKGroup(ListNode head, int k) {

		int len=length(head);
		if (k>len || k==0) return head;
		ListNode newHead=new ListNode(0);
		newHead.next=reverseK(head,k);;

		System.out.println("length:" +len);
		while(len-k>=k){
			ListNode prev=head;
			head=head.next;
			ListNode tempHead=reverseK(head,k);
			prev.next=tempHead;
			len=len-k;
		}
		return newHead.next;
	}

//Method 2
	public  static ListNode reverseK(ListNode head, int k){
		//		find the k-1th Node(prev=k-1,curr=k,head2=curr.next)
		//		reverse the node from head to Kth Node (kth Node will be the first, and the head will the last node)
		//		link the head with k+1th  Node (head.next=(k+1)th Node;
		ListNode newHead=new ListNode(0);

		ListNode curr=head;
		ListNode tail=kthNode(head, k);
		ListNode head2=tail.next;
		newHead.next=tail;
		k=k-1;
		while(k>0){
			ListNode newTail=kthNode(head, k);
			tail.next=newTail;
			newTail.next=head;
			tail=newTail;
			k--;
		}
		head.next=head2;

		return newHead.next;
	}


	public static ListNode kthNode(ListNode head, int k){
		ListNode curr=head;
		for (int i=1;i<k;i++){
			curr=curr.next;
		}
		return curr;
	}
	
	public static int length(ListNode head){
		ListNode curr=head;
		int count=0;
		while (curr!=null){
			curr=curr.next;
			count++;
		}
		return count;
	}

	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part, 
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group: 
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed list 
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct part
			}
			head = curr;
		}
		return head;
	}
	public ListNode reverseKGroup3(ListNode head, int k) {
	    ListNode begin;
	    if (head==null || head.next ==null || k==1)
	    	return head;
	    ListNode dummyhead = new ListNode(-1);
	    dummyhead.next = head;
	    begin = dummyhead;
	    int i=0;
	    while (head != null){
	    	i++;
	    	if (i%k == 0){
	    		begin = reverse(begin, head.next);
	    		head = begin.next;
	    	} else {
	    		head = head.next;
	    	}
	    }
	    return dummyhead.next;
	    
	}
	
	public ListNode reverseKGroup4(ListNode head, int k) {
	    if (k < 2 || head == null) return head;
	    ListNode sentinel = new ListNode(0);
	    sentinel.next = head;
	    ListNode dummy = sentinel, tail = head, newHead;
	    while (true) {
	        int count = k - 1;
	        while (count > 0) {
	            if (tail.next != null) {
	                newHead = tail.next;
	                tail.next = newHead.next;
	                newHead.next = dummy.next;
	                dummy.next = newHead;
	                count--;
	            } else { 
	                /// list size is not multiple of k, a recursive call on the left-out nodes to undo the reverse
	                dummy.next = reverseKGroup(dummy.next, k - count);
	                return sentinel.next;
	            }
	        }
	        if (tail.next == null) return sentinel.next; /// list size is multiple of k, safely return
	        dummy = tail;
	        tail = tail.next;
	    }
	}

	public ListNode reverse(ListNode begin, ListNode end){
		ListNode curr = begin.next;
		ListNode next, first;
		ListNode prev = begin;
		first = curr;
		while (curr!=end){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}
	public ListNode swapPairsII(ListNode head) {
		if (head==null) return null;
		ListNode newHead=new ListNode(0);
		newHead.next=head;
		ListNode prev=newHead;
		ListNode curr=head;

		while (curr.next!=null){
			prev.next=curr.next;
			if (curr.next.next!=null) {
				curr.next=curr.next.next;
				prev.next.next=curr;
				prev=curr;
				curr=curr.next;
			}
			else {
				prev.next.next=curr;
				curr.next=null;
			}
		}
		return newHead.next;
	}



	public static void printNodes(ListNode n){
		while (n!=null){
			System.out.print(n.val+"->");
			n=n.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(4);
		l1.next=l2;
		ListNode l3=new ListNode(7);
		l2.next=l3;
		ListNode l4=new ListNode(8);
		l3.next=l4;
		ListNode l5=new ListNode(9);
		l4.next=l5;
		ListNode l6=new ListNode(0);
		l5.next=l6;
		l6.next=new ListNode(13);
		System.out.println("original ListNode");
		printNodes(l1);
		//		ListNode l8=null;
		//		ListNode n=l1.swapPairsII(l8);
		//ListNode n=swapNodes(l1,l2);
//		ListNode n=l1.swapPairsII(l1);
//		System.out.println("after swap");
//		printNodes(n);
		//			ListNode s=swapPairs(l1);
		////			System.out.println("n");
		////			SortedList.print(n);
		//
//		printNodes(l1);
		//
		//			printNodes(l2);
		//	
		//			printNodes(l2);
		//			printNodes(s);
//					ListNode r=reverseK(l1,3);
//					printNodes(r);
//					System.out.println(length(r));
//
//		ListNode l10=l1;
		ListNode g=l1.reverseKGroup2(l1,3);
		System.out.println("reserved Group2");
		printNodes(g);
//		
//		ListNode m=reverseKGroup(g,2);
//		System.out.println("reserved Group1");
//		printNodes(m);

	}
}	