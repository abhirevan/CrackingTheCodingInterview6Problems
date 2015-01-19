package ds.utils;



public class SingleLinkedList {
	public SingleLinkedList next = null;
	public int data;
	
	public SingleLinkedList(int d)
	{
		this.data = d;
	}
	
	public void appendToTail(int d)
	{
		SingleLinkedList end = new SingleLinkedList(d);
		SingleLinkedList n = this;
		
		while(n.next !=null) //traverses to the end of the linkedlist
		{
			n=n.next;
		}
		n.next = end;
	}
	
	public static SingleLinkedList deleteNode(SingleLinkedList head,int d)
	{
		if(head.data == d) // The node to be deleted is the head
		{
			return head.next; //ret the next node
		}
		else
		{
			SingleLinkedList n = head;
			while(n.next!=null)
			{
				if(n.next.data == d)//node found to be deleted
				{
					n.next = n.next.next;
					//n.next.next=null;
					return head;
				}
				
				n=n.next;
			}
			return head;
			
		}
	}
	
	public int length ()
	{
		SingleLinkedList n = this;
		int length =1;
		while(n.next!=null)
		{
			length++;
			n=n.next;
		}
		return length;
	}
	
	public void printList()
	{
		SingleLinkedList n = this;
		System.out.println("");
		System.out.print(n.data);
		while(n.next!=null)
		{
			n=n.next;
			System.out.print("->"+n.data);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		
		SingleLinkedList list = new SingleLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		//list.printList();
		
		list = deleteNode(list,3);
		list.printList();
		
		

	}

}
