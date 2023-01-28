package ArrayExample;

public class try_catch {

	public static void main(String[] args) {

		String str ="krishna";
		try {
			int a=Integer.parseInt(str);
			System.out.println(a);
			
		}catch(NumberFormatException n)
		{
			System.out.println("String"+str+"can't be converted to Integer");
		}
		System.out.println("main method ended");
	}

}
