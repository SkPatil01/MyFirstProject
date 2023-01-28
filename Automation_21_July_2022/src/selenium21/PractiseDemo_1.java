package selenium21;


public class PractiseDemo_1 extends Thread {
	
	public void run() {
		
		int a=10, b=20;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("a is: "+a+" /nb is : "+b);
		a=a+b; b=a-b;a=a-b;
		System.out.println("Final value of a is: "+a +" /nand of b is: "+b);
		
	}
	
	static int show(int marks) {
		 int a,b,c,d=0;
		 a=121;
		 b=a;
		 while(a>0) {
			 c=a%10;
			 a=a/10;
			 d=d*10+c;
		 }
		 if(b==d) {
			 System.out.println("this is palidrome number");
		 }
		 else {
			 System.out.println("Not a palidrome");
		
		 }
		
		return d;
		
	}
	
	
     
		public static void main(String[] args) {
			PractiseDemo_1 pd=new PractiseDemo_1();
			pd.setName("Thread 1");
			pd.setPriority(MAX_PRIORITY);
			Long b=	pd.getId();
			String name=pd.getName();
			int a=	pd.getPriority();
			pd.getState();
			 boolean aa= pd.isAlive();
			  boolean ba=pd.isDaemon();
			pd.run();
			pd.start();
			System.out.println(b+" "+name+" "+a+" "+aa+" "+ba);
			show(125);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
}
			
			
			
			
			
			
			
		
		
		
	

		
	


