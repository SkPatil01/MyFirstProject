package JavaPrograms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Approach1
   // int a[]= {10,40,20,30,60};
    
   // System.out.println("After elements before sorting:"+Arrays.toString(a));
    //Arrays.parallelSort(a);
   // System.out.println("After elements After sorting:"+Arrays.toString(a));
    
    //Approach 2
/* int a[]= {10,40,20,30,60};
    
    System.out.println("After elements before sorting:"+Arrays.toString(a));
    Arrays.sort(a);
    System.out.println("After elements After sorting:"+Arrays.toString(a));
    
    reverse Descending order
    */
		Integer a[]= {10,40,20,30,60};
	    
	    System.out.println("After elements before sorting:"+Arrays.toString(a));
	    Arrays.sort(a,Collections.reverseOrder());
	    System.out.println("After elements After sorting:"+Arrays.toString(a));
	}

}
