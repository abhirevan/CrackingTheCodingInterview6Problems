/**
 * 2.4 Write code to partition a linked list around a value x, such that all nodes less than
x come before all nodes greater than or equal to x.
 */

package ds.problems;

import ds.utils.SingleLinkedList;

public class Problem_2_4 {
	
	public static SingleLinkedList partitionSingleLinkedList(SingleLinkedList head,int pivot)
	{
		//creating dummy nodes
		SingleLinkedList dummyLess = new SingleLinkedList(Integer.MIN_VALUE);
		SingleLinkedList ptrLess = dummyLess;
		SingleLinkedList dummyMore = new SingleLinkedList(Integer.MAX_VALUE);
		SingleLinkedList ptrMore = dummyMore;
		SingleLinkedList n = head;
		while(n!=null)
		{
			if(n.data < pivot)
			{
				ptrLess.next=n;
				ptrLess = ptrLess.next;
				n=n.next;
				ptrLess.next = null;

			}
			else{ //assuming data to be either < or > than pivot
				
				ptrMore.next=n;
				ptrMore = ptrMore.next;
				n=n.next;
				ptrMore.next = null;

			}
		}
		
		//Merge the data
		ptrLess.next=dummyMore.next;
		
		return dummyLess.next;
	}

	public static void main(String[] args) {
		SingleLinkedList list = null;
		list.appendToTail(9);
		list.appendToTail(5);
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(1);
		list.printList();
		
		SingleLinkedList sortedList = partitionSingleLinkedList(list,6);
		
		sortedList.printList();

	}

}
