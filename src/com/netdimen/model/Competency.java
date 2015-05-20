package com.netdimen.model;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.netdimen.abstractclasses.TestObject;
import com.netdimen.utils.WebDriverUtils;
import com.netdimen.view.Navigator;

/**
 * 
 * @author martin.wang
 *
 */
public class Competency extends TestObject {
	private String	CompetencyModel = "",	Code="",	Title="",	Desc="",	isActive="",
			Proficiency="", Modules="";
	
	private ArrayList<LearningModule> moduleList = new ArrayList<LearningModule>();
	
	public void setCompetencyModel_UI(WebDriver driver, String str){
		if(!str.equals("")){
			By by = By.linkText(CompetencyModel);
			WebDriverUtils.clickLink(driver, by);
			/*by = By.id("newCompetencyBtn");
			WebDriverUtils.clickButton(driver, by);*/
		}
	}
	
	
	public void setCode_UI(WebDriver driver, String str){
		if(!str.equals("")){
			By by = By.id("competency-reference-code");
			WebDriverUtils.fillin_textbox(driver, by, str);
		}
	}
	
	public void setTitle_UI(WebDriver driver, String str){
		if(!str.equals("")){
			By by = By.id("competency-title");
			WebDriverUtils.fillin_textbox(driver, by, str);
		}
	}
	
	public String getModules() {
		return Modules;
	}

	public ArrayList<LearningModule> getModuleList() {
		return moduleList;
	}

	public void setModules(String modules) {
		Modules = modules;
	}

	public void setModuleList(ArrayList<LearningModule> moduleList) {
		this.moduleList = moduleList;
	}

	public void setDesc_UI(WebDriver driver, String str){
		if(!str.equals("")){
			By by = By.id("competency-description");
			WebDriverUtils.fillin_textbox(driver, by, str);
		}
	}
	
	public void setActive_UI(WebDriver driver, String str){
		if(str.equals("yes")){
			By by = By.id("active");
			WebDriverUtils.check_checkbox(driver, by);
		}
	}
	
	public void setProficiencyLevel_UI(WebDriver driver, String str){
		if(!str.equals("")){
			By by = By.id("levelGroup");
			WebDriverUtils.select_selector(driver, by, str);
		}
	}
	
/*	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringBuilder().append(this.getClass().getName()).
				append("_").
				append(this.getFuncType()).
				append("_").
				append(this.getCode()).
				toString();
	}*/

	@Override
	public boolean equals(TestObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkExpectedResult_UI(WebDriver driver, String expectedResult) {
		// TODO Auto-generated method stub
		super.checkExpectedResult_UI(driver, expectedResult);
	}

	public String getCompetencyModel() {
		return CompetencyModel;
	}

	public void setCompetencyModel(String competencyModel) {
		CompetencyModel = competencyModel;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getisActive() {
		return isActive;
	}

	public void setisActive(String isActive) {
		this.isActive = isActive;
	}

	public String getProficiency() {
		return Proficiency;
	}

	public void setProficiency(String proficiency) {
		Proficiency = proficiency;
	}
	
	public void runCreateCompetency(WebDriver driver){
		Navigator.navigate(driver,Navigator.webElmtMgr.getNavigationPathList("ManageCenter","2.Competency"),this);
		this.setCompetencyModel_UI(driver, this.getCompetencyModel());
		this.setCode_UI(driver, this.getCode());
		this.setTitle_UI(driver, this.getTitle());
		this.setDesc_UI(driver, this.getDesc());
		this.setActive_UI(driver, this.getisActive());
		this.setProficiencyLevel_UI(driver, this.getProficiency());

		By by =By.id("saveButton");
		WebDriverUtils.clickButton(driver, by);
	}
	
	/**Re-order learning modules of competency
	 * 
	 * @param driver
	 */
	public void runReorderModules(WebDriver driver){
		Navigator.navigate(driver,Navigator.webElmtMgr.getNavigationPathList("ManageCenter","2.Competency"),this);
		this.setCompetencyModel_UI(driver, this.getCompetencyModel());
		
		By by = By.linkText(this.getCode());
		WebDriverUtils.clickLink(driver, by);
		
		String[] modules = this.getModules().split(";");
		
		By targetBy = By.xpath("//table[@id='assignedCourses']/tbody"), srcBy = null;
		WebDriverUtils.maxWindow(driver);
		WebDriverUtils.scrollWindowToElement(driver, By.id("ajaxLMSearchBox")); //scroll window to tables
		int i = 0;
		
		for(; i < modules.length/2; i ++){
			String module = modules[i];
			//1. i-th row becomes the central row
			srcBy = By.xpath("//table[@id='assignedCourses']/tbody/tr[descendant::td[text()='"+module+"']]");
			WebDriverUtils.dragAndDrop(driver, srcBy, targetBy);
			
			//2. Swap the 1st row with i-th row 
			srcBy = By.xpath("//table[@id='assignedCourses']/tbody/tr[1]");
			WebDriverUtils.dragAndDrop(driver, srcBy, targetBy);
		}
		
		String module = modules[i];
		//3. i-th row becomes the central row
		srcBy = By.xpath("//table[@id='assignedCourses']/tbody/tr[descendant::td[text()='"+module+"']]");
		WebDriverUtils.dragAndDrop(driver, srcBy, targetBy);
		
		by = By.id("saveButton");
//		WebDriverUtils.clickButton(driver, by);
	}
}
