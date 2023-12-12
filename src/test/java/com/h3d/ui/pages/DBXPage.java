package com.h3d.ui.pages;

import org.openqa.selenium.By;

public class DBXPage {
   //Create DBX Station
   public static By DBXListTxt= By.xpath("//p[text()='DBX List']");
   public static By DBX=By.xpath("//span[text()='User']//following::span[text()='Device']//following::li[text()='Dbx']");
   public static By AddDBXButton= By.xpath("//p[text()= 'DBX List']//following::button[contains(text(), 'Add')]");
   public static By DbxSearchBox= By.xpath("//p[text()= 'DBX List']//following::input[@placeholder='Search Device...']");
   public static By DbxSearchBtn= By.xpath("//p[text()= 'DBX List']//following::input[@placeholder='Search Device...']//parent::div/button");
   public static By DBXTableHeaderList=By.xpath("//table[@class='MuiTable-root dbxTable css-1owb465']/thead/tr[1]/th");
   public static By DBXTableRows=By.xpath("//table[@class='MuiTable-root dbxTable css-1owb465']/tbody/tr");
   public static By DBXIndivHeader=By.xpath("//table[@class='MuiTable-root dbxTable css-1owb465']/thead/tr/th[text()='Device Id']");
   public static By createDBXStationTxt=By.xpath("//div[@class='col-sm block-title' and contains(text(), 'create dbx Station')]");
   public static By DBXDeviceIdTextBox=By.xpath("//label[text()='Device Id']/following-sibling::input[@id='dev_id']");
   public static By selectDBXDeviceTypeBtn=By.xpath("//div[text()='create dbx Station']//following::label[text()='Device Type']//parent::div/div");
   public static By SelectDeviceType= By.xpath("//div[text()='create dbx Station']//following::li");
   public static By DBXDeviceNameTxtBox=By.xpath("//div[text()='create dbx Station']//following::input[@id='name']");
   public static By DBXDeviceModelTextBox=By.xpath("//div[text()= 'create dbx Station']//following::input[@id='model']");
   public static By SelectStatusBtn=By.xpath("//label[text()='Status']//parent::div/div");
   public static By SelectStatusList=By.xpath("//label[text()='Status']//parent::div//following::div//li");
   public static By LocationDetails= By.xpath("//p[text()='Location Details:']");
   public static By createDBXStationSubmitButton=By.xpath("//p[text()='Location Details:']//following::button");
   public static By latitude =By.xpath("//p[text()='Location Details:']//following::table/tbody/tr/td[contains(text(), 'Latitude')]");
   public static By longitude=By.xpath("//p[text()='Location Details:']//following::table/tbody/tr/td[contains(text(), 'Longitude')]");
   public static By DoubleClickForLocDet=By.xpath("//div[text()='create dbx Station']//following::p[text()='Double click on the Map for device location']");
//View DBX Station
   public static By viewDBXStationTxt=By.xpath("//div[text()='view dbx Station']");
   public static By viewDBXID=By.xpath("//div[text()='view dbx Station']//following::input[@id='dev_id']");
   public static By viewDeviceTypeButton=By.xpath("//div[text()='view dbx Station']//following::label[text()='Device Type']//parent::div/div");
   public static By ViewDeviceModel=By.xpath("//div[text()='view dbx Station']//following::input[@id='model']");
   public static By viewStatusButton=By.xpath("//div[text()='view dbx Station']//following::div[text()='Active']");

   //Edit DBX Station
//   public static By
   public static By EditDeviceName= By.xpath("//div[text()='update dbx Station']//following::input[@id='name']");
   public static By EditDeviceID=By.xpath("//div[text()='update dbx Station']//following::input[@id='dev_id']");
   public static By EditDeviceModel=By.xpath("//div[text()='update dbx Station']//following::input[@id='model']");
   public static By EditStatusDropdown=By.xpath("//div[text()='update dbx Station']//following::div[text()='Active']");
   public static By ActiveStatusSelect=By.xpath("//div[text()='update dbx Station']//following::li[text()='Active']");
   public static By InactiveStatusSelect=By.xpath("//div[text()='update dbx Station']//following::li[text()='Inactive']");
   public static By LocationDetailsText=By.xpath("//div[text()='update dbx Station']//following::p[text()='Location Details:']");
   public static By DoubleClickOnMap=By.xpath("//div[text()='update dbx Station']//following::p[text()='Double click on the Map for device location']");
   public static By EditLatitude=By.xpath("//div[text()='update dbx Station']//following::table//td[text()='Latitude:']");
   public static By EditLongitude=By.xpath("//div[text()='update dbx Station']//following::table//td[text()='Longitude:']");
   public static By DynamicLatLongDetails=By.xpath("//div[text()='update dbx Station']//following::table//td[text()='VALUE'] ");
   public static By SubmitButton=By.xpath("//div[text()='update dbx Station']//following::button[text()='Submit'] ");

//Delete DBX Page:
   public static By ConfirmationDeletePopUp=By.xpath("//p[text()='DBX List']//following::p[text()='Are you sure you want to delete?']");
   public static By CancelDeleteButton=By.xpath("//p[text()='DBX List']//following::button[text()='Cancel']");
   public static By ConfirmDeleteOKButton=By.xpath("//p[text()='DBX List']//following::button[text()='OK']");
//Dynamic Xpath
//   public static By DeviceRecordsAction(String deviceList,String DeviceIdValue, String deviceAction  ){
//      return By.xpath("//p[text()='deviceList']//following::tr//th[text()='DeviceIdValue']//parent::tr//following::tr//td[text()='DeviceIdName']//following::button[@title='deviceAction'][1]");
//


   }



