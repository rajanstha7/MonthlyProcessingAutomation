package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OutpatientActive {
    public static void main(String[] args) {
        String username = "#########@zakipoint.com";
        String password = "##########";
        // String clientname = "Z5 Demo B";
        String clientname = "Asbury University";
        // String clientname = "Harlan Bakeries";

        //span[contains(text(),'Z5 Demo C')]

        String fullclientxpath = "//span[contains(text(),'" + clientname + "')]";
        System.out.println(fullclientxpath);
        // D:\java\Intellij\src\\chromedriver.exe

        // System Property for Chrome Driver
        //   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
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


        //select Outpatient from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Outpatient')]")).click();


        System.out.println("For Dashboard Section");

        //Annual Spend
        String outpatientactiveAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
        System.out.format("outpatientactive Annual Spend : %s\n",outpatientactiveAnnualSpend);

        System.out.println("*----------------outpatientactive Member Count---------------------------*");
        String outpatientactiveMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
        System.out.format("outpatientactive Member Count : %s \n",outpatientactiveMemberCount);

        System.out.println("*----------------outpatientactive Current Risk---------------------------*");
        String outpatientactiveCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
        System.out.format("outpatientactive Current Risk: %s\n",outpatientactiveCurrentRisk);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //// driver.findElement(By.xpath("")).getText();
        //String HighfreqERUt= driver.findElement(By.xpath("//div[@id='z5eruhghtstbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')")).getText();
        // System.out.format("High Frequencr ER Utilization: %s",HighfreqERUt);





        //Click PMPM
        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click in graph
        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@width,'590')]//*[name()='g' and contains(@class,'circle')]//*[name()='circle' and contains(@cx,'330')]")).click();
        //ER PMPM
        System.out.println("*----------------outpatientactive PMPM---------------------------*");
        String outpatientactivePMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        System.out.format("outpatientactive PMPM : %s\n",outpatientactivePMPM);

        String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
        System.out.format("Reporting Period  : %s\n",ReportingPeriod);

        // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
        //  System.out.println(AllConditionServiceSpend);


        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("All outpatientactive Population : Age");
        // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
        //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
        //  js.executeScript("window.scrollBy(0,500)");



        System.out.println("All outpatientactive Population : Age");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String outpatientactiveSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Spend=%s\n", outpatientactiveSpendAgeASpend);
        String outpatientactiveSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member Count=%s\n", outpatientactiveSpendAgeAmember);
        String outpatientactiveSpendAgeAmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member PMPM=%s\n", outpatientactiveSpendAgeAmemberPMPM);

        String outpatientactiveSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Spend=%s\n", outpatientactiveSpendAgeBSpend);
        String outpatientactiveSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member Count=%s\n", outpatientactiveSpendAgeBmember);
        String outpatientactiveSpendAgeBmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member PMPM=%s\n", outpatientactiveSpendAgeBmemberPMPM);

        String outpatientactiveSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Spend=%s\n", outpatientactiveSpendAgeCSpend);
        String outpatientactiveSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member Count=%s\n", outpatientactiveSpendAgeCmember);
        String outpatientactiveSpendAgeCmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member PMPM=%s\n", outpatientactiveSpendAgeCmemberPMPM);


        String outpatientactiveSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Spend=%s\n", outpatientactiveSpendAgeDSpend);
        String outpatientactiveSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member Count=%s\n", outpatientactiveSpendAgeDmember);
        String outpatientactiveSpendAgeDmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member PMPM=%s\n", outpatientactiveSpendAgeDmemberPMPM);


        String outpatientactiveSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Spend=%s\n", outpatientactiveSpendAgeESpend);
        String outpatientactiveSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member Count=%s\n", outpatientactiveSpendAgeEmember);
        String outpatientactiveSpendAgeEmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member PMPM=%s\n", outpatientactiveSpendAgeEmemberPMPM);



        System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
        String outpatientactiveMaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactiveMale Spend =%s\n",outpatientactiveMaleSpend);
        String outpatientactiveMaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactiveMale Members Count=%s\n",outpatientactiveMaleMembers);
        String outpatientactiveMaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactiveMale Members Count=%s\n",outpatientactiveMaleMembersPMPM);

        String outpatientactiveFemaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactiveFemale Spend=%s\n",outpatientactiveFemaleSpend);
        String outpatientactiveFemaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactiveFemale Members Count=%s\n",outpatientactiveFemaleMembers);
        String outpatientactiveFemaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactiveFeMale Members Count=%s\n",outpatientactiveFemaleMembersPMPM);

        String USpendoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Spend=%s\n",USpendoutpatientactive);
        String Umemberoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Member Count=%s\n",Umemberoutpatientactive);
        String outpatientactiveUMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Members Count=%s\n",outpatientactiveUMembersPMPM);




        System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
        System.out.println("*------------------------------Relationship---------------------------------------*");

        String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameA);
        String OthersRelSpendoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Spend=%s\n",OthersRelSpendoutpatientactive);
        String OthersRelmemberoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberoutpatientactive);
        String OthersRelmemberoutpatientactivePMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberoutpatientactivePMPM);



        String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameB);
        String EmployeeRelSpendoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EmployeeRelSpendoutpatientactive);
        String EmployeeRelmemberoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Member=%s\n",EmployeeRelmemberoutpatientactive);
        String EmployeeRelmemberoutpatientactivePMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+" Relationship Member Count PMPM=%s\n",EmployeeRelmemberoutpatientactivePMPM);


        String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameC);
        String SpouseRelSpendoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Spend=%s\n",SpouseRelSpendoutpatientactive);
        String SpouseRelMemberCountoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",SpouseRelMemberCountoutpatientactive);
        String SpouseRelmemberoutpatientactivePMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count PMPM=%s\n",SpouseRelmemberoutpatientactivePMPM);

