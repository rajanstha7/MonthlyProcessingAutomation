package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Inpatient {

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


            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Inpatient')]")).click();


        System.out.println("For Dashboard Section");

        //Annual Spend
        String InpatientAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
        System.out.format("Inpatient Annual Spend : %s\n",InpatientAnnualSpend);

        System.out.println("*----------------Inpatient Member Count---------------------------*");
        String InpatientMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Inpatient Member Count : %s \n",InpatientMemberCount);

        System.out.println("*----------------Inpatient Current Risk---------------------------*");
        String InpatientCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
        System.out.format("Inpatient Current Risk: %s\n",InpatientCurrentRisk);
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
        System.out.println("*----------------Inpatient PMPM---------------------------*");
          String InpatientPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
        System.out.format("Inpatient PMPM : %s\n",InpatientPMPM);

        String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
        System.out.format("Reporting Period  : %s\n",ReportingPeriod);

       // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
      //  System.out.println(AllConditionServiceSpend);


        js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("All Inpatient Population : Age");
       // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
        //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
      //  js.executeScript("window.scrollBy(0,500)");



        System.out.println("All Inpatient Population : Age");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String InpatientSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Spend=%s\n", InpatientSpendAgeASpend);
        String InpatientSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member Count=%s\n", InpatientSpendAgeAmember);
        String InpatientSpendAgeAmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("0-19 Member PMPM=%s\n", InpatientSpendAgeAmemberPMPM);

        String InpatientSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Spend=%s\n", InpatientSpendAgeBSpend);
        String InpatientSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member Count=%s\n", InpatientSpendAgeBmember);
        String InpatientSpendAgeBmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("20-39 Member PMPM=%s\n", InpatientSpendAgeBmemberPMPM);

        String InpatientSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Spend=%s\n", InpatientSpendAgeCSpend);
        String InpatientSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member Count=%s\n", InpatientSpendAgeCmember);
        String InpatientSpendAgeCmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("40-59 Member PMPM=%s\n", InpatientSpendAgeCmemberPMPM);


        String InpatientSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Spend=%s\n", InpatientSpendAgeDSpend);
        String InpatientSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member Count=%s\n", InpatientSpendAgeDmember);
        String InpatientSpendAgeDmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("60-64 Member PMPM=%s\n", InpatientSpendAgeDmemberPMPM);


        String InpatientSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Spend=%s\n", InpatientSpendAgeESpend);
        String InpatientSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member Count=%s\n", InpatientSpendAgeEmember);
        String InpatientSpendAgeEmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("65+ Member PMPM=%s\n", InpatientSpendAgeEmemberPMPM);



        System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
        String InpatientMaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientMale Spend =%s\n",InpatientMaleSpend);
        String InpatientMaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientMale Members Count=%s\n",InpatientMaleMembers);
        String InpatientMaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientMale Members Count=%s\n",InpatientMaleMembersPMPM);

        String InpatientFemaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientFemale Spend=%s\n",InpatientFemaleSpend);
        String InpatientFemaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientFemale Members Count=%s\n",InpatientFemaleMembers);
        String InpatientFemaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("InpatientFemale Members Count=%s\n",InpatientFemaleMembersPMPM);

        String USpendInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Spend=%s\n",USpendInpatient);
        String UmemberInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Member Count=%s\n",UmemberInpatient);
        String InpatientUMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Unknown Members Count=%s\n",InpatientUMembersPMPM);




        System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
        System.out.println("*------------------------------Relationship---------------------------------------*");

        String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameA);
        String OthersRelSpendInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Spend=%s\n",OthersRelSpendInpatient);
        String OthersRelmemberInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberInpatient);
        String OthersRelmemberInpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberInpatientPMPM);



        String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameB);
        String EmployeeRelSpendInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EmployeeRelSpendInpatient);
        String EmployeeRelmemberInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+"Relationship Member=%s\n",EmployeeRelmemberInpatient);
        String EmployeeRelmemberInpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameB+" Relationship Member Count=%s\n",EmployeeRelmemberInpatientPMPM);


        String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameC);
        String SpouseRelSpendInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Spend=%s\n",SpouseRelSpendInpatient);
        String SpouseRelMemberCountInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",SpouseRelMemberCountInpatient);
        String SpouseRelmemberInpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",SpouseRelmemberInpatientPMPM);


        String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
        System.out.println(RelationshipNameD);
        String DependentRelSpendInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Spend=%s\n",DependentRelSpendInpatient);
        String DependentRelmemberCountInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",DependentRelmemberCountInpatient);
        String DependentRelmemberInpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",DependentRelmemberInpatientPMPM);

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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='disease-item er-box']//a[@class='nav-link inactive'][contains(text(),'Spend')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            js.executeScript("window.scrollBy(0,500)");
       String InpatientClaimsbyprocedure=driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
        //System.out.format("ER claims By Procedure: %s",ERClaimsbyprocedure);
        String word = "Total Procedure Spend";
        String InpatientClaimsbyProcedure = InpatientClaimsbyprocedure.replace(word, "");
        System.out.format("Inpatient claims By Procedure: %s",InpatientClaimsbyProcedure);
        //ERClaimsbyprocedure = removeWord(ERClaimsbyprocedure,word);
            js.executeScript("window.scrollBy(0,1100)");

            System.out.println("Out of Network Provider");
        String TotalProviderSpendinpatient=driver.findElement(By.xpath("//div[@id='z5erutbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Provider Spend')]")).getText();
        String wordr = "Total Provider Spend";
        String TotalProviderSpendInpatient = TotalProviderSpendinpatient.replace(wordr, "");
        System.out.format("Total Provider Spend Inpatient: %s",TotalProviderSpendInpatient);


            System.out.println("Out of Network Procedures");
            String TotalProcedureSpendinpatient=driver.findElement(By.xpath("//div[@id='z5erutbc005']//div[@class='bottom-placing']//div//p[contains(text(),'Total Spend')]")).getText();
            String wordp = "Total Spend";
            String TotalProcedureSpendInpatient = TotalProcedureSpendinpatient.replace(wordp, "");
            System.out.format("Total Procedure Spend Inpatient: %s",TotalProcedureSpendInpatient);
        //String InpatientVoneTotalSpend=driver.findElement(By.xpath("")).getText();

        System.out.println("*-------------Catastrophic Claims------------------*\n");
        System.out.println("Medical Catestrophic\n");
        String catestrophicmedInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicmedInpatient);
        String MedCatestrophicUtilizationInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationInpatient);

        String MedCatestrophicmemberInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberInpatient);

        String MedCatestrophicperchangeInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeInpatient);


        System.out.println("Pharmacy Catestrophic\n");
        String catestrophicphrInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
        System.out.println(catestrophicphrInpatient);
        String PhrCatestrophicUtilizationInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
        System.out.format("Inpatient-Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationInpatient);

        String PhrCatestrophicmemberInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
        System.out.format("Inpatient-Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmemberInpatient);

        String PhrCatestrophicperchangeInpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
        System.out.format("Pharmacy-Inpatient-Catestrophic percentage change :%s\n",PhrCatestrophicperchangeInpatient);

        driver.findElement(By.xpath("//div[@id='Utilization']//div[4]//div[1]//ul[1]//li[2]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String ClaimsbyproTotalUtilizationperKinpatient= driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        String wordc = "Total Utilization per 1000";
        String ClaimsbyproTotalUtilizationperKInpatient = ClaimsbyproTotalUtilizationperKinpatient.replace(wordc, "");
        System.out.format("Cliaims By PRocedure Total Utilization Per 1000 : %s",ClaimsbyproTotalUtilizationperKInpatient);

        String OutofNetworkProvidersperKinpatient= driver.findElement(By.xpath("//div[@id='z5erutbc002']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
        String OutofNetworkProvidersperKInpatient = OutofNetworkProvidersperKinpatient.replace(wordc, "");
        System.out.format("Out of Network Providers Total Utilization Per 1000 : %s",OutofNetworkProvidersperKInpatient);

        String OutofNetworkProcedureperKinpatient= driver.findElement(By.xpath("//div[@id='z5erutbc006']//div[@class='bottom-placing']//div//p[contains(text(),'Total Member per 1000')]")).getText();
        String worde = "Total Member per 1000";
        String OutofNetworkProcedureperKInpatient = OutofNetworkProcedureperKinpatient.replace(worde, "");
        System.out.format("Out of Network Procedures Total Utilization Per 1000 : %s",OutofNetworkProcedureperKInpatient);

        System.out.println("*-------------------------Wellness-----------------------*");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();

            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Inpatient')]")).click();
            //js.executeScript("window.scrollBy(0,-1000)");
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[contains(text(),'Wellness')]")).click();


            // Inpatient Risk SCORE
            /* HIGH RISK */
            System.out.println("*--------------------InpatientRISK SCORE---------------------------*\n");
            System.out.println("*--------------------HIGH RISK---------------------------*\n");
            js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //  System.out.println("Prospective Population Risk Stratification\n" );
            String HighInpatientriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("High Inpatient Risk Spend:%s\n", HighInpatientriskspend);

            String HighInpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("High Inpatient Risk Member:%s\n", HighInpatientRiskMember);

            String HighInpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High percentage change member: %s\n", HighInpatientpcmember);

            /* Medium RISK */

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("*--------------------Inpatient MEDIUM RISK---------------------------*\n");

            String MediumInpatientriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Inpatient Medium Risk Spend:%s\n", MediumInpatientriskspend);

            String MediumInpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Inpatient Risk Member:%s\n", MediumInpatientRiskMember);

            String MediumInpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Inpatient Percentage memeber: %s\n", MediumInpatientpcmember);

            /* Normal RISK */
            System.out.println("*--------------------Normal RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String NormalInpatientRiskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Inpatient Risk Spend:%s\n", NormalInpatientRiskspend);

            String NormalInpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Inpatient Risk Member:%s\n", NormalInpatientRiskMember);

            String NormalInpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Inpatient Percentage memeber: %s\n", NormalInpatientpcmember);

            /* LOW RISK */
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String LowInpatientriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Risk Spend:%s\n", LowInpatientriskspend);

            String LowInpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Inpatient Risk Member:%s\n", LowInpatientRiskMember);

            String LowInpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Inpatient Percentage memeber: %s\n", LowInpatientpcmember);


            // For PMPM
            driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
            // js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String HighInpatientRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High Inpatient Risk PMPM: %s\n", HighInpatientRiskPMPM);

            /* Medium RISK */

            String MediumInpatientRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Inpatient Risk PMPM: %s\n", MediumInpatientRiskPMPM);

            /* Normal RISK */
            System.out.println("*--------------------Normal RISK---------------------------*\n");


            String NormalInpatientRiskpmpm = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Risk PMPM: %s\n", NormalInpatientRiskpmpm);

            /* LOW RISK */
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            String LowInpatientRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Inpatient Risk PMPM: %s\n", LowInpatientRiskPMPM);


        }
    }





