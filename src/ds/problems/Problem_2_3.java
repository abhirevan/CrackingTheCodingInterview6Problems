package ds.problems;

import ds.utils.SingleLinkedList;

public class Problem_2_3 {
	
	public static void deleteNodeHeadVoid(SingleLinkedList head)
	{
		
		if(head == null || head.next==null)
		{
			System.err.println("Failure");
			return;
		}
		
		head.data = head.next.data;
		head.next = head.next.next;
		
		
	}
	
	

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(2);
		list.appendToTail(1);
		list.printList();
		
		//System.out.println("K=2-> "+findKNode(list,4));
		//findKNodeRecursive(list,4);
		deleteNodeHeadVoid(list.next.next.next);
		list.printList();
		

	}

}
