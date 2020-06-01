package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class dashboard {
    public static void main (String[] args) {


        String username = "#########@zakipoint.com";
        String password = "##########";
       // String clientname = "Z5 Demo B";
        String clientname = "Asbury University";
        //span[contains(text(),'Z5 Demo C')]

        String fullclientxpath = "//span[contains(text(),'" + clientname + "')]";
        System.out.println(fullclientxpath);


        // System Property for Chrome Driver
      //  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\java\\Intellij\\src\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //All membercount
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String allmember=driver.findElement(By.xpath("//h5[contains(text(),'All Members')]//following-sibling::span")).getText();
       //String allmember=driver.findElement(By.xpath("//h5[contains(text(),'All Members')]//following-sibling::span")).getText();
        System.out.format("All Member Count: %s\n",allmember);
        System.out.println("\n");
       //String Allmemcount=allmember.getText();
        //int Allmembercount = Integer.parseInt(allmember);
        //System.out.format("All Member Count: %d",Allmembercount);



        //Get Medical Spend Amount
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // String medamount=driver.findElement(By.cssSelector("//div[@id='pills-paid']//span[@class='text-capitalize'][contains(text(),'Medical')]/following-sibling::p")).getText();
        String medamount=driver.findElement(By.xpath("//div[@id='pills-paid']//span[@class='text-capitalize'][contains(text(),'Medical')]//following-sibling::p")).getText();
        System.out.format("Medical Amount: %s\n",medamount);
        System.out.println("\n");

        //Get Pharmacy Spend Amount
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String pharmacyamount=driver.findElement(By.xpath("//div[@id='pills-paid']//span[@class='text-capitalize'][contains(text(),'Pharmacy')]//following-sibling::p")).getText();
        System.out.format("Pharmacy Amount: %s\n",pharmacyamount);
        System.out.println("\n");


        // ALL EMPLOYEE cannot go to amount
        String allemployee= driver.findElement(By.xpath("//h5[contains(text(),'All Employees')]")).getText();
        System.out.format("All Employee Count: %s\n",allemployee);
        System.out.println("\n");

        //Total Spend
        String totalspend=driver.findElement(By.xpath("//h5[contains(text(),'Total Spend')]//following-sibling::span")).getText();
        //String allmember=driver.findElement(By.xpath("//h5[contains(text(),'All Members')]//following-sibling::span")).getText();
        System.out.format("Total Spend: %s\n",totalspend);
        System.out.println("\n");

        // Prospective Risk
        /* HIGH RISK */
        System.out.println("*--------------------HIGH RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Prospective Population Risk Stratification\n" );
        String Highriskspend=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk Spend:%s\n",Highriskspend);

        String HighRiskMember=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk Member:%s\n",HighRiskMember);

        String HighRiskPMPM=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk PMPM: %s\n",HighRiskPMPM);

        /* Medium RISK */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("*--------------------MEDIUM RISK---------------------------*\n");
        //System.out.println("Prospective Population Risk Stratification\n" );
        String Mediumriskspend=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk Spend:%s\n",Mediumriskspend);

        String MediumRiskMember=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk Member:%s\n",MediumRiskMember);

        String MediumRiskPMPM=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk PMPM: %s\n",MediumRiskPMPM);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        String Normalriskspend=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk Spend:%s\n",Normalriskspend);

        String NormalRiskMember=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk Member:%s\n",NormalRiskMember);

        String NormalRiskPMPM=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk PMPM: %s\n",NormalRiskPMPM);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        String Lowriskspend=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Spend:%s\n",Lowriskspend);

        String LowRiskMember=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Member:%s\n",LowRiskMember);

        String LowRiskPMPM=driver.findElement(By.xpath("//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk PMPM: %s\n",LowRiskPMPM);

        // For PMPM
        driver.findElement(By.xpath("//a[contains(text(),'Pmpm')]")).click();
        String MedicalPMPM=driver.findElement(By.xpath("//div[@id='pills-pmpm']//span[@class='text-capitalize'][contains(text(),'Medical')]//following-sibling::p")).getText();
        System.out.format("MedicalPMPM:%s\n",MedicalPMPM);


        String PharmacyPMPM=driver.findElement(By.xpath("//div[@id='pills-pmpm']//span[@class='text-capitalize'][contains(text(),'Pharmacy')]//following-sibling::p")).getText();
        System.out.format("Pharmacy PMPM: %s\n",PharmacyPMPM);


    }
}
