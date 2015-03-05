package ds.examples;
import java.util.*;

public class SuperPower {
	
static void factorize(int z) {
        
        //first factorize z into prime factors store in tree map
        HashMap<Integer,Integer> primeFactors = new HashMap<Integer,Integer>();
        int minFactor=1;
        int copyZ = z;
        int factor =2;
        
        while(copyZ>1){
            if(copyZ%factor == 0){
                copyZ= copyZ/factor;
                Integer freq = primeFactors.get(factor);
                if(freq != null){
                    freq++;
                }else{
                    freq =1;
                }
                primeFactors.put(factor,freq);
            }
            else{
                factor++;
            }
        }
        
        
        System.out.println(primeFactors);


    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		factorize(26);
		factorize(2);

	}

}
