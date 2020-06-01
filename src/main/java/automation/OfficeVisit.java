package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OfficeVisit {
    
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

//        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img//following-sibling::span[contains(text(),'Quick')]")).click();

            driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();


            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Office Visit')]")).click();


            System.out.println("For Dashboard Section");

            //Annual Spend
            String OfficeVisitAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
            System.out.format("OfficeVisit Annual Spend : %s\n",OfficeVisitAnnualSpend);

            System.out.println("*----------------OfficeVisit Member Count---------------------------*");
            String OfficeVisitMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
            System.out.format("OfficeVisit Member Count : %s \n",OfficeVisitMemberCount);

            System.out.println("*----------------OfficeVisit Current Risk---------------------------*");
            String OfficeVisitCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
            System.out.format("OfficeVisit Current Risk: %s\n",OfficeVisitCurrentRisk);
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
            System.out.println("*----------------OfficeVisit PMPM---------------------------*");
            String OfficeVisitPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
            System.out.format("OfficeVisit PMPM : %s\n",OfficeVisitPMPM);

            String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
            System.out.format("Reporting Period  : %s\n",ReportingPeriod);

            // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
            //  System.out.println(AllConditionServiceSpend);


            js.executeScript("window.scrollBy(0,200)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("All OfficeVisit Population : Age");
            // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
            //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
            //  js.executeScript("window.scrollBy(0,500)");



            System.out.println("All OfficeVisit Population : Age");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String OfficeVisitSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Spend=%s\n", OfficeVisitSpendAgeASpend);
            String OfficeVisitSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Member Count=%s\n", OfficeVisitSpendAgeAmember);
            String OfficeVisitSpendAgeAmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Member PMPM=%s\n", OfficeVisitSpendAgeAmemberPMPM);

            String OfficeVisitSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Spend=%s\n", OfficeVisitSpendAgeBSpend);
            String OfficeVisitSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Member Count=%s\n", OfficeVisitSpendAgeBmember);
            String OfficeVisitSpendAgeBmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Member PMPM=%s\n", OfficeVisitSpendAgeBmemberPMPM);

            String OfficeVisitSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Spend=%s\n", OfficeVisitSpendAgeCSpend);
            String OfficeVisitSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Member Count=%s\n", OfficeVisitSpendAgeCmember);
            String OfficeVisitSpendAgeCmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Member PMPM=%s\n", OfficeVisitSpendAgeCmemberPMPM);


            String OfficeVisitSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Spend=%s\n", OfficeVisitSpendAgeDSpend);
            String OfficeVisitSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Member Count=%s\n", OfficeVisitSpendAgeDmember);
            String OfficeVisitSpendAgeDmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Member PMPM=%s\n", OfficeVisitSpendAgeDmemberPMPM);


            String OfficeVisitSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Spend=%s\n", OfficeVisitSpendAgeESpend);
            String OfficeVisitSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Member Count=%s\n", OfficeVisitSpendAgeEmember);
            String OfficeVisitSpendAgeEmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Member PMPM=%s\n", OfficeVisitSpendAgeEmemberPMPM);



            System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
            String OfficeVisitMaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisitMale Spend =%s\n",OfficeVisitMaleSpend);
            String OfficeVisitMaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisitMale Members Count=%s\n",OfficeVisitMaleMembers);
            String OfficeVisitMaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisitMale Members Count=%s\n",OfficeVisitMaleMembersPMPM);

            String OfficeVisitFemaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisitFemale Spend=%s\n",OfficeVisitFemaleSpend);
            String OfficeVisitFemaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisitFemale Members Count=%s\n",OfficeVisitFemaleMembers);
            String OfficeVisitFemaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisitFeMale Members Count=%s\n",OfficeVisitFemaleMembersPMPM);

            String USpendOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Spend=%s\n",USpendOfficeVisit);
            String UmemberOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Member Count=%s\n",UmemberOfficeVisit);
            String OfficeVisitUMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Members Count=%s\n",OfficeVisitUMembersPMPM);




            System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
            System.out.println("*------------------------------Relationship---------------------------------------*");

            String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameA);
            String OthersRelSpendOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Spend=%s\n",OthersRelSpendOfficeVisit);
            String OthersRelmemberOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberOfficeVisit);
            String OthersRelmemberOfficeVisitPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberOfficeVisitPMPM);



            String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameB);
            String EmployeeRelSpendOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EmployeeRelSpendOfficeVisit);
            String EmployeeRelmemberOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+"Relationship Member=%s\n",EmployeeRelmemberOfficeVisit);
            String EmployeeRelmemberOfficeVisitPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+" Relationship Member Count PMPM=%s\n",EmployeeRelmemberOfficeVisitPMPM);


            String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameC);
            String SpouseRelSpendOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Spend=%s\n",SpouseRelSpendOfficeVisit);
            String SpouseRelMemberCountOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",SpouseRelMemberCountOfficeVisit);
            String SpouseRelmemberOfficeVisitPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Member Count PMPM=%s\n",SpouseRelmemberOfficeVisitPMPM);


            String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameD);
            String DependentRelSpendOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Spend=%s\n",DependentRelSpendOfficeVisit);
            String DependentRelmemberCountOfficeVisit=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",DependentRelmemberCountOfficeVisit);
            String DependentRelmemberOfficeVisitPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Member Count PMPM=%s\n",DependentRelmemberOfficeVisitPMPM);

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
            String ClaimsbyproTotalUtilizationperKofficeVisit= driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            String wordc = "Total Utilization per 1000";
            String ClaimsbyproTotalUtilizationperKOfficeVisit = ClaimsbyproTotalUtilizationperKofficeVisit.replace(wordc, "");
            System.out.format("Cliaims By PRocedure Total Utilization Per 1000 : %s",ClaimsbyproTotalUtilizationperKOfficeVisit);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@class='disease-box zph-tabs']//a[@class='nav-link inactive'][contains(text(),'Spend')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            js.executeScript("window.scrollBy(0,500)");
            String OfficeVisitClaimsbyprocedure=driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
            //System.out.format("OfficeVisitclaims By Procedure: %s",OfficeVisitClaimsbyprocedure);
            String word = "Total Procedure Spend";
            String OfficeVisitClaimsbyProcedure = OfficeVisitClaimsbyprocedure.replace(word, "");
            System.out.format("OfficeVisit claims By Procedure: %s",OfficeVisitClaimsbyProcedure);
            //ERClaimsbyprocedure = removeWord(ERClaimsbyprocedure,word);
            //js.executeScript("window.scrollBy(0,1100)");
            js.executeScript("window.scrollBy(0,800)");
