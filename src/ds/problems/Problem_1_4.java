package ds.problems;

/**
 * 
 * @author ISILDUR
 
 Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if implementing
in Java, please use a character array so that you can perform this operation
in place.)
EXAMPLE
Input: "Mr John Smith
Output: "Mr%20Dohn%20Smith"

 */

public class Problem_1_4 {

	public static void replaceSpaces(String s1)
	{
		System.out.println("Input string is:"+ s1+"|");
		char[] inputString = s1.toCharArray();
		int length=inputString.length;	
		/*
		for(char c:inputString)
		{
			if(c!= '\0')
			{
				length++;
			}
		}
		*/
		int ipIndex=-1,opIndex=length-1; // Initially points to the last char of the o/p string
		
		for(int i=opIndex;i>=0; i--)
		{
			if(inputString[i]!=' ')
			{
				ipIndex = i; // Initially points to the last char of the i/p string
				break;
			}
		}

		while(ipIndex >=0)
		{
			if(inputString[ipIndex] != ' ')
			{
				inputString[opIndex]= inputString[ipIndex];
				opIndex--;
				ipIndex--;
			}
			else{//if space encountered
				ipIndex--;
				inputString[opIndex]='0';
				inputString[opIndex-1]='2';
				inputString[opIndex-2]='%';
				opIndex=opIndex-3;
			}
		}
		
		for(char c:inputString){
			System.out.print(c);
		}
		System.out.println("|");
	}
	
	public static void main(String[] args){
		
		String s1 = "Mr John Smith    ";
		System.out.println("Replaced string is: ");
		replaceSpaces(s1);
	}
	

}
