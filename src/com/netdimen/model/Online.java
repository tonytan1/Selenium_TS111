package com.netdimen.model;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.netdimen.abstractclasses.TestObject;
import com.netdimen.config.Config;
import com.netdimen.config.Labels;
import com.netdimen.controller.TestDriver;
import com.netdimen.utils.WebDriverUtils;
import com.netdimen.view.EmailUI;
import com.netdimen.view.Navigator;

/**A parent class for sub-class AICC.  
 * 
 * @author martin.wang
 *
 */
public class Online extends LearningModule{

	public Online(){
		super();
	}

	public void checkExpectedResult_UI(WebDriver driver, String expectedResult){
		super.checkExpectedResult_UI(driver, expectedResult);
	}


	@Override
	public boolean equals(TestObject obj){
		if(obj instanceof Online && ((Online)obj).toString().equals(this.toString())){
			return true;
		}else{
			return false;
		}
	}


	public void importContentPackage_UI(WebDriver driver){
		/*WebElement we = driver.findElement(By.xpath("//button/span/span[contains(text(),'Import New Revision')]"));
		WebDriverUtils.mouseOver_UI(driver, we);*/

		//		driver.findElement(By.linkText("Import content package")).click();
	}
	/**
	 * set a module completion deadline for module, and check if system send Gentle Deadline Reminder to learner
	 * @param driver
	 * @param sysSetup
	 */
	public void runSendDeadlineReminder (WebDriver driver, ArrayList<TestObject> sysSetup){
		Navigator.navigate(driver, Navigator.webElmtMgr.getNavigationPathList(
				"ManageCenter", "2.Modules"));
		
		//open catalog editor
		this.searchModule(driver);
		WebDriverUtils.switchToPopUpWin(driver);
		WebDriverUtils.switchToFrame(driver, "BSCAT_LEFT");
		Navigator.explicitWait(1000);
		
		//go to session
		By by = By.xpath("//a[contains(text(),'"+Labels.Link_Sess_Properties+"')]");
		WebDriverUtils.clickLink(driver, by);
		WebDriverUtils.switchToFrame(driver, "BSCAT_MAIN");
		
		//set deadline : x Days from Enrollment
		by = By.id("DAYRAD");
		WebDriverUtils.checkRadio(driver, by);
		by = By.id("COMPLETEDAYS");
		WebDriverUtils.fillin_textbox(driver, by, this.getEnrollDeadline());
		
		//save change
		WebDriverUtils.switchToFrame(driver, "BSCAT_TOP");
		by = By.cssSelector("img[alt=\"Save\"]");
		WebDriverUtils.clickButton(driver, by);
		
		//leaner enroll in module
		User learner = new User(this.getParticipants(), Config.getInstance().getProperty("user.default.pass"));
		TestDriver.switchUser(learner);
		this.runSearchToEnroll(driver);
		
		//run daily schedule task
		for(TestObject setup: sysSetup){
			TSSystem setup_ins = (TSSystem) setup;
			User user = new User(setup_ins.getUID(), setup_ins.getPWD());
			TestDriver.switchUser(user);
			setup_ins.runScheduledTask(driver);
			Navigator.explicitWait(1000);
		}
		
		//learner check e-mail
		TestDriver.switchUser(learner);
		EmailUI.CheckInternalEmail(driver, this.getEmailTitle(), this.getEmailContent());
	}
	
	/**Empty method since it's a test suite
	 * 
	 * @param driver
	 */
	public void runCheckScorm12(WebDriver driver){
		
	}
	
	public void runAdHoc_Enroll(WebDriver driver){
		
	}
	/**Empty method since it's a test suite
	 * 
	 * @param driver
	 */
	public void runCheckScorm2004(WebDriver driver){
		
	}
	
	/**Empty method since it's a test suite
	 * 
	 * @param driver
	 */
	public void runCheckAICC(WebDriver driver){
		
	}
}
