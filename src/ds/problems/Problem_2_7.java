package ds.problems;
import java.util.Stack;

import ds.utils.SingleLinkedList;


public class Problem_2_7 {
	
	public static boolean checkPalindrome(SingleLinkedList head)
	{
		SingleLinkedList ptr1 = head,ptr2 = head;
		Stack<SingleLinkedList> s = new Stack<SingleLinkedList>();
		s.add(head);
		
		while(ptr2.next!=null)
		{
			if(ptr2.next.next==null)
				break;
			ptr1 = ptr1.next;
			s.add(ptr1);
			ptr2=ptr2.next.next;
		}
		if(ptr2.next==null)//means even number of elements- topmost element not to be used for comparison
			s.pop();
			while(ptr1.next!=null)
			{
				SingleLinkedList n = s.pop();
				ptr1 =ptr1.next;
				if(n.data !=ptr1.data)
				{
					return false;
				}
				
			}
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList list = new SingleLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(1);
		list.appendToTail(0);
		list.printList();
		System.out.println("Palindrome check: "+checkPalindrome(list));
		

	}

}
