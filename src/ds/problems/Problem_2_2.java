package ds.problems;
import ds.utils.SingleLinkedList;

/**
 * 
 * @author ISILDUR
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 */

public class Problem_2_2 {
	
	public static int findKNode(SingleLinkedList head,  int k)
	{
		//Find length first and then find k-n node
		int length = head.length();
		int count=1;
		SingleLinkedList ptr = head;
		
		if(k>=length)
		{
			System.err.println("Error!");
			return -1;
		}
		
		while(count<(length-k+1))
		{
			ptr=ptr.next;
			count++;
		}
		return ptr.data;
	}
	
	public static int findKNodeRecursive(SingleLinkedList head, int k){
		
		if(head==null)
		{
			return 0;
		}
		
		int indexFromLast = findKNodeRecursive(head.next,k) + 1;
		if(indexFromLast == k)
		{
			System.out.println("The element is: "+head.data);
		}
		return indexFromLast;
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(2);
		list.appendToTail(1);
		list.printList();
		
		System.out.println("K=2-> "+findKNode(list,4));
		findKNodeRecursive(list,4);
		

	}

}
