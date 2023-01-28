package ArrayExample;

public class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try
{
	int a=10,b=2,c;
	c=a/b;
	System.out.println(c);
	
	int arr[]= {10,20,30,};
	System.out.println(arr[1]);
	
	String str="krishna";
	System.out.println(str.toUpperCase());
} 	
	
catch(ArrayIndexOutOfBoundsException a)
{
	System.out.println("Array Exception");
}
catch(ArithmeticException e)
{
	System.out.println("Arithmatic exception");
}
 catch(NumberFormatException n)
 {
	 System.out.println(" Number Exception");
 }
 catch(Exception x)
 {
	 System.out.println("All type Exception handled");
 }
 
}	

}
