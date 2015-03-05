/**
 * You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the Ts digit is at the
head of the list. Write a function that adds the two numbers and returns the sum
as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
Output: 2 -> 1 -> 9.That is, 912.
FOLLOW UP -- VVImp
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
Output: 9 -> 1 -> 2.That is, 912.
 */

package ds.problems;


import ds.utils.SingleLinkedList;
import ds.model.*;



public class Problem_2_5 {
	
	public static SingleLinkedList addBackwards(SingleLinkedList num1,SingleLinkedList num2){
		SingleLinkedList n1 = num1;
		SingleLinkedList n2 = num2;
		SingleLinkedList retNode=null,n=null;//= new = null;
		int sum=0,carry=0;
		while(n1!=null || n2!=null || carry > 0){
			int a=0,b=0;
			if(n1!=null){
				a=n1.data; // check for a to be positive
				n1 =n1.next;
			}
			if(n2!=null){
				b=n2.data; // check for b to be positive
				n2=n2.next;
			}
			sum = a+b+carry;
			if(sum>9){
				carry = sum / 10;
				sum %=10;
			}
			else{
				carry =0;
			}
			SingleLinkedList temp = new SingleLinkedList(sum);
			if(retNode == null){
				retNode=temp;
				n=retNode;
			}else{
				n.next=temp;
				n=n.next;
			}
		}
		return retNode;
		
	}
	

	
	public static SingleLinkedList addForward(SingleLinkedList num1,SingleLinkedList num2){
	
		SingleLinkedList n1=null,n2=null,n=null;
		int l1 = num1.length();
		int l2 = num2.length();
		int padding = Math.abs(l1 - l2);
		//Apply padding
		if(padding>0){
			if(l1>l2)
			{
				n1=num1;
				//apply padding to the beginning
				for(int i=0;i<padding;i++){
					SingleLinkedList temp = new SingleLinkedList(0);
					if(n2==null){
						n2=temp;
						n=n2;
						//n.next=null;
					} else {
						n.next = temp;
						n=n.next;
					}
				}
				n.next = num2;
			}
			else{
				n2=num2;
				//apply padding to the beginning
				for(int i=0;i<padding;i++){
					SingleLinkedList temp = new SingleLinkedList(0);
					if(n1==null){
						n1=temp;
						n=n1;
						//n.next=null;
					} else {
						n.next = temp;
						n=n.next;
					}
				}
				n.next = num1;
			}
		}
		
		PartialCarryRet p = addRecursive(n1,n2);
		if(p.carry > 0)
		{
			SingleLinkedList node = new SingleLinkedList(p.carry);
			node.next = p.node;
			return node;
		}
		else{
			return p.node;
		}
	}
	
	public static PartialCarryRet addRecursive(SingleLinkedList num1, SingleLinkedList num2){
		
		if(num1==null && num2==null){ // This means reached end
			return null;
		}
		
		PartialCarryRet p = addRecursive(num1.next,num2.next);
		int sum=0,carry=0;
		SingleLinkedList node = null;
		if(p==null){ // Last is null
			sum = num1.data + num2.data;
			carry = sum/10;
			sum = sum%10;
		    node = new SingleLinkedList(sum);

			
		}else {
			carry = p.carry;
			SingleLinkedList nextNode = p.node;
			sum = num1.data + num2.data + carry;
			carry = sum/10;
			sum = sum%10;
			node = new SingleLinkedList(sum);
			node.next = nextNode;
		}
		
		PartialCarryRet ret = new PartialCarryRet(node,carry);
		return ret;

	}

	
	public static void main(String[] args){
		SingleLinkedList num1 = new SingleLinkedList(6);
		//num1.appendToTail(7);
		num1.appendToTail(1);
		//num1.appendToTail(7);
		num1.printList();
		
		SingleLinkedList num2 = new SingleLinkedList(2);
		//num2.appendToTail(5);
		num2.appendToTail(9);
		num2.appendToTail(5);
		num2.printList();
		
		SingleLinkedList sum = addForward(num1,num2);
		sum.printList();
		
	}

}


