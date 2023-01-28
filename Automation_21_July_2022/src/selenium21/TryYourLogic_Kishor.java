package selenium21;
import java.io.FileOutputStream;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TryYourLogic_Kishor {
	 public void show() {
	    	System.out.println("Kishor");
	    }
	 public void m1() {
		 System.out.println("Parent class method 2");
	 }
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		//Set<Integer>markss=new HashSet<Integer>();
		 	
		//integer to double
		 int intx=123456;
		 double dx=Integer.valueOf(intx);
		 System.out.println(dx);
		
		 int idx=(int)dx;
		 System.out.println(idx);
		
		 
		//we can convert integer to string using valueOf method of String class
		//int cdx=123456;
		//String scdx=String.valueOf(cdx);
		//System.out.println(scdx);
		//System.exit(0);
		
		
		
		//we can convert string to Double
		String cxx="10.236";
		double cxxd=Double.parseDouble(cxx);
		System.out.println(cxxd);
		System.exit(0);
		
		//write a program to convert string alphabet into number--->We can't convert alphabet to integer
		String citys="Nagpur";
		int cityInNum=Integer.parseInt(citys);//NumberFormatException
		System.out.println(citys+" "+cityInNum);
		
		System.exit(0);
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	    driver=new ChromeDriver();
	    JavascriptExecutor jse=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
	    driver.get("https://www.rgraph.net/svg/bar.html#example");
	    Thread.sleep(2000);
	    //(//*[@class='all-elements'])[1]//*[@stroke='rgba(0,0,0,0)']
	   // List<WebElement> allBar = driver.findElements(By.xpath("(//*[name()='svg'])[1]//*[name()='g' and @class='all-elements']//*[name()='rect']"));
	   List<WebElement>allBars=driver.findElements(By.xpath("(//*[@class='all-elements'])[1]//*[@stroke='rgba(0,0,0,0)']"));
	    for(WebElement a3:allBars) {
	    	action.click(a3).perform();
	    	//a3.click();
	    	//jse.executeScript("arguments[0].click();", a3);
	    	List<WebElement>texts=driver.findElements(By.xpath("//div[@class='RGraph_tooltip']//tr//td[2]"));
	    	
	    	for(WebElement a0:texts) {
	    		System.out.println(a0.getText());
	    	}
	    	
	    }
	    //getcookies
	    Cookie ck=new Cookie("Kishor","Kere");
	    driver.manage().addCookie(ck);
	    Set<Cookie>cookie=driver.manage().getCookies();
	    for(Cookie sdx:cookie) {
	    	System.out.println(sdx.getName());
	    	System.out.println(sdx.getValue());
	    }
	    driver.manage().deleteAllCookies();
	    //getCssValue
	   driver.findElement(By.xpath("//div[@class='RGraph_tooltip']//tr//td[2]")).getCssValue("color");
	    
	    
	    System.exit(0);;
		
		String M1="#457EEE@";
		String M2="4#@57EEE";
		//1.By using string array_character list_eqauls method
		String m_1[]=M1.split("");
		String m_2[]=M2.split("");
		List<Character>list1=new ArrayList<Character>(m_1.length);
		for(int i=0;i<list1.size();i++)
			list1.add(m_1[i].charAt(i));
		List<Character>list2=new ArrayList<Character>(m_2.length);
		for(int i=0;i<list1.size();i++)
			list1.add(m_2[i].charAt(i));
		Collections.sort(list1);
		Collections.sort(list2);
		if (list1.equals(list2))
			System.out.println("---By Using String List---Both Strings have same characters----");
		
		//By using character Array and Arrays class method
		char a11[]=M1.toCharArray();
		char b11[]=M2.toCharArray();
		
		Arrays.sort(a11);
		Arrays.sort(b11);
		
		if(Arrays.equals(a11, b11))
		System.out.println("--By Char Array and ArraysClass----Both String have same characters----");
		
		//By using list of Character List  and list equals method
		List<Character>sdd=new ArrayList<Character>(a11.length);
		for(int i=0; i<a11.length;i++)
		sdd.add(a11[i]);
		List<Character>bdd=new ArrayList<Character>(a11.length);
		for(int i=0;i<b11.length;i++)
	    bdd.add(b11[i]);
		
		if(sdd.equals(bdd))
		System.out.println("--By Char Array and ArraysClass----Both String have same characters----");
	
		System.exit(0);
		
		
		
	    
	    WebDriverWait wait=new WebDriverWait(driver,30);
	    driver.get("https://www.demoblaze.com/");
	    driver.findElement(By.xpath("//a[text()='Phones']")).click();
	    WebElement galaxyS7=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Samsung galaxy s7']")));
	    jse.executeScript("arguments[0].scrollIntoView()", galaxyS7);
	    galaxyS7.click();
	    
	    
	    System.exit(0);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	   // driver.navigate().to("https://google.com/");
	    driver.navigate().to("https://twitter.com/")	;
		Thread.sleep(6000);
		List<WebElement>weblinks=driver.findElements(By.tagName("link"));
		int linkCount=weblinks.size();
//		for(int i=0; i<lx;i++) {
//			String l=link.get(i).getAttribute("href");
//			System.out.println(l);
//		}
		XSSFWorkbook link=new XSSFWorkbook(); //created a blank workbook using XSSFWorkbook class 
		XSSFSheet linkSheet=link.createSheet("all_Links"); //created new sheet in link workbook
		System.out.println("-------Copying data in excel sheet using for loop---------");
		for(int i=0; i<linkCount; i++) {
		    XSSFRow liRow=linkSheet.createRow(i); //created row in sheet 
		     for(int j=0; j<1; j++) {
		    	 XSSFCell liCell=liRow.createCell(j); //created cell in sheet
		    	 String data=weblinks.get(i).getAttribute("href"); //getting text of links from list and storing it in String
		    	 liCell.setCellValue(data); //setting all links in excel sheet cells.
		     }
		}
		
		System.out.println("Successfully stored all links in Excel sheet");
		
		String linkExcel="E:\\Testing\\twitterLinks.xlsx";   //excel sheet path with name stored in string varible
		FileOutputStream fO=new FileOutputStream(linkExcel); //opened blank excel sheet using FileOutputStream class
		link.write(fO); //writing all data in blank excel sheet 
		System.out.println("data copied on link workbook"); 
		link.close(); //closing the excel sheet
		
		System.out.println("done");
		
		
		
		
		Thread.sleep(10000);
		System.exit(0);
		
		driver.manage().window().maximize();
		Dimension setDimension=new Dimension(500,500);
		driver.manage().window().setSize(setDimension);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='gb_yf']")).click();
		Thread.sleep(3000);
		WebElement gframe=driver.findElement(By.xpath("//iframe[@name='app']"));
		driver.switchTo().frame(gframe);
		System.out.println("iframe title is: "+driver.getTitle());
		System.out.println("-------Printing all app names present in iframe-------------");
		List<WebElement>allApps=driver.findElements(By.xpath("//ul//li"));
		for(WebElement apps:allApps) {
			System.out.println(apps.getText());
			}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li//span[text()='Account']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.close();
		System.exit(0);
	  // SearchContext s1= new ChromeDriver();
	    
	    //s1.findElement(By.xpath(" "));
