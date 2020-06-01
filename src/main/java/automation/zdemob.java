package automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class zdemob {

    public static void main (String[] args) {


        String username = "#########@zakipoint.com";
        String password = "##########";
        String clientname = "Z5 Demo B";
        //span[contains(text(),'Z5 Demo C')]

        String fullclientxpath = "//span[contains(text(),'" + clientname + "')]";
        System.out.println(fullclientxpath);
        //String fullXpath = String.format(USER_XPATH, newUser);
        //driver.findElement(By.xpath(fullclientxpath)).click();

        //      // System Property for Chromw Driver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
//        ChromeDriver driver=new ChromeDriver();
        //  ChromeDriver driver = new ChromeDriver();

        // Initialize Chrome Driver using Desired Capabilities Class
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability("marionette", true);
        //ChromeDriver driver = new ChromeDriver(capabilities);
        // Launch Website
        driver.navigate().to("https://ssouat.zakipointhealth.com/login/auth#!");
        //maximize window
        driver.manage().window().maximize();

        //Enters username
        driver.findElementByCssSelector("input#username").sendKeys(username);
        //Enters password
        driver.findElementByCssSelector("input[id='password']").sendKeys(password);
        //Get Login
        driver.findElementByXPath("//button[@class='btn btn-primary login-btn']").click();
        //Set client
        driver.findElementByCssSelector("button[class='btn dropdown-toggle btn-light']").click();
        //Select desiredclient
        driver.findElement(By.xpath(fullclientxpath)).click();
        //Click to go
        driver.findElementByXPath("//span[contains(text(),'Go')]").click();
        //Get Medical Spend Amount
         driver.findElements(By.cssSelector("//div[@id='pills-paid']//span[@class='text-capitalize'][contains(text(),'Medical')]/following-sibling::p"));
        //for (WebElement webElement : elements) {
         //   System.out.println(webElement.getText());
        //}

        WebElement allemployee=driver.findElementByCssSelector("//h5[contains(text(),'All Employees')]");
        String AllEmployeeCount=allemployee.getText();
        System.out.println(AllEmployeeCount);


        // System.out.println(medicalSpend.getText());
        //System.out.println("working CSS");
        /* if(medicalSpend.isDisplayed())
        {
            String medicaltotalspend=medicalSpend.getText();
            System.out.println("Medical Spend found");
            System.out.println(medicaltotalspend);
        }
        //System.out.println(medicaltotalspend);
        //System.out.format("Medical Total Spend: %s",medicaltotalspend);
        //System.out.println("Medical Spend: %s",medicalSpend.toString());
    }
    */


    }
}
