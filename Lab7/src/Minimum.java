
public class Minimum {
	public static int minimum(int A[], int size) 
	{
		int a = 0;
		if(size > 0 && size != A.length) {
		if (A[size] < A[size-1]) 
		{
			a = A[size-1];
			A[size-1] = A[size];
			A[size] = a;
			minimum(A, size-1);
		}
		else 
			minimum(A, size-1);
		}else if(size == A.length)
		{
			minimum(A, size-1);
		}
		
		return  A[0];
	}
	public static void main(String args[]) 
	{
		int A[] = {10,-20,1,2,0,5,100};
		
		int s = minimum(A, A.length);
		System.out.println(s);
	}
}
