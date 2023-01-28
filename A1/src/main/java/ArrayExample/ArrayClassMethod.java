package ArrayExample;

import java.util.Arrays;

public class ArrayClassMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a[]= {"Learn","Coding","Keypoint","Education"};
		
		System.out.println("toString() "+Arrays.toString(a));
		
		System.out.println("asList() "+Arrays.asList(a));
		
		
		int arr[][]= {{10,20},{30,40}};
		System.out.println("deeptoString() "+Arrays.deepToString(arr));
		
	} 

}