//	    s1.findElements(By.xpath(" "));
	    //class script _JavascriptExecutor Interface 04-08-2022
	    driver.get("https://www.google.com/");
	    Thread.sleep(2000);
	    driver.findElement(By.name("q")).sendKeys("Pune");
	    Thread.sleep(2000);
	    List<WebElement>l1=driver.findElements(By.xpath("//ul[@jsname='erkvQe']//li"));
	    for(WebElement l:l1) {
	    	if(l.getText().contains(" weather")) {
	    		l.click();
	    		break;
	    	}
	    }
	    Thread.sleep(2000);
	    
	  
	    //for scrolling the window according to size
	    js.executeScript("window.scrollBy(0,1200)");
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,-500)");
	    
	    Thread.sleep(3000);
	    WebElement ele=driver.findElement(By.xpath("//h3[text()='Pune - BBC Weather']"));
	    
	    js.executeScript("arguments[0].scrollIntoView()", ele);
	    
	    js.executeScript("arguments[0].click()", ele);
	    Thread.sleep(2000);
	    js.executeScript("alert('Welcome Mr.Kishor')");
	    Thread.sleep(3000);
	    Alert alert=driver.switchTo().alert();
	    alert.accept();
	    Thread.sleep(2000);
	    
	    String title=js.executeScript("return document.URL;").toString();
	    System.out.println("URL is "+title);
	    
	    String domain=js.executeScript("return document.domain;").toString();
	    System.out.println("Domains is "+domain);
	    
	    String URL=js.executeScript("return document.title;").toString();
	    System.out.println("Title is "+URL);
	    
	    Thread.sleep(1000);
	    js.executeScript("window.location='https://opensource-demo.orangehrmlive.com/'");
	    Thread.sleep(2000);
	    
	    driver.close();
	    
	    System.exit(0);
	    
