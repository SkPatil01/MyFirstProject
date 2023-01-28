package exception;

public class multipleCatch {

	public static void main(String[] args) {
		
		
		try 
		{  
			int a=10,b=2,c;
			c=a/b;
			System.out.println(c);
			
			int Arr[]= {10,20,30,};
		System.out.println(Arr[2]);
		
		String str="ankit";
		System.out.println(str.toUpperCase());
					
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Array Exception");
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Arithmetic Exception");
		}
		catch(NumberFormatException n)
		{
			System.out.println("Number Exception");
		}
		
		catch(Exception x)
		{
			System.out.println("All type Exception handled");
		}
		
		//Exception x=new NullpointerException();
	
 
	}

}
