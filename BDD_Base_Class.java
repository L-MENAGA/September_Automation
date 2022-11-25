package Cucumber_Mrng_Project.Cucumber_Mrng;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class BDD_Base_Class {
	public static WebDriver driver; //--null
	public static String value;
	public static WebDriver getBrowser( String type) {
		if(type.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir") + "//Driver//chromedriver.exe");
	
			 driver = new ChromeDriver();
			}
		
		else if(type.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir") + "//Driver//firefox.exe");
	
			 driver = new FirefoxDriver();
			
			}
				driver.manage().window().maximize();
				return driver;
	}
	
	public static void inputValueElement(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	public static void url( String  url) {
		driver.get(url);
		
	}
	
	public static  void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	private void clear(WebElement element) {
		element.clear();
	}
	
	public static void sleep(int   milliseconds) throws InterruptedException{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void implicitwait(int Time, TimeUnit format) {
		driver.manage().timeouts().implicitlyWait(Time, format);
	}
	
	public static void scrollUpandDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static void actionClass(String actionName,  WebElement element) {
		Actions a = new Actions(driver);
		if(actionName.equalsIgnoreCase("MoveTo")) {
			a.moveToElement(element).build().perform();
		}
		else if(actionName.equalsIgnoreCase("Click")) {
			a.click(element).build().perform();
		}
		else if(actionName.equalsIgnoreCase("DoubleClick")) {
			a.doubleClick(element).build().perform();
		}
		else if(actionName.equalsIgnoreCase("ContextClick")) {
			a.contextClick(element).build().perform();
		}
		else if(actionName.equalsIgnoreCase("ClickAndHold")) {
			a.clickAndHold(element).build().perform();
		}

	}	
		public static void screenShot() throws Exception {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File f = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(f, new File("C:\\Users\\Admin\\eclipse-workspace\\Selenium_PG\\Screenshot.png"));
			}
		
		public static void frames(String frameType, String id, String value, WebElement element) {
			if(frameType.equalsIgnoreCase("FramebyId")) {
				driver.switchTo().frame(id);
			}
			else if(frameType.equalsIgnoreCase("FrameByElement")) {
				driver.switchTo().frame(element);
			}
			else if(frameType.equalsIgnoreCase("FrameByIndex")) {
				int  index = Integer.parseInt(value);
				driver.switchTo().frame(index);
			}
			else if(frameType.equalsIgnoreCase("ParentFrame")) {
				driver.switchTo().parentFrame();
			}
			else if(frameType.equalsIgnoreCase("Default")) {
				driver.switchTo().defaultContent();
			}
			
			}
		
		public static String input_From_Excel(String path,int row_Index, int cell_Index) throws Throwable{
			File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheetAt = wb.getSheetAt(0);
			Row row = sheetAt.getRow(row_Index);
			Cell cell = row.getCell(cell_Index);
			CellType cellType = cell.getCellType();
			if(cellType.equals(cellType.STRING)) {
				 value = cell.getStringCellValue();
			}
			else if (cellType.equals(cellType.NUMERIC)){
				double CellValue = cell.getNumericCellValue();
				int val= (int) CellValue;
				 value = String.valueOf(val);
			}
			
			return value;
		}
		
		
}
	
	