System.out.println("-----------------------------------------------------------------");		
	    
		//swap the number without using the third varibale
		int x=10, y=20;
		System.out.println("Before swao: a= "+x+" b= "+y);
		 x=x+y; //a=10+20=30
		 y=x-y; //b=30-20=10
		 x=x-y; //a=30-10=20
		 System.out.println("After swap: a= "+x+" b= "+y);
		
		
		
	
		//Print right side pyramid
		int row=10;
		for(int i=0; i<row;i++) {
			for(int j=2*(row-i);j>0;j--) {
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		

		
		//Print fibbonnaci series of numbers
		//of 5 numbers
		
		int first=1,next=2,sum;
		for(int i=0;i<10;i++) {
			System.out.println(first);
			sum=first+next;
			first=next;
			next=sum;
		}
		
		String name5="Start the of program from start of the program";
		String a1[]=new String[name5.length()];
		a1=name5.split(" ");
		String dup=" ";
		System.out.println(a1[0]);
		for(int i=0; i<a1.length;i++) {
			
			for(int j=i+1;j<a1.length;j++) {
				if(a1[i].equalsIgnoreCase(a1[j])) {
					dup=a1[i];

					System.out.println(dup); 
				}
			}
			
			}
			
			
System.out.println("-----------------------------------------------------------------");		
		HashMap<String,Integer>wordSet=new HashMap<String,Integer>();
		for(String a:a1) {
			if(wordSet.containsKey(a.toLowerCase())) {
			wordSet.put(a.toLowerCase(), wordSet.get(a.toLowerCase())+1);
		}
			else {
				wordSet.put(a.toLowerCase(), 1);
			}
		}
		
		Set<String>s=wordSet.keySet();
		for(String z:s) {
			if(wordSet.get(z)>1) {
				System.out.println("Duplicate word is with count: "+z+" :"+wordSet.get(z));
			}
		}
		
System.out.println("----------------------------------------------------------------------");
		System.out.println("System termintated");
		
		
		
		
		
		//Below program is to check whether the string is palidrome or not
		String name2="NAAN";
		String rev="";
		for(int i=name2.length()-1; i>=0;i--) {
			rev=rev+name2.charAt(i);
		}
		System.out.println(rev);
		if(rev==name2) {
			System.out.println("Palidrome");
		}
		else {
			System.out.println("Not Palidrome");
		}
		
		if(rev.equals(name2)){
			System.out.println("Palidrome ahe");
		}
		
		
		
		
		
		
		
System.out.println("-------------------------------------------------------------------");		
		
		 //class script _WindowHandling Methods from WebDriver Interface 03-08-2022
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a//img[@alt='LinkedIn OrangeHRM group']")).click();//	    driver.findElement(By.xpath("//a//img[@alt='OrangeHRM on Facebook']")).click();
	    driver.findElement(By.xpath("//a//img[@alt='OrangeHRM on twitter']")).click();
	    driver.findElement(By.xpath("//a//img[@alt='OrangeHRM on youtube']")).click();
	    
	    
	    String parentID=driver.getWindowHandle();
	    System.out.println(parentID);
	    
	    Set<String>allIDs=driver.getWindowHandles();
	    LinkedHashSet<String>lHS=new LinkedHashSet<String>(allIDs.size());
	    lHS.add("Kishor");
	    List<String>allIDs2=new ArrayList<String>(allIDs);
	    
	    driver.switchTo().window(allIDs2.get(2));
	    
	    Object[] arrayID = allIDs.toArray();
	    String[] stringIDs=new String[allIDs.size()];
	    
	    for(int i=0; i<allIDs.size();i++) {
	    	stringIDs[i]=arrayID[i].toString();
	    }
	    Thread.sleep(3000);
	    driver.switchTo().window(stringIDs[3]);
	    
	    for(String sd:allIDs) {
	    	System.out.println(allIDs);
	    	
	    	if(!sd.equals(parentID)) {
	    		driver.switchTo().window(sd);
	    		
	    	}
	  	    }
	 
	    Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[contains(@name,'email-or-phone')]")).sendKeys("kishor");
	    Thread.sleep(3000);
	    driver.switchTo().window(parentID);
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	 
	    System.out.println("-------------------------------------------------------------------");
		//to print new line use +"\n"+ or just \n at end on current string
		System.out.println("I am Kishor"+"\n"+"Jay Shri Ram");
		System.out.println("I am Kishor\nJay Shri Ram");
		
		String name="Kishor";		
		String name1=new String("Kishor");
		String name8="Kishor";
		String name3=new String("Kishor");
		
		boolean a,b,c,d,e,f;
		
		a=name.equals(name8); //true
		b=name1.equals(name3);//true
		c=name.equals(name1);//true
		
		d=name==name8;//true
		e=name==name1;//false
		f=name1==name3;//false
		
		System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f);
		
	}
}
/*
TryYourLogic_Kishor t=new child();
TryYourLogic_Kishor k=new TryYourLogic_Kishor();
child c1=(child)t;
child s=new child();
System.out.println("----Using upcasting-----");
t.m1();
t.show();
System.out.println("------using parent class object and ref.variable--------");
k.m1();
k.show();
System.out.println("-----using downcasting-----");
c1.child1();
c1.m1();
c1.show();
System.out.println("----using child class object----");
s.child1();
s.m1();
s.show();

//07-08-2022 SUNDAY 11:40AM 

}

class child extends TryYourLogic_Kishor{

public void show() {
	System.out.println("Child class");
}
public void child1() {
	System.out.println("I am child");
}
}

*/











