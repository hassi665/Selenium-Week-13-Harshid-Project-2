package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay(){

        // click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        // Verify the text ‘Signing up is easy!’
        verifyText("Signing up is easy!", By.xpath("//h1[contains(text(),'Signing up is easy!')]"));


    }

    @Test
    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {

        //  click on the ‘Register’ link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //  Enter First name
        sendTextToElement(By.id("customer.firstName"), "kumbh");
        //  Enter Last name
        sendTextToElement(By.id("customer.lastName"), "karan");
        //  Enter Address
        sendTextToElement(By.id("customer.address.street"), "devlock");
        Thread.sleep(500);
        //  Enter City
        sendTextToElement(By.id("customer.address.city"), "swarg");
        //  Enter State
        sendTextToElement(By.id("customer.address.state"), "bramhalock");
        //  Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "678954");
        Thread.sleep(300);
        //  Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "912345678901");
        //  Enter SSN
        sendTextToElement(By.id("customer.ssn"), "1984567231");
        //  Enter Username
        sendTextToElement(By.id("customer.username"), "hathi4");
        Thread.sleep(500);
        //  Enter Password
        sendTextToElement(By.id("customer.password"), "asdfghjkl4390");
        Thread.sleep(200);
        //  Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "asdfghjkl4390");
        //  Click on REGISTER button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='Register']"));
        //  Verify the text 'Your account was created successfully. You are now logged in'.
        verifyText("Your account was created successfully. You are now logged in.", By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
    }



    @After
    public void testDown(){
        closeBrowser();
    }

}