/*
            System.out.println("Out of Network Provider");
            String TotalProviderSpendofficeVisit=driver.findElement(By.xpath("//div[@id='z5erutbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Provider Spend')]")).getText();
            String wordr = "Total Provider Spend";
            String TotalProviderSpendOfficeVisit = TotalProviderSpendofficeVisit.replace(wordr, "");
            System.out.format("Total Provider Spend OfficeVisit: %s",TotalProviderSpendOfficeVisit);


            System.out.println("Out of Network Procedures");
            String TotalProcedureSpendofficeVisit=driver.findElement(By.xpath("//div[@id='z5erutbc005']//div[@class='bottom-placing']//div//p[contains(text(),'Total Spend')]")).getText();
            String wordp = "Total Spend";
            String TotalProcedureSpendOfficeVisit = TotalProcedureSpendofficeVisit.replace(wordp, "");
            System.out.format("Total Procedure Spend OfficeVisit: %s",TotalProcedureSpendOfficeVisit);
            //String OfficeVisitVoneTotalSpend=driver.findElement(By.xpath("")).getText();

 */

            System.out.println("*-------------Catastrophic Claims------------------*\n");
            System.out.println("Medical Catestrophic\n");
            String catestrophicmedOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
            System.out.println(catestrophicmedOfficeVisit);
            String MedCatestrophicUtilizationOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationOfficeVisit);

            String MedCatestrophicmemberOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberOfficeVisit);

            String MedCatestrophicperchangeOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeOfficeVisit);


            System.out.println("Pharmacy Catestrophic\n");
            String catestrophicphrOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
            System.out.println(catestrophicphrOfficeVisit);
            String PhrCatestrophicUtilizationOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisit-Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationOfficeVisit);

            String PhrCatestrophicmemberOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisit-Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmemberOfficeVisit);

            String PhrCatestrophicperchangeOfficeVisit=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Pharmacy-OfficeVisit-Catestrophic percentage change :%s\n",PhrCatestrophicperchangeOfficeVisit);




         /*   String OutofNetworkProvidersperKofficeVisit= driver.findElement(By.xpath("//div[@id='z5erutbc002']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            String OutofNetworkProvidersperKOfficeVisit = OutofNetworkProvidersperKofficeVisit.replace(wordc, "");
            System.out.format("Out of Network Providers Total Utilization Per 1000 : %s",OutofNetworkProvidersperKOfficeVisit);

            String OutofNetworkProcedureperKofficeVisit= driver.findElement(By.xpath("//div[@id='z5erutbc006']//div[@class='bottom-placing']//div//p[contains(text(),'Total Member per 1000')]")).getText();
            String worde = "Total Member per 1000";
            String OutofNetworkProcedureperKOfficeVisit = OutofNetworkProcedureperKofficeVisit.replace(worde, "");
            System.out.format("Out of Network Procedures Total Utilization Per 1000 : %s",OutofNetworkProcedureperKOfficeVisit);
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


            // OfficeVisit Risk SCORE
            /* HIGH RISK */
            System.out.println("*--------------------OfficeVisitRISK SCORE---------------------------*\n");
            System.out.println("*--------------------HIGH RISK---------------------------*\n");
            js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //  System.out.println("Prospective Population Risk Stratification\n" );
            String HighOfficeVisitriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("High OfficeVisit Risk Spend:%s\n", HighOfficeVisitriskspend);

            String HighOfficeVisitRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("High OfficeVisit Risk Member:%s\n", HighOfficeVisitRiskMember);

            String HighOfficeVisitpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High percentage change member: %s\n", HighOfficeVisitpcmember);

            /* Medium RISK */

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("*--------------------OfficeVisit MEDIUM RISK---------------------------*\n");

            String MediumOfficeVisitriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("OfficeVisit Medium Risk Spend:%s\n", MediumOfficeVisitriskspend);

            String MediumOfficeVisitRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium OfficeVisit Risk Member:%s\n", MediumOfficeVisitRiskMember);

            String MediumOfficeVisitpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium OfficeVisit Percentage memeber: %s\n", MediumOfficeVisitpcmember);

            /* Normal RISK */
            System.out.println("*--------------------Normal RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String NormalOfficeVisitRiskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal OfficeVisit Risk Spend:%s\n", NormalOfficeVisitRiskspend);

            String NormalOfficeVisitRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal OfficeVisit Risk Member:%s\n", NormalOfficeVisitRiskMember);

            String NormalOfficeVisitpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal OfficeVisit Percentage memeber: %s\n", NormalOfficeVisitpcmember);

            /* LOW RISK */
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String LowOfficeVisitriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Risk Spend:%s\n", LowOfficeVisitriskspend);

            String LowOfficeVisitRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Low OfficeVisit Risk Member:%s\n", LowOfficeVisitRiskMember);

            String LowOfficeVisitpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low OfficeVisit Percentage memeber: %s\n", LowOfficeVisitpcmember);


            // For PMPM
            driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
            // js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String HighOfficeVisitRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High OfficeVisit Risk PMPM: %s\n", HighOfficeVisitRiskPMPM);

            /* Medium RISK */

            String MediumOfficeVisitRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium OfficeVisit Risk PMPM: %s\n", MediumOfficeVisitRiskPMPM);

            /* Normal RISK */
            System.out.println("*--------------------Normal RISK---------------------------*\n");


            String NormalOfficeVisitRiskpmpm = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Risk PMPM: %s\n", NormalOfficeVisitRiskpmpm);

            /* LOW RISK */
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            String LowOfficeVisitRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low OfficeVisit Risk PMPM: %s\n", LowOfficeVisitRiskPMPM);


        }
    }









