package ds.problems;
/*
 * 
 * Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional data structures?
 */

public class Problem_1_1 {
	
	public static boolean checkIfUnique(String s)
	{
		//Assuming ascii - 255 max chars
		if(s.length() > 255)
			return false; 
		else
		{
			boolean[] bucket = new boolean[255]; //255 max size of array
			//init bucket to false
			for(int i=0;i<s.length();i++)
			{
				bucket[i]= false;
			}
			for(int i=0;i<s.length();i++)
			{
				int c=s.charAt(i);
				if(bucket[c]==false)
					bucket[c] = true;
				else return false;
			}
			return true;
			
		}
	}
	
	//below if str is only lower case ascii
	public static boolean checkIfUniqueAscii(String s)
	{
		int checker =0;
		for(int i=0;i<s.length();i++)
		{
			int val = s.charAt(i) - 'a';
			if( (checker & (1 << val)) > 0)
			{
				return false;
			}
			else checker = checker | (1 << val);
				
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String s1 = "abcdef g";
		String s2 = "Hello g!";
		System.out.println(s1+" uniqueness: "+checkIfUniqueAscii(s1));
		System.out.println(s2+" uniqueness: "+checkIfUnique(s2));
	}

}
