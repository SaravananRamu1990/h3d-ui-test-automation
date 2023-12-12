package com.h3d.ui.pages;

import org.openqa.selenium.By;

//LoginPage
    public class LoginPage {
        public  By email= By.xpath("//input[@id='formEmail']");
        public  By password= By.xpath("//input[@id='formPassword']");
        public  By submitButton= By.xpath("//label[text()='Password']//following::button[text()='Submit']");
        public  By h3d_image= By.xpath("//input[@id='formEmail']//preceding::div//img");
    }



