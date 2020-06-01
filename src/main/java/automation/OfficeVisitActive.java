package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OfficeVisitActive {
    public static void main(String[] args) {
        String username = "#########@zakipoint.com";
        String password = "##########";
        // String clientname = "Z5 Demo B";
        String clientname = "Asbury University";
        // String clientname = "Harlan Bakeries";

        //span[contains(text(),'Z5 Demo C')]

        String fullclientxpath = "//span[contains(text(),'" + clientname + "')]";
        System.out.println(fullclientxpath);


        // System Property for Chrome Driver
        //  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\java\\Intellij\\src\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        JavascriptExecutor js = (JavascriptExecutor) driver;
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

        driver.findElement(By.xpath("//span[@class='nav-link cd-filter-trigger']//img")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[contains(text(),'Member Status:')]//following-sibling::span[@class='zp-edit']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='termed01']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Apply Settings')]")).click();


        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Active Employees')]")));
        //   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img//following-sibling::span[contains(text(),'Quick')]")).click();

        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();


        //select ER from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Office Visit')]")).click();


        System.out.println("For Dashboard Section");

        //Annual Spend
        String OfficeVisitactiveAnnualSpend = driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
        System.out.format("OfficeVisitactive Annual Spend : %s\n", OfficeVisitactiveAnnualSpend);

        System.out.println("*----------------OfficeVisitactive Member Count---------------------------*");
        String OfficeVisitactiveMemberCount = driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
        System.out.format("OfficeVisitactive Member Count : %s \n", OfficeVisitactiveMemberCount);

        System.out.println("*----------------OfficeVisitactive Current Risk---------------------------*");
        String OfficeVisitactiveCurrentRisk = driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
        System.out.format("OfficeVisitactive Current Risk: %s\n", OfficeVisitactiveCurrentRisk);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //// driver.findElement(By.xpath("")).getText();
        //String HighfreqERUt= driver.findElement(By.xpath("//div[@id='z5eruhghtstbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')")).getText();
        // System.out.format("High Frequencr ER Utilization: %s",HighfreqERUt);


        //Click PMPM
        driver.findElement(By.xpath("//div[@class='spend-header']//a[@class='nav-link inactive'][contains(text(),'PMPM')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click in graph
        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@width,'590')]//*[name()='g' and contains(@class,'circle')]//*[name()='circle' and contains(@cx,'330')]")).click();
        //ER PMPM
        System.out.println("*----------------OfficeVisitactive PMPM---------------------------*");
        String OfficeVisitactivePMPM = driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        System.out.format("OfficeVisitactive PMPM : %s\n", OfficeVisitactivePMPM);

        String ReportingPeriod = driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
        System.out.format("Reporting Period  : %s\n", ReportingPeriod);

        // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
        //  System.out.println(AllConditionServiceSpend);


        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("All OfficeVisitactive Population : Age");
        // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
        //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
        //  js.executeScript("window.scrollBy(0,500)");


        System.out.println("All OfficeVisitactive Population : Age");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String OfficeVisitactiveSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Spend=%s\n", OfficeVisitactiveSpendAgeASpend);
        String OfficeVisitactiveSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member Count=%s\n", OfficeVisitactiveSpendAgeAmember);
        String OfficeVisitactiveSpendAgeAmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member PMPM=%s\n", OfficeVisitactiveSpendAgeAmemberPMPM);

        String OfficeVisitactiveSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Spend=%s\n", OfficeVisitactiveSpendAgeBSpend);
        String OfficeVisitactiveSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member Count=%s\n", OfficeVisitactiveSpendAgeBmember);
        String OfficeVisitactiveSpendAgeBmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member PMPM=%s\n", OfficeVisitactiveSpendAgeBmemberPMPM);

        String OfficeVisitactiveSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Spend=%s\n", OfficeVisitactiveSpendAgeCSpend);
        String OfficeVisitactiveSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member Count=%s\n", OfficeVisitactiveSpendAgeCmember);
        String OfficeVisitactiveSpendAgeCmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member PMPM=%s\n", OfficeVisitactiveSpendAgeCmemberPMPM);


        String OfficeVisitactiveSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Spend=%s\n", OfficeVisitactiveSpendAgeDSpend);
        String OfficeVisitactiveSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member Count=%s\n", OfficeVisitactiveSpendAgeDmember);
        String OfficeVisitactiveSpendAgeDmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member PMPM=%s\n", OfficeVisitactiveSpendAgeDmemberPMPM);


        String OfficeVisitactiveSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Spend=%s\n", OfficeVisitactiveSpendAgeESpend);
        String OfficeVisitactiveSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member Count=%s\n", OfficeVisitactiveSpendAgeEmember);
        String OfficeVisitactiveSpendAgeEmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member PMPM=%s\n", OfficeVisitactiveSpendAgeEmemberPMPM);


        System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
        String OfficeVisitactiveMaleSpend = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactiveMale Spend =%s\n", OfficeVisitactiveMaleSpend);
        String OfficeVisitactiveMaleMembers = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactiveMale Members Count=%s\n", OfficeVisitactiveMaleMembers);
        String OfficeVisitactiveMaleMembersPMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactiveMale Members Count=%s\n", OfficeVisitactiveMaleMembersPMPM);

        String OfficeVisitactiveFemaleSpend = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactiveFemale Spend=%s\n", OfficeVisitactiveFemaleSpend);
        String OfficeVisitactiveFemaleMembers = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactiveFemale Members Count=%s\n", OfficeVisitactiveFemaleMembers);
        String OfficeVisitactiveFemaleMembersPMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactiveFeMale Members Count=%s\n", OfficeVisitactiveFemaleMembersPMPM);

        String USpendOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Spend=%s\n", USpendOfficeVisitactive);
        String UmemberOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Member Count=%s\n", UmemberOfficeVisitactive);
        String OfficeVisitactiveUMembersPMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Members Count=%s\n", OfficeVisitactiveUMembersPMPM);


        System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
        System.out.println("*------------------------------Relationship---------------------------------------*");

        String RelationshipNameA = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameA);
        String OthersRelSpendOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA + " Relationship Spend=%s\n", OthersRelSpendOfficeVisitactive);
        String OthersRelmemberOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA + " Relationship Member Count=%s\n", OthersRelmemberOfficeVisitactive);
        String OthersRelmemberOfficeVisitactivePMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA + " Relationship Member Count=%s\n", OthersRelmemberOfficeVisitactivePMPM);


        String RelationshipNameB = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameB);
        String EmployeeRelSpendOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB + "Relationship Spend=%s\n", EmployeeRelSpendOfficeVisitactive);
        String EmployeeRelmemberOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB + "Relationship Member=%s\n", EmployeeRelmemberOfficeVisitactive);
        String EmployeeRelmemberOfficeVisitactivePMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB + " Relationship Member Count PMPM=%s\n", EmployeeRelmemberOfficeVisitactivePMPM);


        String RelationshipNameC = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameC);
        String SpouseRelSpendOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC + " Relationship Spend=%s\n", SpouseRelSpendOfficeVisitactive);
        String SpouseRelMemberCountOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC + " Relationship Member Count=%s\n", SpouseRelMemberCountOfficeVisitactive);
        String SpouseRelmemberOfficeVisitactivePMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC + " Relationship Member Count PMPM=%s\n", SpouseRelmemberOfficeVisitactivePMPM);

