package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //  Enter valid username
        sendTextToElement(By.name("username"), "hathi4");
        //  Enter valid password
        sendTextToElement(By.name("password"), "asdfghjkl4390");
        //  Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //  Verify the ‘Accounts Overview’ text is display
        verifyText("Accounts Overview", By.xpath("//h1[contains(text(),'Accounts Overview')]"));
    }

    @Test
    public void verifyTheErrorMessage(){
        //  Enter valid username
       sendTextToElement(By.name("username"), "bihari");
        //  Enter valid password
        sendTextToElement(By.name("password"), "123456");
        //  Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //  Verify the error message ‘The username and password could not be verified.’
        verifyText("The username and password could not be verified.", By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
    }

    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        //  Enter valid username
        Thread.sleep(1000);
        sendTextToElement(By.name("username"), "hathi4");
        //  Enter valid password
        sendTextToElement(By.name("password"), "asdfghjkl4390");
        //  Click on ‘LOGIN’ button
        Thread.sleep(200);
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //  Click on ‘Log Out’ link
        Thread.sleep(800);
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        // Verify the text ‘Customer Login
        verifyText(("Customer Login"), By.xpath("//h2[contains(text(),'Customer Login')]"));
    }

    @After
    public void testDown(){
        closeBrowser();
    }
}
