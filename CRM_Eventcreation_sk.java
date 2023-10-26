package pageObjects;


public class CRM_Eventcreation_sk {
		

//	event creation
	public static final String event_subject_crm="//label[(.='Subject')]//following::input[@class='slds-combobox__input slds-input']";
	public static final String event_desc_crm="//textarea[@role='textbox']";
	public static final String event_type_none_crm="//a[contains(.,'None')][@role='button']";
	public static final String event_type_meeting_crm="//span[contains(.,'Type')]//following::a[.='Meeting']";
	public static final String event_type_fieldtrainingdemo_crm="//span[contains(.,'Type')]//following::a[.='Field Training DEMO']";
	public static final String event_type_fieldtrainingsupport_crm="//span[contains(.,'Type')]//following::a[.='Field Training Support']";
	public static final String event_type_agencymeeting_crm="//span[contains(.,'Type')]//following::a[.='Agency Meeting']";
	public static final String event_type_Unitmeeting_crm="//span[contains(.,'Type')]//following::a[.='Unit Meeting']";
	public static final String event_type_obs_training_crm="//span[contains(.,'Type')]//following::a[text()='Field Training OBS']";
	public static final String eventtype_errormsg_crm="//li[contains(.,'Please Select  another Event type.')]";
	
//	public static final String event_starttime_crm="//span[.='Timings']//following::input[2]";
//	public static final String event_startdate_crm="//span[.='Timings']//following::input[1]";
	
	public static final String event_startdate_crm="//legend[.='Start']//following::input[@class='slds-input']";
//	public static final String event_starttime_crm="(//input[@class='slds-combobox__input slds-input slds-combobox__input-value'])[1]";
	public static final String event_starttimeicon_crm="(//input[@class='slds-combobox__input slds-input'])[2]";
//	public static final String event_starttime_crm="(//span[contains(.,'";
	public static final String event_starttime_crm="//legend[contains(.,'Start')]//following::input[@role='combobox']";
//	public static final String event_starttime_crm="//label[(.='Subject')]//following::input[3]";
//	public static final String event_starttimeicon_crm="//lightning-icon[@class='slds-input__icon slds-input__icon_right slds-icon-utility-clock slds-icon_container']";
	public static final String event_endtime_crm="//legend[.='End']//following::span[.='Select a date for Date']";
	public static final String event_savebtn_crm="//span[.='Save']";
//	public static final String event_calendarview_previousbtn_crm="//*[local-name()='svg' and @data-key='chevronleft']/*[local-name()='g'//*[local-name()='svg' and @data-key='chevronleft']/*[local-name()='g']";
	
	public static final String calenderview_crm="//a[@class='subject-link']";

}
