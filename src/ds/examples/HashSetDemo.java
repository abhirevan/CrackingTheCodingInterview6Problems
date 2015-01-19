package ds.examples;


import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	
	
	public static void main(String[] args)
	{
		String[] colors = {"white", "pink", "red", "green", "red", "orange"};
		
		HashSet<String> hs = new HashSet<String>();
		for(String color:colors){
			hs.add(color);
		}
		System.out.println("HS size "+hs.size());
		Iterator itr = hs.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
	}

}
