package ArrayExample;

import java.util.Scanner;

public class FindLenghtOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a[]=new int[3]; 
		Scanner r=new Scanner(System.in);
		System.out.print("Enter elments in array ");
		
		for(int i=0; i<a.length; i++)
		{
			a[i]=r.nextInt();
		}
		
		System.out.print("Array elements");
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+"  ");
		}
		
		System.out.print("Array lenght"+ a.length);
	}

}
