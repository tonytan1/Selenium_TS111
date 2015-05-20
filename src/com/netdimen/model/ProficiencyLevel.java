package com.netdimen.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.netdimen.utils.WebDriverUtils;
import com.netdimen.view.Navigator;

/**
 * 
 * @author martin.wang
 *
 */
public class ProficiencyLevel extends com.netdimen.abstractclasses.TestObject {
	private String LevelCode = "", LevelTitle = "", Description = "";

	public boolean equals(com.netdimen.abstractclasses.TestObject para0) {
		boolean result = false;
		return result;
	}

	public ProficiencyLevel() {
		super();
	}

	public String getLevelCode() {
		return LevelCode;
	}

	public String getLevelTitle() {
		return LevelTitle;
	}

	public String getDescription() {
		return Description;
	}

	public void setLevelCode(String levelcode) {
		LevelCode = levelcode;
	}

	public void setLevelTitle(String leveltitle) {
		LevelTitle = leveltitle;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setLevelCode_UI(WebDriver driver, String str) {
		if (!str.equals("")) {
			By by = By.xpath("//tr[@class='row1 newRow pendingSave']/td/input[@name='code']");
			WebDriverUtils.fillin_textbox(driver, by, str);
		}
	}

	public void setLevelTitle_UI(WebDriver driver, String str) {
		if (!str.equals("")) {
			By by = By.xpath("//tr[@class='row1 newRow pendingSave']/td/input[@name='title']");
			WebDriverUtils.fillin_textbox(driver, by, str);
		}
	}

	public void setDescription_UI(WebDriver driver, String str) {
		if (!str.equals("")) {
			By by = By.xpath("//tr[@class='row1 newRow pendingSave']/td/textarea[@name='desc']");
			WebDriverUtils.fillin_textbox(driver, by, str);
		}
	}

	public void create(WebDriver driver){
		this.setLevelCode_UI(driver, this.getLevelCode());
		this.setLevelTitle_UI(driver, this.getLevelTitle());
		this.setDescription_UI(driver, this.getDescription());
		By by = By.id("saveAllButton");
		WebDriverUtils.clickButton(driver, by);
		Navigator.explicitWait(1000);
	}
	
	public void runCreate(WebDriver driver) {
		Navigator.navigate(driver, Navigator.webElmtMgr.getNavigationPathList(
				"ManageCenter", "2.Proficiency"));
		this.create(driver);
	}
}