package JavaPrograms;

public class Remove_whitespace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str ="java  programming   selenium     Automation";
		
		
		
		System.out.println("Before removing the white space:"+str);
		
		str=str.replaceAll("\\s", "");
		
				System.out.println("After removing the white space:"+str);
	}

}
