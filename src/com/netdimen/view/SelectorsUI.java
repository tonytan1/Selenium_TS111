package com.netdimen.view;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.netdimen.config.Config;
import com.netdimen.utils.WebDriverUtils;

public class SelectorsUI {

	private SelectorsUI() {
		// Suppress default constructor for non-instantiability
		throw new AssertionError();
	}

	/*
	 * Pop up page or Pop up dialog Selector
	 * OrgSelector_Multi : for multi-option checkbox
	 * OrgSelector_Single : for single radiobtn
	 * UserIDValidtor: It is a pop up page form (User ID Direct Entry Form) from user selector
	 */
	public enum PopUpSelector {
		UserSelector, TreeSelector_Chkbox, TreeSelector_Radio, InnerUserSelector,TopDownSelector,LeftRightSelector, UserIDValidator, PermissionSelector
	}
	
	/**
	 * This is a pop up selector method that can deal with UserSelector, OrgSelector_Multi, 
	 * OrgSelector_Single, CatalogSelector, InnerUserSelector,TopDownSelector, UserIDValidator with one searching keywords
	 * @param driver
	 * @param selector
	 * @param keyword
	 */
	public static void PopUp_Selector(WebDriver driver, PopUpSelector selector,  String keyword){
		 ArrayList<String> keywords = new ArrayList<String>();
		 keywords.add(keyword);
		 PopUp_Selector( driver, selector,  keywords);
	}
	/**
	 * This is a pop up selector method that can deal with UserSelector, TreeSelector_Chkbox, 
	 * TreeSelector_Radio , InnerUserSelector,TopDownSelector, UserIDValidator with multi searching keywords
	 * @param driver
	 * @param selector
	 * @param keywords
	 */
	public static void PopUp_Selector(WebDriver driver, PopUpSelector selector,  ArrayList<String> keywords){	

		switch (selector){
			case UserSelector:
				//LearningModule>setParticipant_UI
				general_Selector(driver, selector.toString(), keywords);
				break;
			case UserIDValidator:
				//EnrollmentWizard->setEnrollmentWizardCriteria to see how to use it.
				UserIDValidator(driver, selector.toString(), keywords);
				break;
			case TreeSelector_Chkbox: // Org/Catalog: Permission Selector> Organization  or Catalog Editor> Assign Catalog
				tree_chkbox_Selector(driver, keywords);
				break;
			case TreeSelector_Radio:  // Org/Catalog: Report R015> Organization Parameter 
				String keyword = keywords.get(0);
				tree_radio_Selector(driver, keyword);
				break;
			case InnerUserSelector://CDC->Assessment->Peer Reviewer selector
				general_Selector(driver, selector.toString(), keywords);
				break;
			case TopDownSelector://CDC->Development Goal-> module selector
				general_Selector(driver, selector.toString(), keywords);
				break;
			case LeftRightSelector:
				general_Selector(driver, selector.toString(), keywords);
			case PermissionSelector:
				//(driver, keywords.get(0));
				break;
			default:
				System.out.println("warning: selector not support yet in WebDriverUtils:"
			+"PopUp_Selector(WebDriver driver, WebElementWrapper web)");	
		}
	}
	

