package com.netdimen.config;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author lester.li
 * This is use to centralized for all labels in properties files
 */
public class Labels {
	//Naming pattern
	//Link_xx for all link
	//Btn_xxx for all btn
	//Msg_xxx for msg show in page
	//Heading_xxx for heading checking
	//Tab_xxx for tab menu item 
	//Alert_xxx for javascript alert messagebox
	//Desc_xxx for desc feild in page
	//Gear_xxx for gear btn
	//Text_xxx for only text presented in page
	
	//general
	public static final String Btn_OK = Config.getInstance().getProperty("button.ok");
	public static final String Btn_Search =Config.getInstance().getProperty("button.Search");
	public static final String Btn_Submit =Config.getInstance().getProperty("button.Submit");
	public static final String Btn_Cancel = Config.getInstance().getProperty("button.Cancel");
	public static final String Btn_Deny = Config.getInstance().getProperty("button.deny");
	public static final String Btn_Edit = Config.getInstance().getProperty("button.Edit");
	public static final String Btn_Save = Config.getInstance().getProperty("button.Save");
	
	//Email
	public static final String Text_From = StringEscapeUtils.unescapeJava(Config.getInstance().getProperty("label.from"));
	
	
	//Appraisal
	public static final String Exceeded_Expected_Performance = Config.getInstance().getProperty("label.Exceeded_Expected_Performance");
	public static final String Perf_Goal_Plan = Config.getInstance().getProperty("appraisal.sectionType.performance_goal_plan");
	public static final String Dev_Goal_Plan = Config.getInstance().getProperty("appraisal.sectionType.development_goal_plan");
	public static final String Promt_Potential_Report = Config.getInstance().getProperty("heading.plot_9box_promotion_potential_report");
	public static final String Retent_Risk_Report = Config.getInstance().getProperty("heading.plot_9box_retention_risk_report");
	public static final String Appraisal_Saved_Msg = Config.getInstance().getProperty("appraisal.msg.dataSavedComplete");
	public static final String Other_Achievements = Config.getInstance().getProperty("label.Other_Significant_Achievements");
	public static final String Create_Goal = Config.getInstance().getProperty("label.goal_create");
	public static final String Proceed_Comp_Assessment = Config.getInstance().getProperty("button.proceed_to_comp_assessment");
	public static final String Success_Msg=Config.getInstance().getProperty("label.numberUserComplete");
	public static final String Failed_Msg=Config.getInstance().getProperty("label.numberUserFail");
	
	//CDC
	public static final String Btn_SessionTransfer=Config.getInstance().getProperty("button.enrolled.courses.session.transfer");
	
	//User selector
	public static final String Entry_Form=Config.getInstance().getProperty("label.UserIdDirectForm");
	
	//Link:Organization
	public static final String Link_Org=Config.getInstance().getProperty("desc.Organization");
	
	//Third party account
	public final static String TempEmailWebSite =Config.getInstance().getProperty("TempEmailWebSite");
	public final static String AdobeConnect=Config.getInstance().getProperty("label.vc_adobe_connect");
	public final static String Webex=Config.getInstance().getProperty("label.vc_webex");
	public final static String GoToTraining=Config.getInstance().getProperty("label.vc_gtt");
	public final static String HorizonWimba=Config.getInstance().getProperty("label.vc_horizon_wimba");
	
