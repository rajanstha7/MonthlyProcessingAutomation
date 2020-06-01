package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class pharmacy {

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
       // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
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

//        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img//following-sibling::span[contains(text(),'Quick')]")).click();

        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();


        //select pharmacy from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Pharmacy')]")).click();


      //Annual Spend
       String PharmacyAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
        System.out.format("Pharmacy Annual Spend : %s\n",PharmacyAnnualSpend);

        //Savings
      //  String PharmacySavings=driver.findElement(By.xpath("")).getText();
        String PharmacySavings=driver.findElement(By.xpath("//h4[contains(text(),'Savings')]//following-sibling::span")).getText();
        System.out.format("Pharmacy Savings : %s\n",PharmacySavings);


        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@width,'590')]//*[name()='g' and contains(@class,'circle')]//*[name()='circle' and contains(@cx,'330')]")).click();
        System.out.println("*----------------Population PMPM---------------------------*");
         String PharmacyPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        System.out.format("Population PMPM : %s\n",PharmacyPMPM);



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



        String SpendAgeAPharmacySpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Spend=%s\n",SpendAgeAPharmacySpend);

        String SpendAgeAPharmacymember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member Count=%s\n",SpendAgeAPharmacymember);

        String SpendAgeBPharmacySpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Spend=%s\n",SpendAgeBPharmacySpend);

        String SpendAgeBPharmacymember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member Count=%s\n",SpendAgeBPharmacymember);

        String SpendAgeCPharmacySpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Spend=%s\n",SpendAgeCPharmacySpend);

        String SpendAgeCPharmacymember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member Count=%s\n",SpendAgeCPharmacymember);


        String SpendAgeDPharmacySpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Spend=%s\n",SpendAgeDPharmacySpend);
        String SpendAgeDPharmacymember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member Count=%s\n",SpendAgeDPharmacymember);

        String SpendAgeEPharmacySpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
       System.out.format("65+ Spend=%s\n",SpendAgeEPharmacySpend);
        String SpendAgeEPharmacymember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member Count=%s\n",SpendAgeEPharmacymember);



        System.out.println("*------------------------------GENDER---------------------------------------*");
/*
        String MaleSpendPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Male Spend Pharmacy=%s\n",MaleSpendPharmacy);
        String MaleMembersPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Male Members Count=%s\n",MaleMembersPharmacy);


  */




        String MaleSpendPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Male Spend Pharmacy=%s\n",MaleSpendPharmacy);
        String MaleMembersPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Male Members Count=%s\n",MaleMembersPharmacy);

        String FemaleSpendPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Female Spend=%s\n",FemaleSpendPharmacy);
        String FemaleMembersPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Female Members Count=%s\n",FemaleMembersPharmacy);

        String USpendPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Spend=%s\n",USpendPharmacy);
        String UmemberPharmacy=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Member Count=%s\n",UmemberPharmacy);

        System.out.println("*------------------------------Relationship---------------------------------------*");


        String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameB);
        String EmployeeRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EmployeeRelSpendPharmacy);
        String EmployeeRelmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Member=%s\n",EmployeeRelmemberPharmacy);

        String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameC);
        String SpouseRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Spend=%s\n",SpouseRelSpendPharmacy);
        String SpouseRelMemberCountPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",SpouseRelMemberCountPharmacy);


        String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameD);
        String DependentRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Spend=%s\n",DependentRelSpendPharmacy);
        String DependentRelmemberCountPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",DependentRelmemberCountPharmacy);

        String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameA);
        String OthersRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Spend=%s\n",OthersRelSpendPharmacy);
        String OthersRelmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberPharmacy);


        //String SpendAgeAmemberPharmacy=driver.findElement(By.xpath("")).getText();
        //System.out.format("0-19 Member Count=%s\n",SpendAgeAmemberPharmacy);

           //      driver.findElement(By.xpath("")).getText();
        //      driver.findElement(By.xpath("")).getText();







     //      driver.findElement(By.xpath("")).getText();



    }
}


