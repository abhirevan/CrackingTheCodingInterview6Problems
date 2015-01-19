package ds.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {
	
	public static HashSet<String> buildDictionary() throws IOException
	{
		URL url = new URL("http://www.andrew.cmu.edu/course/15-121/dictionary.txt");
		Scanner sc = new Scanner(url.openStream());
		
		HashSet<String> dictionary = new HashSet<String>();
		while(sc.hasNext())
		{
			dictionary.add(sc.next());
		}
		return dictionary;
	}
	
	public static void checkDictionary(HashSet<String> dictionary) throws FileNotFoundException
	{
		String filename = System.getProperty("user.dir")+"\\src\\me\\ds\\examples\\SpellChecker.java";
		System.out.println(filename);
		Scanner sc = new Scanner(new File(filename));
		System.out.println("Misspelled words");
		int count=0;
		while(sc.hasNextLine())
		{
			String[] tokens = sc.nextLine().split("\\W");
			for(String t:tokens){
				if((t.length() > 1) && (!dictionary.contains(t.toLowerCase()))){
					count++;
					System.out.print(t+ " ");
				}
			}
		}
		System.out.println();
		System.out.println("Number of misspelled words "+count);
	}
	
	
	public static void main(String[] args) throws IOException
	{
		HashSet<String> dictionary = buildDictionary();
		System.out.println(dictionary.size());
		checkDictionary(dictionary);
		
	}

}