	//Catalog Editor
	public final static String Mark_Approved=Config.getInstance().getProperty("button.catalog.revisions.mark_as_approved");
	public static final String Edit_Catalog_Properties = Config.getInstance().getProperty("button.edit_properties");
	public static final String Tab_Edit_Session_Schedule =Config.getInstance().getProperty("tab.Edit_Session_Schedule");
	public static final String Link_GEnroll_Select =Config.getInstance().getProperty("label.GEnroll_Desc3");
	public static final String Msg_GEnroll_Success =Config.getInstance().getProperty("label.registered");
	public static final String Link_Sess_Properties =Config.getInstance().getProperty("label.SessionProperties");
	public static final String Msg_Confirm_Add_Schedule =Config.getInstance().getProperty("desc.confirm_add_schedule");
	public static final String Ques_Group_Sure =Config.getInstance().getProperty("msg.Are_you_sure_group");
	public static final String Link_Edit_Policy =Config.getInstance().getProperty("text.EditPolicy");
	public static final String Link_Edit_Withdraw =Config.getInstance().getProperty("text.EditWithdraw");
	public static final String Msg_Confirm_Delete =Config.getInstance().getProperty("msg.confirm_delete");
	public static final String Msg_Group_Assign =Config.getInstance().getProperty("msg.Are_you_sure_group");
	public static final String Link_Assign_Catalog =Config.getInstance().getProperty("label.EditLO_Desc19");
	public static final String Link_Assign_Test =Config.getInstance().getProperty("label.Assign_Test/Cert/Eval");
	public static final String Link_Launch_Properties =Config.getInstance().getProperty("label.Define_Launch_Properties");
	public static final String Link_Group_Enroll =Config.getInstance().getProperty("tab.Group_Enroll");
	public static final String Link_Define_Enroll_Policy =Config.getInstance().getProperty("label.Define_Enrollment_Policy");
	public static final String Link_Setup_Options = Config.getInstance().getProperty("label.Setup_Options");
	public static final String Link_Auto_Enroll = Config.getInstance().getProperty("tab.Auto_Enroll");
	public static final String Link_Define_Module_Security = Config.getInstance().getProperty("label.Define_Module_Security");
	public static final String Link_Participants = Config.getInstance().getProperty("heading.participants");
	public static final String Link_Update_Deadline = Config.getInstance().getProperty("label.action.update_deadline");
	public static final String Link_Transfer_Session = Config.getInstance().getProperty("label.action.transfer_session");
	public static final String Link_Substitute_participant = Config.getInstance().getProperty("button.Execute_Substitution");
	public static final String Btn_Substitute = Config.getInstance().getProperty("button.Substitute");
	public static final String Link_Select_Participants = Config.getInstance().getProperty("label.Select_Participants");
	public static final String Btn_Delete_Course = Config.getInstance().getProperty("label.delete_course");
	public static final String Btn_Test_AutoEnroll = Config.getInstance().getProperty("button.Test_AutoEnroll_Targets");
	public static final String Btn_Set_AutoEnroll = Config.getInstance().getProperty("button.Set_AutoEnroll_Targets");
	public static final String Text_Cancelled = Config.getInstance().getProperty("label.Cancelled");
	public static final String Link_Edit_Session_Schedule = Config.getInstance().getProperty("tab.Edit_Session_Schedule");
	public static final String Link_Email_Preference_Setup = Config.getInstance().getProperty("label.Email_Preference_Setup");
	public static final String Heading_Gentle_Deadline_Reminder = Config.getInstance().getProperty("label.Gentle_Deadline_Reminder");
	
	//Learning Module Status
	public static final String Text_Not_Started= Config.getInstance().getProperty("label.Not_Started");//Not Started
	public static final String Text_In_Process= Config.getInstance().getProperty("label.status_2");//In Process
	public static final String Text_Completed= Config.getInstance().getProperty("label.status_3");//Completed
	public static final String Text_Waitlisted= Config.getInstance().getProperty("label.status_4");//Waitlisted
	public static final String Text_Withdrawn= Config.getInstance().getProperty("label.status_5");//Withdrawn
	public static final String Text_Pending_Approval= Config.getInstance().getProperty("label.status_6");//Pending Approval
	public static final String Text_Self_Asserted= Config.getInstance().getProperty("label.overallstatus.completed_self_asserted");//Completed (Self-Asserted)
	public static final String Text_Deactivated= Config.getInstance().getProperty("label.overallstatus.deactivated");//Deactivated
	
	//KC
	public static final String Link_KC= Config.getInstance().getProperty("label.Learning_Space");
	public static final String ActiveModuleHeading = Config.getInstance().getProperty("heading.Active_and_Completed_Modules");
	public static final String AvailableModuleHeading = Config.getInstance().getProperty("heading.Available_Modules");
	public static final String RequiredModuleHeading = Config.getInstance().getProperty("label.required.modules");
	public static final String ElectiveModuleHeading = Config.getInstance().getProperty("label.elective.modules");
	public static final String Btn_Mark_Completed= Config.getInstance().getProperty("button.Completed_Self_Asserted");
	public static final String Btn_Go_To_CLM= Config.getInstance().getProperty("button.Go_To_Current_Learning_Modules");
	public static final String Link_Assessment_Workflow= Config.getInstance().getProperty("label.assessment_workflow");
	