/*
        String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameD);
        String DependentRelSpendoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Spend=%s\n",DependentRelSpendoutpatientactive);
        String DependentRelmemberCountoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",DependentRelmemberCountoutpatientactive);
        String DependentRelmemberoutpatientactivePMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count PMPM=%s\n",DependentRelmemberoutpatientactivePMPM);
*/
        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



        //    js.executeScript("window.scrollBy(0,400)");
        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // js.executeScript("window.scrollBy(0,300)");
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //*--------------------------------------UTILIZATION-----------------------------------






        // js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//span[contains(text(),'Quick Links')]")).click();
        // driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();


        //select Inpatient from quick links
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][contains(text(),'Outpatient')]")).click();
        WebDriverWait waittillo = new WebDriverWait(driver, 25);
        waittillo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")));

        //js.executeScript("window.scrollBy(0,-1000)");
        //    js.executeScript("window.scrollBy(0,200)");
        js.executeScript("window.scrollBy(0,250)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

      /*
        js.executeScript("window.scrollBy(0,250)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='disease-item er-box']//a[@class='nav-link inactive'][contains(text(),'Spend')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

*/
        js.executeScript("window.scrollBy(0,500)");
        String outpatientactiveClaimsbyprocedure=driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
        //System.out.format("ER claims By Procedure: %s",ERClaimsbyprocedure);
        String word = "Total Procedure Spend";
        String outpatientactiveClaimsbyProcedure = outpatientactiveClaimsbyprocedure.replace(word, "");
        System.out.format("outpatientactive claims By Procedure: %s",outpatientactiveClaimsbyProcedure);
        //ERClaimsbyprocedure = removeWord(ERClaimsbyprocedure,word);
        js.executeScript("window.scrollBy(0,1100)");

        System.out.println("Out of Network Provider");
        String TotalProviderSpendoutpatientactive=driver.findElement(By.xpath("//div[@id='z5erutbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Provider Spend')]")).getText();
        String wordr = "Total Provider Spend";
        String TotalProviderSpendOutpatientactive = TotalProviderSpendoutpatientactive.replace(wordr, "");
        System.out.format("Total Provider Spend outpatientactive: %s",TotalProviderSpendOutpatientactive);


        System.out.println("Out of Network Procedures");
        String TotalProcedureSpendoutpatientactive=driver.findElement(By.xpath("//div[@id='z5erutbc005']//div[@class='bottom-placing']//div//p[contains(text(),'Total Spend')]")).getText();
        String wordp = "Total Spend";
        String TotalProcedureSpendOutpatientactive = TotalProcedureSpendoutpatientactive.replace(wordp, "");
        System.out.format("Total Procedure Spend outpatientactive: %s",TotalProcedureSpendOutpatientactive);
        //String outpatientactiveVoneTotalSpend=driver.findElement(By.xpath("")).getText();

        System.out.println("*-------------Catastrophic Claims------------------*\n");
        System.out.println("Medical Catestrophic\n");
        String catestrophicmedoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicmedoutpatientactive);
        String MedCatestrophicUtilizationoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationoutpatientactive);

        String MedCatestrophicmemberoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberoutpatientactive);

        String MedCatestrophicperchangeoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeoutpatientactive);


        System.out.println("Pharmacy Catestrophic\n");
        String catestrophicphroutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicphroutpatientactive);
        String PhrCatestrophicUtilizationoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactive-Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationoutpatientactive);

        String PhrCatestrophicmemberoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactive-Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmemberoutpatientactive);

        String PhrCatestrophicperchangeoutpatientactive=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-outpatientactive-Catestrophic percentage change :%s\n",PhrCatestrophicperchangeoutpatientactive);

        driver.findElement(By.xpath("//div[@id='Utilization']//div[4]//div[1]//ul[1]//li[2]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String ClaimsbyproTotalUtilizationperKoutpatientactive= driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        String wordc = "Total Utilization per 1000";
        String ClaimsbyproTotalUtilizationperKOutpatientactive = ClaimsbyproTotalUtilizationperKoutpatientactive.replace(wordc, "");
        System.out.format("Cliaims By PRocedure Total Utilization Per 1000 : %s",ClaimsbyproTotalUtilizationperKOutpatientactive);

        String OutofNetworkProvidersperKoutpatientactive= driver.findElement(By.xpath("//div[@id='z5erutbc002']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        String OutofNetworkProvidersperKOutpatientactive = OutofNetworkProvidersperKoutpatientactive.replace(wordc, "");
        System.out.format("Out of Network Providers Total Utilization Per 1000 : %s",OutofNetworkProvidersperKOutpatientactive);

        String OutofNetworkProcedureperKoutpatientactive= driver.findElement(By.xpath("//div[@id='z5erutbc006']//div[@class='bottom-placing']//div//p[contains(text(),'Total Member per 1000')]")).getText();
        String worde = "Total Member per 1000";
        String OutofNetworkProcedureperKOutpatientactive = OutofNetworkProcedureperKoutpatientactive.replace(worde, "");
        System.out.format("Out of Network Procedures Total Utilization Per 1000 : %s",OutofNetworkProcedureperKOutpatientactive);

        System.out.println("*-------------------------Wellness-----------------------*");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();

        //select ER from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Outpatient')]")).click();
        //js.executeScript("window.scrollBy(0,-1000)");
        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Wellness')]")).click();


        // outpatientactive Risk SCORE
        /* HIGH RISK */
        System.out.println("*--------------------outpatientactiveRISK SCORE---------------------------*\n");
        System.out.println("*--------------------HIGH RISK---------------------------*\n");
        js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  System.out.println("Prospective Population Risk Stratification\n" );
        String Highoutpatientactiveriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("High outpatientactive Risk Spend:%s\n", Highoutpatientactiveriskspend);

        String HighoutpatientactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("High outpatientactive Risk Member:%s\n", HighoutpatientactiveRiskMember);

        String Highoutpatientactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High percentage change member: %s\n", Highoutpatientactivepcmember);

        /* Medium RISK */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("*--------------------outpatientactive MEDIUM RISK---------------------------*\n");

        String Mediumoutpatientactiveriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("outpatientactive Medium Risk Spend:%s\n", Mediumoutpatientactiveriskspend);

        String MediumoutpatientactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium outpatientactive Risk Member:%s\n", MediumoutpatientactiveRiskMember);

        String Mediumoutpatientactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium outpatientactive Percentage memeber: %s\n", Mediumoutpatientactivepcmember);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String NormaloutpatientactiveRiskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal outpatientactive Risk Spend:%s\n", NormaloutpatientactiveRiskspend);

        String NormaloutpatientactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal outpatientactive Risk Member:%s\n", NormaloutpatientactiveRiskMember);

        String Normaloutpatientactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal outpatientactive Percentage memeber: %s\n", Normaloutpatientactivepcmember);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String Lowoutpatientactiveriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Spend:%s\n", Lowoutpatientactiveriskspend);

        String LowoutpatientactiveRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Low outpatientactive Risk Member:%s\n", LowoutpatientactiveRiskMember);

        String Lowoutpatientactivepcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low outpatientactive Percentage memeber: %s\n", Lowoutpatientactivepcmember);


        // For PMPM
        driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        // js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String HighoutpatientactiveRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High outpatientactive Risk PMPM: %s\n", HighoutpatientactiveRiskPMPM);

        /* Medium RISK */

        String MediumoutpatientactiveRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium outpatientactive Risk PMPM: %s\n", MediumoutpatientactiveRiskPMPM);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");


        String NormaloutpatientactiveRiskpmpm = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk PMPM: %s\n", NormaloutpatientactiveRiskpmpm);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String LowoutpatientactiveRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low outpatientactive Risk PMPM: %s\n", LowoutpatientactiveRiskPMPM);


    }
}
