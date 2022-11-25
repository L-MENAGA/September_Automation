package Cucumber_Mrng_Project.Cucumber_Mrng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BDD_Home_Page {
	
	public WebDriver driver;
	
//	@FindBy(id= "email" )
//	private WebElement email;
//	
//	@FindBy(id = "passwd")
//	private WebElement password;
//	
//	@FindBy(name ="SubmitLogin")
//	private WebElement Login;
//
//	public BDD_Home_Page(WebDriver driver2) {
//		this.driver = driver2;
//		PageFactory.initElements(driver, this);
//		}
//	public WebElement getEmail() {
//		return email;
//	}
//	
//	public WebElement getPassword() {
//		return password;
//	}
//	public WebElement getLogin() {
//		return Login;
//	}
	
	
	//********************** For Adactin**********************
	
	@FindBy(id= "username" )
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id ="login")
	private WebElement Login;

	public BDD_Home_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
		}
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return Login;
	}

}
