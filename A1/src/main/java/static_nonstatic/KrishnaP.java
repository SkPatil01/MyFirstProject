package static_nonstatic;

public class KrishnaP {

	
	int age= 30;//instance variable
	static int age2=32; //static variable
	
	public static void main(String[] args) { 

	KrishnaP kp=new KrishnaP();//object creation
    kp.Schoolname();//non static method
    Schoolbord();//static method
    kp.hospital();//non static method
    KrishnaP.printname();//static method   /for  run program ctrl+f11
    kp.village();//non static
    district();//static method        / error import   ctrl+shift+O
    KrishnaP.district();//static method
    }
	public void Schoolname () 
	{
		System.out.println("Niketan");
	}
	public static void Schoolbord ()
	{
		System.out.println("nashikbord");
	}
	public void hospital()
	{
		System.out.println("Mamtahospital");
	}
	public static void printname()
	{
		System.out.println("kishor");
	}
	public void village()
	{
		System.out.println("chapoli");
	}
	public static void district()
	{
		System.out.println("latur");
	}
	public void KrishnaP()
	{
		  System.out.println();                         //Default Constructor
	}
	}
