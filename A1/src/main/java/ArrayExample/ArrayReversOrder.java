package ArrayExample;

import java.util.Scanner;

public class ArrayReversOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// input a[5]= 10 20 30 40 50   ----->  50 40 30 20 10
		
		int a[]=new int[5];
		Scanner r=new Scanner(System.in);
		System.out.println("Enter elements in array");
		for(int i=0;i<a.length; i++)
		{
			a[i]=r.nextInt();
		}
		System.out.println(" array element");
		for(int i=0;i<a.length; i++)
		{
			System.out.println(a[i]+" ");

		}
		System.out.println(" array reverse element");
		for(int i=a.length-1;i>=0; i--)
		{
			System.out.println(a[i]+" ");

		}

	}

}
