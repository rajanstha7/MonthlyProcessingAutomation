package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ER {
    public static void main(String[] args) {
        String username = "***************@zakipoint.com";// type your username
        String password = "*****************";// type your password
        // String clientname = "Z5 Demo B";
        String clientname = "Asbury University";
        // String clientname = "Harlan Bakeries";

        //span[contains(text(),'Z5 Demo C')]

        String fullclientxpath = "//span[contains(text(),'" + clientname + "')]";
        System.out.println(fullclientxpath);


        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

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

//        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img//following-sibling::span[contains(text(),'Quick')]")).click();

        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();


        //select ER from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'ER')]")).click();
/*
        System.out.println("For Dashboard Section");

        //Annual Spend
        String ERAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
        System.out.format("ER Annual Spend : %s\n",ERAnnualSpend);

        System.out.println("*----------------ER Member Count---------------------------*");
        String ERMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
        System.out.format("ER Member Count : %s \n",ERMemberCount);

        System.out.println("*----------------ER Current Risk---------------------------*");
        String ERCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
        System.out.format("ER Current Risk: %s\n",ERCurrentRisk);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //// driver.findElement(By.xpath("")).getText();
       //String HighfreqERUt= driver.findElement(By.xpath("//div[@id='z5eruhghtstbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')")).getText();
       // System.out.format("High Frequencr ER Utilization: %s",HighfreqERUt);



        //Click PMPM
        // driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click in graph
        //driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@width,'590')]//*[name()='g' and contains(@class,'circle')]//*[name()='circle' and contains(@cx,'330')]")).click();
        //ER PMPM
        System.out.println("*----------------ER PMPM---------------------------*");
        //  String ERPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        //System.out.format("ER PMPM : %s\n",ERPMPM);

        String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
        System.out.format("Reporting Period  : %s\n",ReportingPeriod);

       // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
      //  System.out.println(AllConditionServiceSpend);


        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("All Pharmacy Population : Age");
       // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
        //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
        js.executeScript("window.scrollBy(0,500)");



        System.out.println("All ER Population : Age");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String ERSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Spend=%s\n", ERSpendAgeASpend);

        String ERSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member Count=%s\n", ERSpendAgeAmember);

        String ERSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Spend=%s\n", ERSpendAgeBSpend);

        String ERSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member Count=%s\n", ERSpendAgeBmember);

        String ERSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Spend=%s\n", ERSpendAgeCSpend);

        String ERSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member Count=%s\n", ERSpendAgeCmember);


        String ERSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Spend=%s\n", ERSpendAgeDSpend);
        String ERSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member Count=%s\n", ERSpendAgeDmember);

        String ERSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Spend=%s\n", ERSpendAgeESpend);
        String ERSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member Count=%s\n", ERSpendAgeEmember);




        System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
        String ERMaleSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("ERMale Spend Pharmacy=%s\n",ERMaleSpendPharmacy);
        String ERMaleMembersPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("ERMale Members Count=%s\n",ERMaleMembersPharmacy);

        String ERFemaleSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("ERFemale Spend=%s\n",ERFemaleSpendPharmacy);
        String ERFemaleMembersPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("ERFemale Members Count=%s\n",ERFemaleMembersPharmacy);

        String USpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Spend=%s\n",USpendPharmacy);
        String UmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Member Count=%s\n",UmemberPharmacy);




        System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
        System.out.println("*------------------------------Relationship---------------------------------------*");

        String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameB);
        String EREmployeeRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EREmployeeRelSpendPharmacy);
        String EREmployeeRelmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Member=%s\n",EREmployeeRelmemberPharmacy);

        String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();


        System.out.println(RelationshipNameC);
        String ERSpouseRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Spend=%s\n",ERSpouseRelSpendPharmacy);
        String ERSpouseRelMemberCountPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",ERSpouseRelMemberCountPharmacy);


        String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameD);
        String ERDependentRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Spend=%s\n",ERDependentRelSpendPharmacy);
        String ERDependentRelmemberCountPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",ERDependentRelmemberCountPharmacy);

        String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameA);
        String EROthersRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Spend=%s\n",EROthersRelSpendPharmacy);
        String EROthersRelmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",EROthersRelmemberPharmacy);

*/


        //*--------------------------------------UTILIZATION-----------------------------------
        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();
     /*
       String ERClaimsbyprocedure=driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
        //System.out.format("ER claims By Procedure: %s",ERClaimsbyprocedure);
        String word = "Total Procedure Spend";
        String ERClaimsbyProcedure = ERClaimsbyprocedure.replace(word, "");
        System.out.format("ER claims By Procedure: %s",ERClaimsbyProcedure);
        //ERClaimsbyprocedure = removeWord(ERClaimsbyprocedure,word);

        String TotalAvoidableERUse=driver.findElement(By.xpath("//div[@id='z5erutbc035']//div[@class='bottom-placing']//div//p[contains(text(),'Total Avoidable ER Spend')]")).getText();
        System.out.format("Total Avoidable ER Use: %s",TotalAvoidableERUse);
        String ERVoneTotalSpend=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
        System.out.format("Er Visit 1 or more total spend:%s",ERVoneTotalSpend);
        String ERVoneTotalmember=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
        String word1="Total Members";
        String  ERVoneTotalMember = ERVoneTotalmember.replace(word1,"");
        System.out.format("ER Visit one or more Total Member=%s",ERVoneTotalMember);
        //driver.findElement(By.xpath("")).getText();
        //driver.findElement(By.xpath("")).getText();

        System.out.println("*-------------Catastrophic Claims------------------*\n");
        System.out.println("Medical Catestrophic\n");
        String catestrophicmedER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicmedER);
        String MedCatestrophicUtilizationER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationER);

        String MedCatestrophicmemberER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberER);

        String MedCatestrophicperchangeER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeER);


        System.out.println("Pharmacy Catestrophic\n");
        String catestrophicphrER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicphrER);
        String PhrCatestrophicUtilizationER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationER);

        String PhrCatestrophicmemberER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmemberER);

        String PhrCatestrophicperchangeER=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",PhrCatestrophicperchangeER);


*/
        /*
        js.executeScript("window.scrollBy(0,600)");
        System.out.println("*-------------ER USe and Urgent Care------------------*\n");
        System.out.println("Services:          Spend      Members\n");
        String NoPC=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();

        //driver.findElement(By.xpath("")).getText();
        System.out.println(NoPC);
        String NoPCSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();

        System.out.format("No Preventive Care Spend :%s\n",NoPCSpend);

        String NoPCMembers=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("No preventive Care Member Count:%s\n",NoPCMembers);

        System.out.println("Services:          Spend      Members\n");
        String UCER=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();

        //driver.findElement(By.xpath("")).getText();
        System.out.println(UCER);
        String UCERSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();

        System.out.format("Urgent Care Spend :%s\n",UCERSpend);

        String UCERMembers=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Urgent Care Member Count:%s\n",UCERMembers);

        System.out.println("Services:      Spend      Members\n");
        String ERWChronic=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();

        System.out.println(ERWChronic);
        String ERChronicSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();

        System.out.format("ER with Chronic Condition Spend :%s\n",ERChronicSpend);

        String ERChronicMemebers=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("ER with Chronic Condition Member Count:%s\n",ERChronicMemebers);
        */
        System.out.println("High frq. ER");
        js.executeScript("window.scrollBy(0,400)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[1]//div[1]//ul[1]//li[2]//a[1]")).click();
       String ClaimsbyproTotalUtilizationperKER= driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        System.out.format("Cliaims By PRocedure Total Utilization Per 1000 : %s",ClaimsbyproTotalUtilizationperKER);
       String AvoidableERTotalUtil= driver.findElement(By.xpath("//div[@id='z5erutbc036']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        System.out.format("Avoidable ER Use Total Utilization Per 1000 : %s",AvoidableERTotalUtil);

        System.out.println("*---------------------High Frequency ER UTILIZATION --------------------------------*");
        String TotalERSpendOOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
        System.out.format("Total ER spend 1 or more last month=%s",TotalERSpendOOM);
        String TotalMemeberOOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
        System.out.format("Total ER spend 1 or more last month=%s",TotalMemeberOOM);
       // driver.findElement(By.xpath("")).getText();
        js.executeScript("window.scrollBy(0,700)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//select[@class='form-control px-2 mx-2']")).click();

        // 2 or more ER visit last month

         driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//option[contains(text(),'2 or more')]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         String TotalERSpendTOM= driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
         System.out.format("Total ER spend 2 or more last month=%s",TotalERSpendTOM);
         String TotalMemeberTOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
        System.out.format("Total ER spend 2 or more last month=%s",TotalMemeberTOM);

            // 3 or more last month
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//select[@class='form-control px-2 mx-2']")).click();
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//option[contains(text(),'3 or more')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String TotalERSpendThOM= driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
        System.out.format("Total ER spend 3 or more last month=%s",TotalERSpendThOM);
        String TotalMemeberThOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
        System.out.format("Total ER spend 3 or more last month=%s",TotalMemeberTOM);

            // 4 or more last month
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//select[@class='form-control px-2 mx-2']")).click();
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//option[contains(text(),'4 or more')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String TotalERSpendFOM= driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
        System.out.format("Total ER spend 4 or more last month=%s",TotalERSpendFOM);
        String TotalMemeberFOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
        System.out.format("Total ER spend 4 or more last month=%s",TotalMemeberFOM);

      //  driver.findElement(By.xpath("")).getText();
      //  driver.findElement(By.xpath("")).getText();
       // driver.findElement(By.xpath("")).getText();
        //driver.findElement(By.xpath("")).getText();




    }
}



