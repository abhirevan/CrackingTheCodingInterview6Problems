package ds.examples;

import java.util.*;

public class SetMapDemo {
	
	public static void main(String[] args){
		
		String[] data = new String("nothing is as easy as it looks").split(" ");
		
		HashSet<String> hs = new HashSet<String>();
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		TreeSet<String> ts = new TreeSet<String>();
		
		HashMap<String,Integer> hm = new HashMap();
		LinkedHashMap<String,Integer> lhm = new LinkedHashMap();
		TreeMap<String,Integer> tm = new TreeMap();
		
		for(String w:data)
		{
			hs.add(w);
			lhs.add(w);
			ts.add(w);
			
			Integer freq = hm.get(w);
			if(freq != null)
			{
				freq++;
			}
			else freq =1;
			
			hm.put(w,freq);
			lhm.put(w,freq);
			tm.put(w,freq);
		}
		
	      /* this prints the HashSet */
	      System.out.println("Hash set: " + hs);
	      System.out.println();

	      /* this prints the hashtable in sorted order*/
	      System.out.println("Tree set: " + ts);
	      System.out.println();

	      /* this prints the hashtable in the order items were inserted */
	      System.out.println("Linked set: " + lhs);
	      System.out.println();

	      System.out.println(hm.size() + " distinct words detected:");
	      System.out.println();

	      System.out.println("Hash map: " + hm);
	      System.out.println();

	      System.out.println("Tree map: " + tm);
	      System.out.println();

	      System.out.println("Linked map: " + lhm);
	      System.out.println();
		
		
	}

}
