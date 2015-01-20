package ds.problems;

import ds.utils.SingleLinkedList;

public class Problem_2_3 {
	
	

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
		

	}

}
