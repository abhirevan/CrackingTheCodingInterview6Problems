package ds.problems;
import java.util.Hashtable;

import ds.utils.SingleLinkedList;

/**
 * 
 * @author ISILDUR
 * Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
pg
 *
 */
public class Problem_2_1 {
	public static SingleLinkedList remDuplicatesLL(SingleLinkedList head)
	{
		SingleLinkedList ptr1,ptr2;
		ptr1  = head;
		
		while(ptr1.next!=null)
		{
			ptr2=ptr1;
			while(ptr2.next!=null){
				if(ptr1.data==ptr2.next.data)//Means duplicate found
				{
					ptr2.next=ptr2.next.next;
					continue;
				}
				else
				{
					ptr2=ptr2.next;
				}
				
			}
			ptr1=ptr1.next;

		}
		return head;
	}
	
	public static SingleLinkedList remDuplicatesWBufferLL(SingleLinkedList head)
	{
		Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
		SingleLinkedList n = head;
		table.put(n.data,true);
		while(n.next!=null)
		{
			if(table.containsKey(n.next.data)) // Means n.next is duplicate
			{
				n.next = n.next.next;
				continue;
			}
			else{
				table.put(n.next.data,true);
			}
			
			n = n.next;
		}

		return head;
	}
	
	public static void main(String[] args){
		SingleLinkedList list = new SingleLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(2);
		list.appendToTail(1);
		list.printList();
		remDuplicatesWBufferLL(list).printList();
		remDuplicatesLL(list).printList();
		
	}

}
