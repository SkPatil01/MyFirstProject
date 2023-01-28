package ArrayExample;

public class Array_try_catch {

	public static int retInt() {
		int a= 100;
		try 
		{
			
			return a; 
		}
		catch (ArithmeticException n) {
			System.out.println("Catch called");
			System.out.println(n);
			
		}finally {
			System.out.println("finally called");
		}
		return a;
		
	}
	public static void main(String[] args) {
 
		System.out.println(retInt());
	}

}
