package bit.examples;

public class bitManipulationExamples {
	
	public static boolean getBit(int num,int i){
		return ((num & (1<<i))!=0);
	}
	
	public static int setBit(int num, int i){
		int mask = 1<<i;
		return num | mask;
	}
	
	public static int clearBitPos(int num, int i){
		int mask = ~(1<<i);
		return num & mask;
	}
	
	public static int clearBitMSB(int num, int i){
		int mask = ~(1<<i);
		return num & mask;
	}
	
	public static int clearBitLSB(int num, int i){
		int mask = ~(1<<i);
		return num & mask;
	}
	


	public static void main(String[] args) {
		
		System.out.println(getBit(7,1));
		
		System.out.println(setBit(5,1));


	}

}
