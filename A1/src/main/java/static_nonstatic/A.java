package static_nonstatic;

public class A {

	int a= 10;
	static int b =20;
	public static void main(String[] args) {
       A r=new A();
       r.disp();
       A.show();
		
	}
      static void show() 
      {
    	 System.out.println(b); 
      }
      void disp()
      {
    	  System.out.println(a);
      }
}
