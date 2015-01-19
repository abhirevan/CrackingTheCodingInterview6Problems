package ds.problems;

/**
 * Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
 * @author ISILDUR
 *
 */
public class Problem_1_5 {
	
	
	public static String strCompression(String str)
	{
		char refChar = str.charAt(0);
		int charCount=0;
		String compressedStr = new String();
		for(int i=0;i<str.length();i++)
		{
			char currentChar=str.charAt(i);
			if(currentChar==refChar)
			{
				charCount++;
			}
			else
			{
				compressedStr=compressedStr+refChar+charCount;
				refChar = currentChar;
				charCount=1;
			}
		}
		
		compressedStr=compressedStr+refChar+charCount;

		if(str.length()>compressedStr.length())
		{
			return compressedStr;
		}
		else return str;
		
		
	}
	
	public static String strCompressionBetter(String str)
	{
		char refChar = str.charAt(0);
		int charCount=0;
		StringBuffer compressedStr = new StringBuffer();
		
		//String compressedStr = new String();
		for(int i=0;i<str.length();i++)
		{
			char currentChar=str.charAt(i);
			if(currentChar==refChar)
			{
				charCount++;
			}
			else
			{
				//compressedStr=compressedStr+refChar+charCount;
				compressedStr.append(refChar);
				compressedStr.append(charCount);
				refChar = currentChar;
				charCount=1;
			}
		}
		
		//compressedStr=compressedStr+refChar+charCount;
		compressedStr.append(refChar);
		compressedStr.append(charCount);

		if(str.length()>compressedStr.length())
		{
			return compressedStr.toString();
		}
		else return str;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcccdddeeeee";
		System.out.println(s1 + " compressed "+ strCompression(s1));
		System.out.println(s1 + " compressed "+ strCompressionBetter(s1));;

	}

}
