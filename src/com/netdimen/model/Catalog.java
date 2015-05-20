package com.netdimen.model;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.netdimen.config.Labels;
import com.netdimen.junit.JUnitAssert;
import com.netdimen.utils.Validate;
import com.netdimen.utils.WebDriverUtils;
import com.netdimen.view.FunctionUI;
import com.netdimen.view.Navigator;
import com.netdimen.view.PermissionUI;

/**
 * 
 * @author martin.wang
 *
 */
public class Catalog extends com.netdimen.abstractclasses.TestObject {
	private String CatalogPath = "", Permission = "", ReadPerm ="", WritePerm="";
	
	

	public String getReadPerm() {
		return ReadPerm;
	}

	public void setReadPerm(String readPerm) {
		ReadPerm = readPerm;
	}

	public String getWritePerm() {
		return WritePerm;
	}

	public void setWritePerm(String writePerm) {
		WritePerm = writePerm;
	}

	public boolean equals(com.netdimen.abstractclasses.TestObject para0) {
		boolean result = false;
		return result;
	}

	public Catalog() {
		super();
	}

	public String getCatalogPath() {
		return CatalogPath;
	}


	public String getPermission() {
		return Permission;
	}

	public void setPermission(String permission) {
		Permission = permission;
	}

	public void setCatalogPath(String catalogpath) {
		CatalogPath = catalogpath;
	}

	public void setCatalogPath_UI(WebDriver driver, String str) {
		if (!str.equals("")) {
		}
	}
	
	public void runEditProperty(WebDriver driver){
		Navigator.navigate(driver, Navigator.webElmtMgr.getNavigationPathList(
				"ManageCenter", "2.Catalog"));
		
		FunctionUI.expandTree_UI(driver, this.getCatalogPath());
		By by = By.xpath("//div[@id='catalog-structure-gear']/button[@is-drop-down-button='true']");
		Navigator.explicitWait(1000);
//		Navigator.waitForAjaxElementLoad(driver, by);
		WebDriverUtils.mouseOver(driver, by);
		
		by = By.xpath("//div[contains(@id,'catalog-structure-gear')]/ul/li/a[contains(text(),'"+Labels.Edit_Catalog_Properties+"')]");
		Navigator.explicitWait(1000);
//		Navigator.waitForAjaxElementLoad(driver, by);
		WebDriverUtils.clickButton(driver, by);

		WebDriverUtils.switchToPopUpWin(driver);
		Navigator.explicitWait(1000);
		
		if (!Validate.isBlank(this.getReadPerm())){
			by = By.name("permissionButton");			
			WebDriverUtils.clickButton(driver, by);
			
			WebDriverUtils.switchToPopUpWin(driver);
			Navigator.explicitWait(1000);
			PermissionUI.setPermission_UI(driver, false, this.getReadPerm());
			WebDriverUtils.switchToParentWin(driver);
		}
		
		if (!Validate.isBlank(this.getWritePerm())){
			by = By.name("permissionButton");			
			WebDriverUtils.clickButton(driver, by);
			
			WebDriverUtils.switchToPopUpWin(driver);
			Navigator.explicitWait(1000);
			PermissionUI.setPermission_UI(driver, true, this.getWritePerm());
			WebDriverUtils.switchToParentWin(driver);
		}
		//UIFunctionUtils.setPermission_UI(driver, this.getPermission());
		
		WebDriverUtils.closeAllPopUpWins(driver);
	}

	public void runCheckVisibility(WebDriver driver) {
		Navigator.navigate(driver, Navigator.webElmtMgr.getNavigationPathList(
				"LearningCenter", "2.Search"));
		
		//Click Search button to show catalogs 
		By by = By.xpath("//div[@id='ajaxInlineSearchBox']/button[@name='SEARCH']");
		WebDriverUtils.clickButton(driver, by);
		
		
		String[] catalogs = this.getCatalogPath().split("\n");//visible:NETD/NETD ACC DEPT;A2
		for(String catalog_tmp: catalogs){
			String[] catalogs1 = catalog_tmp.split(":");
			String criteria = catalogs1[0]; //visible or invisible;
			
			String catalogPaths = catalogs1[1]; //NETD/NETD ACC DEPT;A2
			
			String[] catalogPathArray = catalogPaths.split(";");
			for(String catalogPath: catalogPathArray){
				
				String[] catalogSeq = catalogPath.split("/");
				String catalog = catalogSeq[catalogSeq.length-1];//last catalog as search keyword
				by  = By.id("ajaxTreeSearchBox_input");
				WebDriverUtils.fillin_textbox(driver, by, catalog);
				
				by = By.xpath("//div[@id='ajaxTreeSearchBox_ctr']/div[@class='content']/div[@val='"+catalog+"']");//auto-suggest results
				
				int size = driver.findElements(by).size();
				
				if(criteria.equalsIgnoreCase("visible")){
					Navigator.waitForAjax(driver, by);
					JUnitAssert.assertTrue(size>0, "Catalog path is invisible:" + catalogPath);
				}else if(criteria.equalsIgnoreCase("invisible")){
					JUnitAssert.assertTrue(size==0, "Catalog path is visible:" + catalogPath);
				}
			}
		}
	}

/*	public String toString(){
		return new StringBuilder().
				append(this.getClass().getName()).
				append("_").
				append(this.getFuncType()).
				append("_").
				append(this.getCatalogPath()).
				append("_").
				append(this.getPermission()).
				toString();
	}*/
}