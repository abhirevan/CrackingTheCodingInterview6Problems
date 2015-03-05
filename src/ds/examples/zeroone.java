package ds.examples;

import java.util.*;


public class zeroone {
	
	public static ArrayList<Integer> findMultiple(int a, int c){
		 ArrayList<Integer> multipliers = new ArrayList<Integer>(); 
		 for(int i=1;i<=9;i++){
	            int temp = i*a+c;
	            if(temp%10==1 || temp%10==0){
	             System.out.print("m:"+i);
	            	multipliers.add(i);
	            }
	            
	        }
		 System.out.println();
	        return multipliers;
	        
        
    }
    
    public static boolean checkCarry(int c){
        int temp =c;
        while(temp>0){
            if(temp%10 == 0 || temp%10 == 1){
                temp/=10;
            }
            else return false;
        }
        return true;
    }
    
    public static void findZONumber(int n){
        ArrayList<Integer> retNum = new ArrayList<Integer>();
        int carry=0;
        int ilDigit = n%10;
        int iteration=0;
        ArrayList<Integer> carrys= new ArrayList<Integer>();
        carrys.add(carry);
        boolean breakCondition = true;
        boolean revert=false;
        do{
        	int multiple=0;
        	ArrayList<Integer> multipliers = findMultiple(ilDigit,carry);

        	
        	if(multipliers.size()>1){
	        	if(revert==false)
	        	{
	        		int tempProd = multipliers.get(0)*n+carry;
	        		if(carry==tempProd/10 && iteration>0){
	            		//something went worng -- revert
	            		revert = true;
	            		
	            		carry=carrys.get(carrys.size()-2);
	            		carrys.remove(carrys.size()-1);
	            		retNum.remove(retNum.size()-1);
	            		continue;
	            	}
	        		else multiple = multipliers.get(0);
	        	}
	        	else
	        	{
	        		revert = false;
	        		 multiple = multipliers.get(1);
	        	}
        	}
        	else{
        		multiple = multipliers.get(0);
        	}
        	/*
        	if(revert==true)
        		continue;*/
        		
 
        	System.out.println("used:"+multiple);
            int prod = multiple * n+carry;
            retNum.add(prod%10);
            carry=prod/10;
            carrys.add(carry);
            if(checkCarry(carry)){
                breakCondition=false;
                //copy carry bits into Array
                int temp =carry;
                while(temp>0){
                    retNum.add(temp%10);
                    temp/=10;
                }
                
            }
            iteration++;
            
        }while(breakCondition);
        
        //Iterator itr = retNum.iterator();
        /**
        while(itr.hasNext())
        {
        	System.out.print(itr.next());
        }
        **/
        //System.out.println();
        for(int i=retNum.size()-1;i>=0;i--){
        	System.out.print(retNum.get(i));
        }
        
        
        
        
        
    }

	public static void main(String[] args) {

		findZONumber(9999);
		
	}

}
