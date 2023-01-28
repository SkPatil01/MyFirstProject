package JavaPrograms;

public class Rmovejunk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="@#$%%%^&* latin string 0123456789";
		String s1="@$%^^&** Testing @#$%^^&** Selenium @#$%^&* java";
		
		s=s.replaceAll("[^a-zA-Z0-9]","");
		
		System.out.println(s);
		
		s1=s1.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s1);
		
		
	}

}