/*
        String RelationshipNameD = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameD);
        String DependentRelSpendOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD + " Relationship Spend=%s\n", DependentRelSpendOfficeVisitactive);
        String DependentRelmemberCountOfficeVisitactive = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD + " Relationship Member Count=%s\n", DependentRelmemberCountOfficeVisitactive);
        String DependentRelmemberOfficeVisitactivePMPM = driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD + " Relationship Member Count PMPM=%s\n", DependentRelmemberOfficeVisitactivePMPM);
*/
        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //    js.executeScript("window.scrollBy(0,400)");
        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // js.executeScript("window.scrollBy(0,300)");
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //*--------------------------------------UTILIZATION-----------------------------------
        // js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();
        js.executeScript("window.scrollBy(0,250)");
        //  driver.findElement(By.xpath("//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String ClaimsbyproTotalUtilizationperKOfficeVisitactive = driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        String wordc = "Total Utilization per 1000";
        String ClaimsbyproTotalUtilizationperKOfficeVisitActive = ClaimsbyproTotalUtilizationperKOfficeVisitactive.replace(wordc, "");
        System.out.format("Cliaims By PRocedure Total Utilization Per 1000 : %s", ClaimsbyproTotalUtilizationperKOfficeVisitActive);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='disease-box zph-tabs']//a[@class='nav-link inactive'][contains(text(),'Spend')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        js.executeScript("window.scrollBy(0,500)");
        String OfficeVisitactiveClaimsbyprocedure = driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
        //System.out.format("OfficeVisitactiveclaims By Procedure: %s",OfficeVisitactiveClaimsbyprocedure);
        String word = "Total Procedure Spend";
        String OfficeVisitActiveClaimsbyProcedure = OfficeVisitactiveClaimsbyprocedure.replace(word, "");
        System.out.format("OfficeVisitactive claims By Procedure: %s", OfficeVisitActiveClaimsbyProcedure);
        //ERClaimsbyprocedure = removeWord(ERClaimsbyprocedure,word);
        //js.executeScript("window.scrollBy(0,1100)");
        js.executeScript("window.scrollBy(0,800)");
