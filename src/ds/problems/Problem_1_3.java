package ds.problems;
import java.util.Arrays;



/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Problem_1_3 {
	
	//Asuming ascii
	public static boolean checkPermAscii(String s1, String s2)
	{
		if(s1.length()!=s2.length())
		{
			return false;
		}
		else{
			
			int[] s1Bucket = countBucket(s1);
			int[] s2Bucket = countBucket(s2);
			for(int i=0;i<s1Bucket.length;i++)
			{
				if(s1Bucket[i]!=s2Bucket[i])
					return false;
			}
			return true;
		}

	}
	
	//Assuming nonAscii - large character set
	
	public static boolean checkPermNonAscii(String s1, String s2)
	{
		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		if(s1Array.length!=s2Array.length)
		{
			return false;
		}
		else{
			Arrays.sort(s1Array);
			Arrays.sort(s2Array);
			for(int i=0;i<s1Array.length;i++)
			{
				if(s1Array[i]!=s2Array[i])
					return false;
			}
			return true;
		}
	}
	
	
	public static int[] countBucket(String s)
	{
		int[] bucket = new int[255];
		for(int i=0;i<s.length();i++)
		{
			bucket[s.charAt(i)]++;
		}
		return bucket;	
	}
	
	public static void main(String[] args)
	{
		String s1 = "ASDS";
		String s2 = "SADA";
		System.out.println(s1+" "+s2+" "+checkPermNonAscii(s1,s2));
	}

}
