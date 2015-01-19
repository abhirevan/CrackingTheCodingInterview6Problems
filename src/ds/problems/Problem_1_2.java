package ds.problems;

/*
 * Implement a function void reverse(char* str) in C or C++ which reverses a nullterminated
string.
 */
public class Problem_1_2 {
	
	public static String revStr(String s)
	{
		char[] str = s.toCharArray();
		for(int i=0;i<str.length/2;i++)
		{
			char temp = str[i];
			str[i]=str[str.length-i-1];
			str[str.length-i-1]=temp;
		}
		
		String revString = String.valueOf(str);
		return revString;
		
	}
	
	public static void main(String[] args)
	{
		String s = "Hello";
		System.out.println(s+" reverse "+revStr(s));

	}

}