/*
            System.out.println("Out of Network Provider");
            String TotalProviderSpendOfficeVisitactive=driver.findElement(By.xpath("//div[@id='z5erutbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Provider Spend')]")).getText();
            String wordr = "Total Provider Spend";
            String TotalProviderSpendOfficeVisitactive = TotalProviderSpendOfficeVisitactive.replace(wordr, "");
            System.out.format("Total Provider Spend OfficeVisitactive: %s",TotalProviderSpendOfficeVisitactive);


            System.out.println("Out of Network Procedures");
            String TotalProcedureSpendOfficeVisitactive=driver.findElement(By.xpath("//div[@id='z5erutbc005']//div[@class='bottom-placing']//div//p[contains(text(),'Total Spend')]")).getText();
            String wordp = "Total Spend";
            String TotalProcedureSpendOfficeVisitactive = TotalProcedureSpendOfficeVisitactive.replace(wordp, "");
            System.out.format("Total Procedure Spend OfficeVisitactive: %s",TotalProcedureSpendOfficeVisitactive);
            //String OfficeVisitactiveVoneTotalSpend=driver.findElement(By.xpath("")).getText();

 */

        System.out.println("*-------------Catastrophic Claims------------------*\n");
        System.out.println("Medical Catestrophic\n");
        String catestrophicmedOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicmedOfficeVisitactive);
        String MedCatestrophicUtilizationOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n", MedCatestrophicUtilizationOfficeVisitactive);

        String MedCatestrophicmemberOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medical-Catestrophic-member Count:%s\n", MedCatestrophicmemberOfficeVisitactive);

        String MedCatestrophicperchangeOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n", MedCatestrophicperchangeOfficeVisitactive);


        System.out.println("Pharmacy Catestrophic\n");
        String catestrophicphrOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicphrOfficeVisitactive);
        String PhrCatestrophicUtilizationOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactive-Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n", PhrCatestrophicUtilizationOfficeVisitactive);

        String PhrCatestrophicmemberOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactive-Pharmacy-Catestrophic-member Count:%s\n", PhrCatestrophicmemberOfficeVisitactive);

        String PhrCatestrophicperchangeOfficeVisitactive = driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-OfficeVisitactive-Catestrophic percentage change :%s\n", PhrCatestrophicperchangeOfficeVisitactive);




         /*   String OutofNetworkProvidersperKOfficeVisitactive= driver.findElement(By.xpath("//div[@id='z5erutbc002']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            String OutofNetworkProvidersperKOfficeVisitactive = OutofNetworkProvidersperKOfficeVisitactive.replace(wordc, "");
            System.out.format("Out of Network Providers Total Utilization Per 1000 : %s",OutofNetworkProvidersperKOfficeVisitactive);

            String OutofNetworkProcedureperKOfficeVisitactive= driver.findElement(By.xpath("//div[@id='z5erutbc006']//div[@class='bottom-placing']//div//p[contains(text(),'Total Member per 1000')]")).getText();
            String worde = "Total Member per 1000";
            String OutofNetworkProcedureperKOfficeVisitactive = OutofNetworkProcedureperKOfficeVisitactive.replace(worde, "");
            System.out.format("Out of Network Procedures Total Utilization Per 1000 : %s",OutofNetworkProcedureperKOfficeVisitactive);
*/
        System.out.println("*-------------------------Wellness-----------------------*");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();

        //select ER from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Office Visit')]")).click();
        //js.executeScript("window.scrollBy(0,-1000)");
        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Wellness')]")).click();


        // OfficeVisitactive Risk SCORE
        /* HIGH RISK */
        System.out.println("*--------------------OfficeVisitactiveRISK SCORE---------------------------*\n");
        System.out.println("*--------------------HIGH RISK---------------------------*\n");
        js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  System.out.println("Prospective Population Risk Stratification\n" );
        String HighOfficeVisitactiveriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("High OfficeVisitactive Risk Spend:%s\n", HighOfficeVisitactiveriskspend);

        String HighOfficeVisitactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("High OfficeVisitactive Risk Member:%s\n", HighOfficeVisitactiveRiskMember);

        String HighOfficeVisitactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High percentage change member: %s\n", HighOfficeVisitactivepcmember);

        /* Medium RISK */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("*--------------------OfficeVisitactive MEDIUM RISK---------------------------*\n");

        String MediumOfficeVisitactiveriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitactive Medium Risk Spend:%s\n", MediumOfficeVisitactiveriskspend);

        String MediumOfficeVisitactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium OfficeVisitactive Risk Member:%s\n", MediumOfficeVisitactiveRiskMember);

        String MediumOfficeVisitactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium OfficeVisitactive Percentage memeber: %s\n", MediumOfficeVisitactivepcmember);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String NormalOfficeVisitactiveRiskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal OfficeVisitactive Risk Spend:%s\n", NormalOfficeVisitactiveRiskspend);

        String NormalOfficeVisitactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal OfficeVisitactive Risk Member:%s\n", NormalOfficeVisitactiveRiskMember);

        String NormalOfficeVisitactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal OfficeVisitactive Percentage memeber: %s\n", NormalOfficeVisitactivepcmember);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String LowOfficeVisitactiveriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Spend:%s\n", LowOfficeVisitactiveriskspend);

        String LowOfficeVisitactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Low OfficeVisitactive Risk Member:%s\n", LowOfficeVisitactiveRiskMember);

        String LowOfficeVisitactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low OfficeVisitactive Percentage memeber: %s\n", LowOfficeVisitactivepcmember);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // For PMPM
        driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'PMPM')]")).click();
        // js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String HighOfficeVisitactiveRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High OfficeVisitactive Risk PMPM: %s\n", HighOfficeVisitactiveRiskPMPM);

        /* Medium RISK */

        String MediumOfficeVisitactiveRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium OfficeVisitactive Risk PMPM: %s\n", MediumOfficeVisitactiveRiskPMPM);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");


        String NormalOfficeVisitactiveRiskpmpm = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk PMPM: %s\n", NormalOfficeVisitactiveRiskpmpm);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String LowOfficeVisitactiveRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low OfficeVisitactive Risk PMPM: %s\n", LowOfficeVisitactiveRiskPMPM);

    }
}
