package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class frequse {
    public static void main(String[] args) {


        String username = "#########@zakipoint.com";
        String password = "##########";
        String clientname = "Z5 Demo B";
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
        JavascriptExecutor js = (JavascriptExecutor) driver;

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

/*
        System.out.println("For Dashboard Section");

      //Annual Spend
       String PharmacyAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
        System.out.format("Pharmacy Annual Spend : %s\n",PharmacyAnnualSpend);

        //Savings
      //  String PharmacySavings=driver.findElement(By.xpath("")).getText();
        String PharmacySavings=driver.findElement(By.xpath("//h4[contains(text(),'Savings')]//following-sibling::span")).getText();
        System.out.format("Pharmacy Savings : %s\n",PharmacySavings);

/*
        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@width,'590')]//*[name()='g' and contains(@class,'circle')]//*[name()='circle' and contains(@cx,'330')]")).click();
        System.out.println("*----------------Population PMPM---------------------------*");
         String PharmacyPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        System.out.format("Population PMPM : %s\n",PharmacyPMPM);

*/
    /*---remove
        // Brand Drug
        System.out.println("*------------------------Brand Drug --------------------------------*");

        //js.executeScript("window.scrollBy(0,500)");
        String PharmacyBrandDrug=driver.findElement(By.xpath("//div[@id='z5phmhghtstbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Brand Drugs Spend')]//span")).getText();
        System.out.format("Pharmacy Brand Drug : %s\n",PharmacyBrandDrug);
        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        String Percentpharmacyspend=driver.findElement(By.xpath("//div[@id='z5phmhghtstbc001']//div[@class='bottom-placing']//div//p[contains(text(),'% of Pharmacy Spend')]//span")).getText();
        System.out.format("Percent Pharmacy Spend : %s\n",Percentpharmacyspend);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//a[@class='nav-link active'][contains(text(),'PMPM')]")).click();
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Non-Formulary And Specialty Drug Spend");

        String FormularySpend=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Formulary Spend :%s\n",FormularySpend);

        String FormularyTotalScripts=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Formulary Total Scripts :%s\n",FormularyTotalScripts);

        String FormularyMemcount=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Formulary Member Count :%s\n",FormularyMemcount);

        System.out.println("*-----------------------------------Non Formulary -----------------------------------------------*");
        String NonFormularySpend=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Non Formulary Spend :%s\n",NonFormularySpend);

        String NonFormularyTotalScripts=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Non Formulary Total Scripts :%s\n",NonFormularyTotalScripts);

        String NonFormularyMemcount=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Non Formulary Member Count :%s\n",NonFormularyMemcount);

        System.out.println("*-----------------------------------Specialty -----------------------------------------------*");
        String SpecialtySpend=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Specialty Spend :%s\n",SpecialtySpend);

        String SpecialtyTotalScripts=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Specialty Total Scripts :%s\n",SpecialtyTotalScripts);

        String SpecialtyMemcount=driver.findElement(By.xpath("//div[@class='tab-content no-padding-bottom']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Specialty Member Count :%s\n",SpecialtyMemcount);

        System.out.println("Retail Pharmacy Use\n");

        String RetailDrugSpend=driver.findElement(By.xpath("//span[contains(text(),'Retail Drug Spend')]//following-sibling::span[@class='number']")).getText();
         System.out.format("Retail Drug Spend :%s\n",RetailDrugSpend);

        String RetailDrugpc=driver.findElement(By.xpath("//span[contains(text(),'% Change(Spend)')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Retail Drug Percentage Change :%s\n",RetailDrugpc);

        String MailOrderDrugSpend=driver.findElement(By.xpath("//span[contains(text(),'Mail Order Drug Spend')]//following-sibling::span[@class='number']")).getText();
         System.out.format("Mail Order Drug Spend :%s\n",MailOrderDrugSpend);


        String Savingswhenmailorder=driver.findElement(By.xpath("//div[@class='col-4']//li[2]//following-sibling::span[@class='number']")).getText();
        System.out.format("Saving when mail Orders are avaialble :%s\n",Savingswhenmailorder);



        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        // System.out.format("Formulary Spend :%s\n",FormularySpend);

        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        // System.out.format("Formulary Spend :%s\n",FormularySpend);

        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        // System.out.format("Formulary Spend :%s\n",FormularySpend);

        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        // System.out.format("Formulary Spend :%s\n",FormularySpend);

        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        // System.out.format("Formulary Spend :%s\n",FormularySpend);




        //String PharmacySavings=driver.findElement(By.xpath("")).getText();
        //System.out.format("Formulary Spend :%s\n",FormularySpend);

        //String PharmacySavings=driver.findElement(By.xpath("")).getText();


        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("All Pharmacy Population : Age");
        driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
        //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
        js.executeScript("window.scrollBy(0,500)");
        */




















        System.out.println("*-----------------For Demography with age groups -----------------------------------------------------*");
 /*
        System.out.println("All Pharmacy Population : Age");


        String SpendAgeASpend = driver.findElement(By.xpath("")).getText();
        System.out.format("0-19 Spend=%s\n", SpendAgeASpend);

        String SpendAgeAmember = driver.findElement(By.xpath("")).getText();
        System.out.format("0-19 Member Count=%s\n", SpendAgeAmember);

        String SpendAgeBSpend = driver.findElement(By.xpath("")).getText();
        System.out.format("20-39 Spend=%s\n", SpendAgeBSpend);

        String SpendAgeBmember = driver.findElement(By.xpath("")).getText();
        System.out.format("20-39 Member Count=%s\n", SpendAgeBmember);

        String SpendAgeCSpend = driver.findElement(By.xpath("")).getText();
        System.out.format("40-59 Spend=%s\n", SpendAgeCSpend);

        String SpendAgeCmember = driver.findElement(By.xpath("")).getText();
        System.out.format("40-59 Member Count=%s\n", SpendAgeCmember);


        String SpendAgeDSpend = driver.findElement(By.xpath("")).getText();
        System.out.format("60-64 Spend=%s\n", SpendAgeDSpend);
        String SpendAgeDmember = driver.findElement(By.xpath("")).getText();
        System.out.format("60-64 Member Count=%s\n", SpendAgeDmember);

        String SpendAgeESpend = driver.findElement(By.xpath("")).getText();
        System.out.format("65+ Spend=%s\n", SpendAgeESpend);
        String SpendAgeEmember = driver.findElement(By.xpath("")).getText();
        System.out.format("65+ Member Count=%s\n", SpendAgeEmember);

        */

        /*

        System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
        String ERMaleSpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format("ERMale Spend Pharmacy=%s\n",ERMaleSpendPharmacy);
        String ERMaleMembersPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format("ERMale Members Count=%s\n",ERMaleMembersPharmacy);

        String ERFemaleSpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format("ERFemale Spend=%s\n",ERFemaleSpendPharmacy);
        String ERFemaleMembersPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format("ERFemale Members Count=%s\n",ERFemaleMembersPharmacy);

        String USpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format("Unknown Spend=%s\n",USpendPharmacy);
        String UmemberPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format("Unknown Member Count=%s\n",UmemberPharmacy);
   */

/*
         System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
        System.out.println("*------------------------------Relationship---------------------------------------*");

        String RelationshipNameB=driver.findElement(By.xpath("")).getText();
        System.out.println(RelationshipNameB);
        String EREmployeeRelSpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EREmployeeRelSpendPharmacy);
        String EREmployeeRelmemberPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameB+"Relationship Member=%s\n",EREmployeeRelmemberPharmacy);

        String RelationshipNameC=driver.findElement(By.xpath("")).getText();
        System.out.println(RelationshipNameC);
        String ERSpouseRelSpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameC+" Relationship Spend=%s\n",ERSpouseRelSpendPharmacy);
        String ERSpouseRelMemberCountPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",ERSpouseRelMemberCountPharmacy);


        String RelationshipNameD=driver.findElement(By.xpath("")).getText();
        System.out.println(RelationshipNameD);
        String ERDependentRelSpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameD+" Relationship Spend=%s\n",ERDependentRelSpendPharmacy);
        String ERDependentRelmemberCountPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",ERDependentRelmemberCountPharmacy);

        String RelationshipNameA=driver.findElement(By.xpath("")).getText();
        System.out.println(RelationshipNameA);
        String EROthersRelSpendPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameA+" Relationship Spend=%s\n",EROthersRelSpendPharmacy);
        String EROthersRelmemberPharmacy=driver.findElement(By.xpath("")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",EROthersRelmemberPharmacy);





*/
        /*

        //*--------------------------------------Wellness----------------------------------- */


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
        String HighERriskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk Spend:%s\n",HighERriskspend);

        String HighERRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk Member:%s\n",HighERRiskMember);

        String Highpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High percentage change member: %s\n",Highpcmember);

        /* Medium RISK */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("*--------------------MEDIUM RISK---------------------------*\n");
        //System.out.println("Prospective Population Risk Stratification\n" );
        String MediumERriskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk Spend:%s\n",MediumERriskspend);

        String MediumERRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk Member:%s\n",MediumERRiskMember);

        String Mediumpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Percenage memeber: %s\n",Mediumpcmember);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        String NormalERRiskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk Spend:%s\n",NormalERRiskspend);

        String NormalERRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk Member:%s\n",NormalERRiskMember);

        String Normalpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Percentage memeber: %s\n",Normalpcmember);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        String LowERriskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Spend:%s\n",LowERriskspend);

        String LowERRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk Member:%s\n",LowERRiskMember);

        String Lowpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Percenage memeber: %s\n",Lowpcmember);




        // For PMPM
        driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        // js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  System.out.println("Prospective Population Risk Stratification\n" );
        // String HighERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //System.out.format("High Risk Spend:%s\n",HighERriskspendpmpm);

        //String HighERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        //System.out.format("High Risk Member:%s\n",HighERRiskMemberpmpm);

        String HighERRiskPMPM=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("High Risk PMPM: %s\n",HighERRiskPMPM);

        /* Medium RISK */

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // System.out.println("*--------------------MEDIUM RISK---------------------------*\n");
        //System.out.println("Prospective Population Risk Stratification\n" );
        // String MediumERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //   System.out.format("Medium Risk Spend:%s\n",MediumERriskspendpmpm);

        // String MediumERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        // System.out.format("Medium Risk Member:%s\n",MediumERRiskMemberpmpm);

        String MediumERRiskPMPM=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Medium Risk PMPM: %s\n",MediumERRiskPMPM);

        /* Normal RISK */
        System.out.println("*--------------------Normal RISK---------------------------*\n");
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        //  String NormalERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //   System.out.format("Normal Risk Spend:%s\n",NormalERriskspendpmpm);

        //   String NormalERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        //   System.out.format("Normal Risk Member:%s\n",NormalERRiskMemberpmpm);

        String NormalERRiskpmpm=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Normal Risk PMPM: %s\n",NormalERRiskpmpm);

        /* LOW RISK */
        System.out.println("*--------------------Low RISK---------------------------*\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Prospective Population Risk Stratification\n" );
        //  String LowERriskspendpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        //  System.out.format("Low Risk Spend:%s\n",LowERriskspendpmpm);

        //   String LowERRiskMemberpmpm=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        //  System.out.format("Low Risk Member:%s\n",LowERRiskMemberpmpm);

        String LowERRiskPMPM=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Low Risk PMPM: %s\n",LowERRiskPMPM);






        /*--------------------------------------Catestrophic Claims*/
        System.out.println("*-------------Catastrophic Claims------------------*\n");
        System.out.println("Medical Catestrophic\n");
        String catestrophicmedInpatient=driver.findElement(By.xpath("")).getText();
        System.out.println(catestrophicmedInpatient);
        String MedCatestrophicUtilizationInpatient=driver.findElement(By.xpath("")).getText();
        System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationInpatient);

        String MedCatestrophicmemberInpatient=driver.findElement(By.xpath("")).getText();
        System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberInpatient);

        String MedCatestrophicperchangeInpatient=driver.findElement(By.xpath("")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeInpatient);


        System.out.println("Inpatient Catestrophic\n");
        String catestrophicphrInpatient=driver.findElement(By.xpath("")).getText();
        System.out.println(catestrophicphrInpatient);
        String PhrCatestrophicUtilizationInpatient=driver.findElement(By.xpath("")).getText();
        System.out.format("Inpatient-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationInpatient);

        String PhrCatestrophicmemberInpatient=driver.findElement(By.xpath("")).getText();
        System.out.format("Inpatient-Catestrophic-member Count:%s\n",PhrCatestrophicmemberInpatient);

        String PhrCatestrophicperchangeInpatient=driver.findElement(By.xpath("")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",PhrCatestrophicperchangeInpatient);



    }
}
