package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class population {
    public static void main (String[] args) {


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



        //select population from quick links
        driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Population')]")).click();




    //    driver.findElement(By.xpath("")).getText();
        System.out.println("*----------------Population Annual Spend---------------------------*");
       String PopulationAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Population Annual Spend: %s\n",PopulationAnnualSpend);

        System.out.println("*----------------Population Member Count---------------------------*");
        String PopulationMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Population Member Count : %s \n",PopulationMemberCount);

        System.out.println("*----------------Population Current Risk---------------------------*");
      String PopulationCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Population Current Risk: %s\n",PopulationCurrentRisk);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Click PMPM
     // driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
      //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //click in graph
      //driver.findElement(By.xpath("//div[@class='disease-item over-spend-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@width,'590')]//*[name()='g' and contains(@class,'circle')]//*[name()='circle' and contains(@cx,'330')]")).click();
      //Population PMPM
      System.out.println("*----------------Population PMPM---------------------------*");
        //  String PopulationPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        //System.out.format("Population PMPM : %s\n",PopulationPMPM);

        String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
        System.out.format("Reporting Period  : %s\n",ReportingPeriod);

     String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
        System.out.println(AllConditionServiceSpend);


      //  String allconditioninpatient= driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='highlights']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
         //String allconditioninpatient =driver.findElement(By.xpath("//svg[id='z5pophghtsmlc001']")).getText();
        //System.out.println(allconditioninpatient);
        System.out.println("*---------------Brand Drug -----------------------*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String BrandDrugSpend =   driver.findElement(By.xpath("//span[contains(text(),'Brand Drug Spend')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Brand Drug Spend:%s\n",BrandDrugSpend);



      //  String BrandDrugpc=driver.findElement(By.xpath("//span[@class='number']//p[@class='pos']")).getText();
        //System.out.format("Brand Drug Percent Change (Spend) : %s\n",BrandDrugpc);

        String GenericDrugSpend =   driver.findElement(By.xpath("//span[contains(text(),'Generic Drug Spend')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Generic Drug Spend:%s\n",GenericDrugSpend);


        String   DrugSavingsAvailable =   driver.findElement(By.xpath("//span[contains(text(),'Savings Available')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Savings Available:%s\n",  DrugSavingsAvailable);


        System.out.println("*---------------ER UTILIZATION -----------------------*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String ERUtilizationTotalSpend =   driver.findElement(By.xpath("//span[contains(text(),'ER Utilization Total Spend')]//following-sibling::span[@class='number']")).getText();
        System.out.format("ER Utilization Total Spend:%s\n",ERUtilizationTotalSpend);

        String   AvoidableERTotalSpend =   driver.findElement(By.xpath("//span[contains(text(),'Avoidable ER Total Spend')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Avoidable ER Total Spend:%s\n",  AvoidableERTotalSpend);

        String    NumberofERVisits =   driver.findElement(By.xpath("//span[contains(text(),'Number of ER Visits')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Number of ER Visits:%s\n",   NumberofERVisits);

        String   UrgentCareTotalSpend =   driver.findElement(By.xpath("//span[contains(text(),'Urgent Care Total Spend')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Urgent Care Total Spend:%s\n",  UrgentCareTotalSpend);

        String   NumberofUCVisits =   driver.findElement(By.xpath("//span[contains(text(),'Number of UC Visits')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Number of UC Visits:%s\n",  NumberofUCVisits);


        System.out.println("*-------------------------DEMOGRAPHICS---------------------------------*");


        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,300)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.linkText("Demographics")).click();
        //li[@class='nav-item']/a[@class='nav-link active' and contains(text(),'Demographics')]
       //driver.findElement(By.xpath("//li[@class='nav-item']/a[@class='nav-link active' and contains(text(),'Demographics')]")).click();
        driver.findElement(By.xpath("//a[@class='nav-link inactive'][contains(text(),'Demographics')]")).click();


        System.out.println("All Population : Age");



        String SpendAgeASpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Spend=%s\n",SpendAgeASpend);

        String SpendAgeAmember=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member Count=%s\n",SpendAgeAmember);

        String SpendAgeBSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Spend=%s\n",SpendAgeBSpend);

        String SpendAgeBmember=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member Count=%s\n",SpendAgeBmember);

        String SpendAgeCSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Spend=%s\n",SpendAgeCSpend);

        String SpendAgeCmember=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member Count=%s\n",SpendAgeCmember);


        String SpendAgeDSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Spend=%s\n",SpendAgeDSpend);
        String SpendAgeDmember=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member Count=%s\n",SpendAgeDmember);

        String SpendAgeESpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Spend=%s\n",SpendAgeESpend);
        String SpendAgeEmember=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member Count=%s\n",SpendAgeEmember);

        System.out.println("*------------------------------GENDER---------------------------------------*");


        String MaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Male Spend=%s\n",MaleSpend);
        String MaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Male Members Count=%s\n",MaleMembers);

        String FemaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Female Spend=%s\n",FemaleSpend);
        String FemaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Female Members Count=%s\n",FemaleMembers);

        String USpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Spend=%s\n",USpend);
        String Umember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Member Count=%s\n",Umember);

        System.out.println("*------------------------------Relationship---------------------------------------*");

        String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameA+"\n");

        String UnknownRelSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+"Employee Relationship Spend=%s\n",UnknownRelSpend);
        String UnknownRelmember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+"Unknown Relationship Member=%s\n",UnknownRelmember);


        String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameB+"\n");
        String EmployeeRelSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Spouse Relationship Spend=%s\n",EmployeeRelSpend);
        String EmployeeRelMemberCount=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Spouse Relationship Member Count=%s\n",EmployeeRelMemberCount);


        String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameC+"\n");
        String SpouseRelSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+"Spouse Relationship Spend=%s\n",SpouseRelSpend);
        String SpouseRelmemberCount=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+"Dependent Relationship Member Count=%s\n",SpouseRelmemberCount);


        String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameD+"\n");
        String DependentRelSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+"Other Relationship Spend=%s\n",DependentRelSpend);
        String DependentRelmember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+"Other Relationship Member Count=%s\n",DependentRelmember);


        System.out.println("*-------------------------Utilization---------------------------------*");


        // This  will scroll down the page by  500 pixel vertical
        // js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("*-------------------------All Conditions---------------------------------*");
        //a[contains(text(),'All Conditions')]
      //  js.executeScript("window.scrollBy(0,300)");
       driver.findElement(By.xpath("//a[contains(text(),'All Conditions')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  js.executeScript("window.scrollBy(0,300)");


        System.out.println("*-----------------Claims By Procedure-----------------------*");
        String TotalProcedurespend=driver.findElement(By.xpath("//div[@id='z5poptbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
        String wordpro = "Total Procedure Spend";
        String TotalProcedureSpend = TotalProcedurespend.replace(wordpro, "");
        System.out.format("Total Procedure Spend:%s\n",TotalProcedureSpend);

        System.out.println("*---------------Claims By Procedure Utilization tab-------------------------*\n");
        driver.findElement(By.xpath("//div[@class='row tab-pane active panel-bottom']//div[1]//div[1]//ul[1]//li[2]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String TotalutilizationperK=driver.findElement(By.xpath("//div[@id='z5poptbc002']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        String wordperk = "Total Utilization per 1000";
        String TotalUtilizationperK = TotalutilizationperK.replace(wordperk, "");
        System.out.format("Total Utilization per 1000: %s\n",TotalUtilizationperK);

        System.out.println("*-------------Catastrophic Claims------------------*\n");
        System.out.println("Medical Catestrophic\n");
        String catestrophicmed=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicmed);
        String MedCatestrophicUtilization=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilization);

        String MedCatestrophicmember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmember);

        String MedCatestrophicperchange=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchange);


        System.out.println("Pharmacy Catestrophic\n");
        String catestrophicphr=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicphr);
        String PhrCatestrophicUtilization=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilization);

        String PhrCatestrophicmember=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmember);

        String PhrCatestrophicperchange=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[2]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",PhrCatestrophicperchange);




       // js.executeScript("window.scrollBy(0,800)");
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       // driver.findElement(By.xpath("//div[@id='collapseOne']//div[3]//div[1]//ul[1]//li[2]//a[1]")).click();
       /*
        System.out.println("Service Spend"+":\n");
        js.executeScript("window.scrollBy(0,900)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //String ServiceInpatient=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        //System.out.println(ServiceInpatient+":\n");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String ServiceInperK=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@id='zp-accordion']/div[@class='panel']/div[@id='collapseOne']/div[@class='panel-body']/div[@class='row tab-pane active panel-bottom']/div[@class='col-6']/div[@class='disease-box zph-tabs']/div[@class='tab-content p-0']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Inpatient Utilization Per 1000:\n",ServiceInperK);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String ServiceInMembers=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientMembercount:%s\n",ServiceInMembers);
      //  String InpatientPMPM=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
       // System.out.format("InpatientPMPM:%s\n",InpatientPMPM);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String ServiceOfficeVisit=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(ServiceOfficeVisit+"\n");
         String ServiceOffperK= driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisit Utilization Per 1000:%s",ServiceOffperK);
         String ServiceOffmembers =  driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Office Visit Mem Count: %s\n",ServiceOffmembers);
        String OffvisitPMPM=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisitPMPM:%s\n",OffvisitPMPM);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       String ServiceOutpatient= driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(ServiceOutpatient+":\n");
       String ServiceOutperK=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("OfficeVisit Utilization Per 1000:%s\n",ServiceOutperK);
       String OutMemberCount=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Outpatient Mem Count: %s\n",OutMemberCount);
        String OutpatientPMPM=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Outpatient PMPM:%s\n",OutpatientPMPM);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String ERVisit=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(ERVisit);

        String ERVisitperK=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("ER VISIT Utilization Per 1000:%s\n",ERVisitperK);
     //   String ERcount=  driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
          String ERcount=  driver.findElement(By.xpath("//*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();

        System.out.format("ER VISIT Mem Count: %s\n",ERcount);
        String ERPMPM=driver.findElement(By.xpath("//div[@class='tab-pane active p-0']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("ER PMPM: %s\n",ERPMPM);

*/
    //    driver.findElement(By.xpath("")).click();
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='collapsed'][contains(text(),'Pharmacy')]")));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//a[@class='collapsed'][contains(text(),'Pharmacy')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.findElement(By.xpath("")).getText();
    }
    }