	//My Learning
	public static final String Btn_show_subModules = Config.getInstance().getProperty("label.transcript.learningprogram.show.submodules");
	public static final String Btn_Filter = Config.getInstance().getProperty("label.filter");

	
	//Goal
	public static final String Tab_Personal_Goal = Config.getInstance().getProperty("tab.personal_goal.name");
	public static final String Tab_Dev_Goal = Config.getInstance().getProperty("tab.development_goal.name");
	public static final String Label_Personal_Goal = Config.getInstance().getProperty("label.personal_goal");
	public static final String Label_Dev_Goal = Config.getInstance().getProperty("label.development_goal");
	public static final String Msg_Delete_Dev_Goal =Config.getInstance().getProperty("delete.edit.development_goal.confirm_message");
	public static final String Msg_Delete_Perf_Goal =Config.getInstance().getProperty("delete.edit.personal_goal.confirm_message");
	public static final String Link_My_Perf_Goal =Config.getInstance().getProperty("menu.my.performance.goals");
	public static final String Link_My_Dev_Goal =Config.getInstance().getProperty("menu.my.development.goals");
	public static final String Btn_Perf_Goal =Config.getInstance().getProperty("button.personal_goal.new");
	public static final String Btn_Dev_Goal =Config.getInstance().getProperty("button.development_goal.new");
	public static final String Btn_Dev_New =Config.getInstance().getProperty("button.development_goal.new");
	
	//TEACH
	public static final String Msg_Update_Scuess =Config.getInstance().getProperty("msg.updateSuccessfully");
	
	//JobProfile
	public static final String Msg_JobProfile_Assigned =Config.getInstance().getProperty("msg_jobprofile_autoassing_now_in_effect");
	
	//Msg:Are you sure you want to change the auto-enrollment targeting criteria?
	public static final String Msg_Auto_Sure =Config.getInstance().getProperty("msg.are_you_sure_auto");
	
	//Org. Attribute link
	public static final String Link_Org_Attrs =Config.getInstance().getProperty("heading.org.attrs");
	
	//EQ
	public static final String Btn_Create_Rule = Config.getInstance().getProperty("button.equivalency.create.rule");
	public static final String Btn_Create = Config.getInstance().getProperty("button.Create");
	public static final String Gear_EQ_Btn = Config.getInstance().getProperty("label.equivalency.manager");
	public static final String Add_Module_Link = Config.getInstance().getProperty("link.Add_Module(s)...");
	public static final String Gear_Audience_Btn = Config.getInstance().getProperty("button.equivalency_rule.target_audience");
	
	//Exam
	public static final String Btn_CloseTest = Config.getInstance().getProperty("button.closetest");
	
	//External Training Rec
	public static final String Label_PendingApproval =Config.getInstance().getProperty("label.pendingApproval");
	public static final String Msg_PendingApprWarn =Config.getInstance().getProperty("msg.pendingApprWarn");
	public static final String Msg_ExtCreateSuccess =Config.getInstance().getProperty("msg.externalCreateSuccessful");
	public static final String Msg_ExtUpdateSuccess =Config.getInstance().getProperty("msg.externalUpdateSuccessful");
	
	//Forum
	public static final String Msg_Create_Forum =Config.getInstance().getProperty("desc.Create_New_Forum");
	public static final String Btn_Post_Topic =Config.getInstance().getProperty("button.Post_New_Topic");
	
	//Home Template
	public static final String Btn_Create_HomeTempl =Config.getInstance().getProperty("list_homepages.button.newTemplate.label");
	
	//Target Audience
	public static final String Tab_Target_Audience =Config.getInstance().getProperty("tab.Target_Audience");
	
	//Enrolled Learning module
	public static final String Msg_Tasks_Completed =Config.getInstance().getProperty("heading.Tasks_Completed");
	public static final String Msg_Module_NoAvailable =Config.getInstance().getProperty("desc.No_longer_available");
	public static final String Msg_Session_Finished =Config.getInstance().getProperty("msg.session_finished");
	
	//User class
	public static final String Btn_test_attempt_Confirm =Config.getInstance().getProperty("label.test_attempt.confirm_end_exam");

	//User_Group
	public static final String Btn_Create_User_Group = Config.getInstance().getProperty("button.CreateNewUserGroup");
	
	//Role Access Control
	public static final String Btn_List_Permission = Config.getInstance().getProperty("button.List_Permissions");
	public static final String Btn_Update_Acess_Control_Setting = Config.getInstance().getProperty("button.Update_Access_Control_Settings");

}
