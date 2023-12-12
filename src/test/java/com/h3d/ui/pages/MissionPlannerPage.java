package com.h3d.ui.pages;

import org.openqa.selenium.By;

public class MissionPlannerPage {
    public static By MissionPlanListTxt= By.xpath("//p[text()='Plan List']");
    public static By ShowPaths=By.xpath("//p[text()='Plan List']//parent::div//following::button[text()='Show Paths']");
    public static By HidePaths=By.xpath("//p[text()='Plan List']//parent::div//following::button[text()='Hide Paths']");
    public static By AddMissionPlan=By.xpath("//p[text()='Plan List']//parent::div//following::button[text()='Add']");
    public static By PlanNameTextBox=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//input[@id='planDropdown']");
    public static By PlanShapeDropDownButton=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//select[@id='planDropdown']");
    public static By SelectPolylinePlan=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//select//option[text()='Polyline']");
    public static By selectPolygonPlan=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//select//option[text()='Polygon']");
    public static By PlanStatusDropDownButton=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//select[@class='selectStatusOption']");
    public static By selectPlanStatusDropdown=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//select[@class='selectStatusOption']//option");
    public static By RepeatCountTextBox=By.xpath("//p[text()='Plan List']//parent::div//following::div/div[text()='Add New Plan']//parent::div//following::div//input[@id='count']");









}
