package Collection_framework;

import java.util.ArrayList;

public class ArrayListDemo_1 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      // it contain duplicate elements
		// java ArrayList class maintain the insertion order
		//it is a non synchronised or non thred safe
		// ArrayList gives random access to element due to indexing from storage
		//shifting of element is more ArrayList
		
		ArrayList<Object> ref=new ArrayList<Object>();
		ref.add(15);
		ref.add(16);
		ref.add(17);
		ref.add("krishna");
		ref.add(11.50);
		ref.add('k');
		
		System.out.println(ref);
		System.out.println("using for loop------");
		
		for(Object o:ref) {
			System.out.println(o);
		}
		
		
		//generic ArrayLis---String Datatype
		
		ArrayList<String>ref1= new  ArrayList<>();
		ref1.add("ruby");
		ref1.add(null); 
		ref1.add("java");
		ref1.add("pythan");	
		
		System.out.println(ref1);
		for(Object str1:ref1){
			System.out.println(str1);
		}
		System.out.println("using index of object------");
		System.out.println(ref1.get(1));
		System.out.println(ref1.get(3));
	}

}
