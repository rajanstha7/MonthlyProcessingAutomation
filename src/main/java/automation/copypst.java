package automation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class copypst {

    public static void main(String[] args) {
        //String driver;


        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //*--------------------------------------Wellness-----------------------------------
        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Wellness')]")).click();


        // ER  Risk SCORE
        /* HIGH RISK */
        System.out.println("*--------------------ER RISK SCORE---------------------------*\n");
        System.out.println("*--------------------HIGH RISK---------------------------*\n");
        js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  System.out.println("Prospective Population Risk Stratification\n" );
        String HighERriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk Spend:%s\n", HighERriskspend);

        String HighERRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk Member:%s\n", HighERRiskMember);

        String Highpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High percentage change member: %s\n", Highpcmember);

        /* Medium RISK */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("*--------------------MEDIUM RISK---------------------------*\n");
        //System.out.println("Prospective Population Risk Stratification\n" );
        String MediumERriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk Spend:%s\n", MediumERriskspend);

        String MediumERRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk Member:%s\n", MediumERRiskMember);

        String Mediumpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Percenage memeber: %s\n", Mediumpcmember);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        String NormalERRiskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk Spend:%s\n", NormalERRiskspend);

        String NormalERRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk Member:%s\n", NormalERRiskMember);

        String Normalpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Percentage memeber: %s\n", Normalpcmember);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        String LowERriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Spend:%s\n", LowERriskspend);

        String LowERRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Member:%s\n", LowERRiskMember);

        String Lowpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Percenage memeber: %s\n", Lowpcmember);


        // For PMPM
        driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        // js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  System.out.println("Prospective Population Risk Stratification\n" );
        // String HighERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //System.out.format("High Risk Spend:%s\n",HighERriskspendpmpm);

        //String HighERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        //System.out.format("High Risk Member:%s\n",HighERRiskMemberpmpm);

        String HighERRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk PMPM: %s\n", HighERRiskPMPM);

        /* Medium RISK */

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // System.out.println("*--------------------MEDIUM RISK---------------------------*\n");
        //System.out.println("Prospective Population Risk Stratification\n" );
        // String MediumERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //   System.out.format("Medium Risk Spend:%s\n",MediumERriskspendpmpm);

        // String MediumERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        // System.out.format("Medium Risk Member:%s\n",MediumERRiskMemberpmpm);

        String MediumERRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk PMPM: %s\n", MediumERRiskPMPM);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        //  String NormalERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //   System.out.format("Normal Risk Spend:%s\n",NormalERriskspendpmpm);

        //   String NormalERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        //   System.out.format("Normal Risk Member:%s\n",NormalERRiskMemberpmpm);

        String NormalERRiskpmpm = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk PMPM: %s\n", NormalERRiskpmpm);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        //  String LowERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //  System.out.format("Low Risk Spend:%s\n",LowERriskspendpmpm);

        //   String LowERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        //  System.out.format("Low Risk Member:%s\n",LowERRiskMemberpmpm);

        String LowERRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk PMPM: %s\n", LowERRiskPMPM);

    }

@Test
    public void driver() {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   return driver;
    }
    public void dashboard(){
        copypst driver = new copypst();
        driver();

       // String HighERRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
      //  System.out.format("High Risk PMPM: %s\n", HighERRiskPMPM);

    }

}
