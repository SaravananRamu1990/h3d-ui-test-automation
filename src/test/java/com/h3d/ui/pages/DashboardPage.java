package com.h3d.ui.pages;

import org.openqa.selenium.By;

public class DashboardPage {
    public static By userMenu = By.xpath("//span[text()='User']");
    public static By logout = By.xpath("//span[text()='Logout']");
    public static By simulationTxt= By.xpath("//span[text()='Simulation']");
    public static By simliveTogBtn = By.xpath("//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']");
    public static By live= By.xpath("//span[text()='Live']");
    public static By DBX=By.xpath("//span[text()='User']//following::li[text()='DBX']");
    public static By Drone=By.xpath("//span[text()='User']//following::li[text()='Drone']");
    public static By CLS=By.xpath("//span[text()='User']//following::li[text()='Critical Landing Site']");
    public static By MissionPlanner=By.xpath("//span[text()='User']//following::li[text()='Mission Planner']");
    public static By DeviceMapping=By.xpath("//span[text()='User']//following::li[text()='Device Mapping']");
    public static By NFZ =By.xpath("//span[text()='User']//following::li[text()='NFZ']");
    public static By Settings =By.xpath("//span[text()='User']//following::li[text()='Settings']");
    public static By WSConnection=By.xpath("*//img//following::i[@title='WS Connection']");
    public static By MQTTConnection=By.xpath("*//img//following::i[@title='MQTT Conn']");
    public static By MAVLinkConnection=By.xpath("*//img//following::i[@title='MAVLink Conn']");
    public static By DBXIcon=By.xpath("//i[@class='bi bi-box2-fill']");
    public static By DRONEIcon=By.xpath("//i[@class='bi bi-airplane-fill']");
    public static By ActionsText=By.xpath("//div[text()='Actions']");
    public static By ActionsTabCloseButton=By.xpath("//div[text()='Actions']//parent::div//i");
    public static By ActionsInfo=By.xpath("//div[@class='action-INFO']");
    //dbx image without dbx name
    public static By DBXImage=By.xpath("//div[@class='leaflet-pane leaflet-marker-pane']//img[7]");





}
