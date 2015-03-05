package ds.examples;
import java.util.*;

public class countPalindromes {
	
	static int palindrome(String str) {
	HashSet<CharSequence> UP = new HashSet<CharSequence>();
        
        //Add single chars first
        for(int i =0; i<str.length();i++){
            UP.add(str.subSequence(i,i+1));
        }
        
        for(int i=1;i<str.length()-1;i++){
            //Odd palindromes
            for(int j=i-1,k=i+1;j>=0 && k<=str.length()-1;j--,k++){
                if(str.charAt(j)==str.charAt(k)){
                    UP.add(str.subSequence(j,k+1));
                } else break;
                
            
            }
        }
        
        for(int i=0;i<str.length()-1;i++){
            //Even palindromes
            for(int j=i,k=i+1;j>=0 && k<=str.length()-1;j--,k++){
                if(str.charAt(j)==str.charAt(k)){
                    UP.add(str.subSequence(j,k+1));
                } else break;
                
            
            }
        }

        
       // Iterator itr = UP.iterator();
        
        
        
        Iterator itr = UP.iterator();
        System.out.println("Palindromes");
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        
        //Check for Unique single 
        return UP.size();

    }
	
	public static void main(String[] args){
		palindrome("");
	}

}