	/**Apply to search multiple users, modules, competencies, job profiles
	 * 
	 * @param driver
	 * @param web
	 * @param keywords
	 */
	private static void general_Selector(WebDriver driver, String sheetname, ArrayList<String> keywords){
		if(keywords.size() > 0){
			By by = null;
			WebElementWrapper searchElm = null;
			
			for (String keyword : keywords) {
				searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.SearchText");
				by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
				WebDriverUtils.fillin_textbox(driver, by, keyword);
				
				searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.SearchButton");
				by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
				WebDriverUtils.clickButton(driver, by);
				
				by = By.id("avlParmSelector");
				int index = 0;
				WebDriverUtils.select_selector(driver, by, index);
				
				searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.AddSingle");
				by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
				WebDriverUtils.clickButton(driver, by);
			}
					
			searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.SaveBtn");
			by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
			WebDriverUtils.clickButton(driver, by);
		}
	}
	/**Pop up user id search in userselector page to search users with user ids validate and selected 
	 * 
	 * @param driver
	 * @param web
	 * @param keywords
	 */
	private static void UserIDValidator(WebDriver driver, String sheetname, ArrayList<String> keywords){
		if(keywords.size() > 0){
			By by = null;
			WebElementWrapper searchElm = null;
			
			for (String keyword : keywords) {
				searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.DataEntryList");
				by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
				WebDriverUtils.fillin_textbox(driver, by, keyword);
				
				searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.ValidatorBtn");
				by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
				WebDriverUtils.clickButton(driver, by);
			}
			searchElm = WebElementManager.getInstance().getWebElementWrapper(sheetname, "1.SaveBtn");
			by = searchElm.constructBy(searchElm.getElementType(), searchElm.getElementValue(),false);
			WebDriverUtils.clickButton(driver, by);
		}
	}
	
	/**Apply to select multiple (check box)  catalog or organization.
	 * 
	 * @param driver
	 * @param keywords
	 */
	public static void tree_chkbox_Selector(WebDriver driver, ArrayList<String> keywords){
		By by = By.linkText(Config.getInstance().getProperty("link.ExpandTree"));
		WebDriverUtils.clickLink(driver, by);
		
		for(String keyword: keywords){
			tree_chkbox_Selector_single(driver, keyword);
		}
		
		by = By.name("save");
		WebDriverUtils.clickButton(driver, by);		
	}

	
	/**
	 * Enable check box in tree-form selector e.g. Catalog or Organization Selector
	 * @param driver
	 * @param keyword
	 */
	private static void tree_chkbox_Selector_single(WebDriver driver, String keyword){
		By by = null;
		
		if (!keyword.equals("")) {
			String xpath = "";
			
			
			if (!keyword.contains("/")) {
				/*xpath = "//tr[descendant::td[contains(text(),'" + keyword
						+ "')]]/td/input[@type='CHECKBOX'][1]";*/
				
				xpath = "//tr[descendant::td[text()='" + keyword.trim()
						+ "']]/td/input[@type='CHECKBOX'][1]";
				
				by = By.xpath(xpath);
				WebDriverUtils.check_checkbox(driver, by);
			} else {
				 String[] keywords = keyword.split("/");
				 String str = keywords[keywords.length-1];
				 tree_chkbox_Selector_single(driver, str);				 
			}
		}	
	}
	
	/**Apply to select multiple (radio)  catalog or organization.
	 * 
	 * @param driver
	 * @param keyword
	 */
	public static void tree_radio_Selector(WebDriver driver, String keyword) {
		By by = By.linkText(Config.getInstance().getProperty("link.ExpandTree"));
		WebDriverUtils.clickLink(driver, by);
		
		tree_radio_Selector_single(driver, keyword);		
		by = By.name("save");
		WebDriverUtils.clickButton(driver, by);		
	}
	
	/**
	 * Enable radio box in tree-form selector e.g. Catalog or Organization Selector
	 * @param driver
	 * @param keyword
	 */
	
	private static void tree_radio_Selector_single(WebDriver driver, String keyword){
		By by = null;
		
		if (!keyword.equals("")) {
			String xpath = "";
			
			
			if (!keyword.contains("/")) {
				/*xpath = "//tr[descendant::td[contains(text(),'" + keyword
						+ "')]]/td/input[@type='CHECKBOX'][1]";*/
				
				xpath = "//tr[descendant::td[text()='" + keyword
						+ "']]/td/input[@type='RADIO'][1]";
				
				by = By.xpath(xpath);
				WebDriverUtils.check_checkbox(driver, by);
			} else {
				 String[] keywords = keyword.split("/");
				 String str = keywords[keywords.length-1];
				 tree_radio_Selector_single(driver, str);				 
			}
		}	
	}
}

