package ds.problems;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place?
 * 
 * 
 */
public class Problem_1_6 {
	
	public static void print2D(int[][] m)
	{
		System.out.println("");
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<m[i].length;j++)
			{
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static int[][] rotate90(int[][] m, int n)
	{
		int[][] r = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				r[j][n-i-1] = m[i][j];
			}
		}
		return r;
	}
	
	public static int[][] rotate90Inplace(int[][] m, int n)
	{
		for(int i =0;i<n/2;i++)
		{
			m=rorateLayerInplace(m,i,n);
		}
		return m;
	}
	
	public static int[][] rorateLayerInplace(int[][] m, int index,int n)
	{
		int i=index;
		int length=n-2*index;
		for(int j=index;j<index+length-1;j++)
		{	
			int seed = m[n-1-j][i];
			m[n-1-j][i]=m[n-1-i][n-1-j];
			m[n-1-i][n-1-j]=m[j][n-1-i];
			m[j][n-1-i]=m[i][j];
			m[i][j]=seed;
		}
		return m;
	}
	
	public static void main(String[] args)
	{
		int[][] m1 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int[][] m2={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		print2D(m2);
		print2D(rotate90Inplace(m2,4));

		
	}

}
