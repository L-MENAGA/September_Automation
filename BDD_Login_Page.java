package Cucumber_Mrng_Project.Cucumber_Mrng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BDD_Login_Page {
	public WebDriver driver;  // -- Null
	@FindBy(xpath= "//a[@class='login']")
	private WebElement SignIn;

	public BDD_Login_Page(WebDriver driver2) {
		
			this.driver=driver2;
			
			PageFactory.initElements(driver, this);
	}

	public WebElement getSignIn() {
		return SignIn;
	}

}
