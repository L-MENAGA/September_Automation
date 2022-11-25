package Cucumber_Mrng_Project.Cucumber_Mrng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BDD_MyStore_Page {
	
	public WebDriver driver;
	@FindBy(xpath="(//a[@title='Dresses'])[2]")
	private WebElement Dresses;
	
	@FindBy(xpath ="//a[@class='logout']")
	private WebElement Sign_out;

	public BDD_MyStore_Page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getDresses() {
		return Dresses;
	}

	public WebElement getSign_out() {
		return Sign_out;
	}

	
}
