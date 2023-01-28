package utility;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void takeShot(WebDriver driver,String filename) throws IOException {
		TakesScreenshot tks=(TakesScreenshot)driver;
		String path="E:\\Testing\\"+filename+".png";
		File src=tks.getScreenshotAs(OutputType.FILE);
		File target= new File(path);
		FileUtils.copyFile(src, target);
		
	}

}
