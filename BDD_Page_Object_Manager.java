package Cucumber_Mrng_Project.Cucumber_Mrng;

import org.openqa.selenium.WebDriver;

public class BDD_Page_Object_Manager {
	
	//private classname Objectname;
	
	public WebDriver driver;
	private BDD_Login_Page login; //--null
	private BDD_Home_Page hp;// null
	private BDD_MyStore_Page mp; //null
	
	public BDD_Page_Object_Manager(WebDriver driver2) {
		this.driver=driver2;
	}

	public BDD_Login_Page getInstanceLogin(){
		
		if(login==null) {
			 login= new BDD_Login_Page(driver);
		}
		
	return login;
	}
		
	public BDD_Home_Page getInstanceHp() {
		if(hp == null) {
			hp = new BDD_Home_Page(driver);
		}
		return hp;
		
	}
	
	public BDD_MyStore_Page getInstanceMp() {
		 if(mp==null) {
			 mp= new BDD_MyStore_Page(driver);
			 
		 }
		 return mp;
	}
	

}
