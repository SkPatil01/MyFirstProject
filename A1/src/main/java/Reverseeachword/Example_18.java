package Reverseeachword;

import java.util.Scanner;

public class Example_18 {
	


	String rev(String str) {
		String reverse="";
		for(int i=str.length()-1; i>=0; i--) {
			char ch = str.charAt(i);//j
			reverse = reverse  + ch;//avaj
		}
		return reverse;
	}
	
	  void word(String str) {
		  String word="";
		  String reverse="";
		  str = str.trim() + "";
		  for(int i=0; i<str.length(); i++){
			  char ch = str.charAt(i);//a
			  if(Character.isWhitespace(ch)) {
				  
				reverse = reverse + rev(word)  + "";// avaj si _ _ _
				word= "";
				  
			  }else {
				  word= word + ch;//java
			  }
		  }
		  System.out.println("output :"+reverse.trim());
		  
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Example_18 ref= new Example_18();
     Scanner sc = new Scanner(System.in);
     System.out.println("input :");
     String str =sc.nextLine();
     
     ref.word(str);
	}

}
