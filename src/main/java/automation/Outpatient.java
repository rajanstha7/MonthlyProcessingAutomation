package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Outpatient {
   

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

//        driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img//following-sibling::span[contains(text(),'Quick')]")).click();

            driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();


            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Outpatient')]")).click();


            System.out.println("For Dashboard Section");

            //Annual Spend
            String OutpatientAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
            System.out.format("Outpatient Annual Spend : %s\n",OutpatientAnnualSpend);

            System.out.println("*----------------Outpatient Member Count---------------------------*");
            String OutpatientMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
            System.out.format("Outpatient Member Count : %s \n",OutpatientMemberCount);

            System.out.println("*----------------Outpatient Current Risk---------------------------*");
            String OutpatientCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
            System.out.format("Outpatient Current Risk: %s\n",OutpatientCurrentRisk);
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
            System.out.println("*----------------Outpatient PMPM---------------------------*");
            String OutpatientPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
            System.out.format("Outpatient PMPM : %s\n",OutpatientPMPM);

            String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
            System.out.format("Reporting Period  : %s\n",ReportingPeriod);

            // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
            //  System.out.println(AllConditionServiceSpend);


            js.executeScript("window.scrollBy(0,200)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("All Outpatient Population : Age");
            // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
            //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
            //  js.executeScript("window.scrollBy(0,500)");



            System.out.println("All Outpatient Population : Age");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String OutpatientSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Spend=%s\n", OutpatientSpendAgeASpend);
            String OutpatientSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Member Count=%s\n", OutpatientSpendAgeAmember);
            String OutpatientSpendAgeAmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Member PMPM=%s\n", OutpatientSpendAgeAmemberPMPM);

            String OutpatientSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Spend=%s\n", OutpatientSpendAgeBSpend);
            String OutpatientSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Member Count=%s\n", OutpatientSpendAgeBmember);
            String OutpatientSpendAgeBmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Member PMPM=%s\n", OutpatientSpendAgeBmemberPMPM);

            String OutpatientSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Spend=%s\n", OutpatientSpendAgeCSpend);
            String OutpatientSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Member Count=%s\n", OutpatientSpendAgeCmember);
            String OutpatientSpendAgeCmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Member PMPM=%s\n", OutpatientSpendAgeCmemberPMPM);


            String OutpatientSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Spend=%s\n", OutpatientSpendAgeDSpend);
            String OutpatientSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Member Count=%s\n", OutpatientSpendAgeDmember);
            String OutpatientSpendAgeDmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Member PMPM=%s\n", OutpatientSpendAgeDmemberPMPM);


            String OutpatientSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Spend=%s\n", OutpatientSpendAgeESpend);
            String OutpatientSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Member Count=%s\n", OutpatientSpendAgeEmember);
            String OutpatientSpendAgeEmemberPMPM = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Member PMPM=%s\n", OutpatientSpendAgeEmemberPMPM);



            System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
            String OutpatientMaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("OutpatientMale Spend =%s\n",OutpatientMaleSpend);
            String OutpatientMaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("OutpatientMale Members Count=%s\n",OutpatientMaleMembers);
            String OutpatientMaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("OutpatientMale Members Count=%s\n",OutpatientMaleMembersPMPM);

            String OutpatientFemaleSpend=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("OutpatientFemale Spend=%s\n",OutpatientFemaleSpend);
            String OutpatientFemaleMembers=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("OutpatientFemale Members Count=%s\n",OutpatientFemaleMembers);
            String OutpatientFemaleMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("OutpatientFeMale Members Count=%s\n",OutpatientFemaleMembersPMPM);

            String USpendOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Spend=%s\n",USpendOutpatient);
            String UmemberOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Member Count=%s\n",UmemberOutpatient);
            String OutpatientUMembersPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[@class='col-6']/div[@class='disease-box']/div[@class='tab-content no-lr-padding']/div[@class='tab-content']/div[2]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Members Count=%s\n",OutpatientUMembersPMPM);




            System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
            System.out.println("*------------------------------Relationship---------------------------------------*");

            String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameA);
            String OthersRelSpendOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Spend=%s\n",OthersRelSpendOutpatient);
            String OthersRelmemberOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberOutpatient);
            String OthersRelmemberOutpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",OthersRelmemberOutpatientPMPM);



            String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameB);
            String EmployeeRelSpendOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+"Relationship Spend=%s\n",EmployeeRelSpendOutpatient);
            String EmployeeRelmemberOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+"Relationship Member=%s\n",EmployeeRelmemberOutpatient);
            String EmployeeRelmemberOutpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+" Relationship Member Count PMPM=%s\n",EmployeeRelmemberOutpatientPMPM);


            String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameC);
            String SpouseRelSpendOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Spend=%s\n",SpouseRelSpendOutpatient);
            String SpouseRelMemberCountOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",SpouseRelMemberCountOutpatient);
            String SpouseRelmemberOutpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Member Count PMPM=%s\n",SpouseRelmemberOutpatientPMPM);


            String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameD);
            String DependentRelSpendOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Spend=%s\n",DependentRelSpendOutpatient);
            String DependentRelmemberCountOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",DependentRelmemberCountOutpatient);
            String DependentRelmemberOutpatientPMPM=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Member Count PMPM=%s\n",DependentRelmemberOutpatientPMPM);

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
            String OutpatientClaimsbyprocedure=driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
            //System.out.format("ER claims By Procedure: %s",ERClaimsbyprocedure);
            String word = "Total Procedure Spend";
            String OutpatientClaimsbyProcedure = OutpatientClaimsbyprocedure.replace(word, "");
            System.out.format("Outpatient claims By Procedure: %s",OutpatientClaimsbyProcedure);
            //ERClaimsbyprocedure = removeWord(ERClaimsbyprocedure,word);
            js.executeScript("window.scrollBy(0,1100)");

            System.out.println("Out of Network Provider");
            String TotalProviderSpendoutpatient=driver.findElement(By.xpath("//div[@id='z5erutbc001']//div[@class='bottom-placing']//div//p[contains(text(),'Total Provider Spend')]")).getText();
            String wordr = "Total Provider Spend";
            String TotalProviderSpendOutpatient = TotalProviderSpendoutpatient.replace(wordr, "");
            System.out.format("Total Provider Spend Outpatient: %s",TotalProviderSpendOutpatient);


            System.out.println("Out of Network Procedures");
            String TotalProcedureSpendoutpatient=driver.findElement(By.xpath("//div[@id='z5erutbc005']//div[@class='bottom-placing']//div//p[contains(text(),'Total Spend')]")).getText();
            String wordp = "Total Spend";
            String TotalProcedureSpendOutpatient = TotalProcedureSpendoutpatient.replace(wordp, "");
            System.out.format("Total Procedure Spend Outpatient: %s",TotalProcedureSpendOutpatient);
            //String OutpatientVoneTotalSpend=driver.findElement(By.xpath("")).getText();

            System.out.println("*-------------Catastrophic Claims------------------*\n");
            System.out.println("Medical Catestrophic\n");
            String catestrophicmedOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
            System.out.println(catestrophicmedOutpatient);
            String MedCatestrophicUtilizationOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationOutpatient);

            String MedCatestrophicmemberOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberOutpatient);

            String MedCatestrophicperchangeOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeOutpatient);


            System.out.println("Pharmacy Catestrophic\n");
            String catestrophicphrOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
            System.out.println(catestrophicphrOutpatient);
            String PhrCatestrophicUtilizationOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Outpatient-Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationOutpatient);

            String PhrCatestrophicmemberOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Outpatient-Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmemberOutpatient);

            String PhrCatestrophicperchangeOutpatient=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='Utilization']/div[@class='row']/div[6]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Pharmacy-Outpatient-Catestrophic percentage change :%s\n",PhrCatestrophicperchangeOutpatient);

            driver.findElement(By.xpath("//div[@id='Utilization']//div[4]//div[1]//ul[1]//li[2]//a[1]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String ClaimsbyproTotalUtilizationperKoutpatient= driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            String wordc = "Total Utilization per 1000";
            String ClaimsbyproTotalUtilizationperKOutpatient = ClaimsbyproTotalUtilizationperKoutpatient.replace(wordc, "");
            System.out.format("Cliaims By PRocedure Total Utilization Per 1000 : %s",ClaimsbyproTotalUtilizationperKOutpatient);

            String OutofNetworkProvidersperKoutpatient= driver.findElement(By.xpath("//div[@id='z5erutbc002']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            String OutofNetworkProvidersperKOutpatient = OutofNetworkProvidersperKoutpatient.replace(wordc, "");
            System.out.format("Out of Network Providers Total Utilization Per 1000 : %s",OutofNetworkProvidersperKOutpatient);

            String OutofNetworkProcedureperKoutpatient= driver.findElement(By.xpath("//div[@id='z5erutbc006']//div[@class='bottom-placing']//div//p[contains(text(),'Total Member per 1000')]")).getText();
            String worde = "Total Member per 1000";
            String OutofNetworkProcedureperKOutpatient = OutofNetworkProcedureperKoutpatient.replace(worde, "");
            System.out.format("Out of Network Procedures Total Utilization Per 1000 : %s",OutofNetworkProcedureperKOutpatient);

            System.out.println("*-------------------------Wellness-----------------------*");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();

            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'Outpatient')]")).click();
            //js.executeScript("window.scrollBy(0,-1000)");
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[contains(text(),'Wellness')]")).click();


            // Outpatient Risk SCORE
            /* HIGH RISK */
            System.out.println("*--------------------OutpatientRISK SCORE---------------------------*\n");
            System.out.println("*--------------------HIGH RISK---------------------------*\n");
            js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //  System.out.println("Prospective Population Risk Stratification\n" );
            String HighOutpatientriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("High Outpatient Risk Spend:%s\n", HighOutpatientriskspend);

            String HighOutpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("High Outpatient Risk Member:%s\n", HighOutpatientRiskMember);

            String HighOutpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High percentage change member: %s\n", HighOutpatientpcmember);

            /* Medium RISK */

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("*--------------------Outpatient MEDIUM RISK---------------------------*\n");

            String MediumOutpatientriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Outpatient Medium Risk Spend:%s\n", MediumOutpatientriskspend);

            String MediumOutpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Outpatient Risk Member:%s\n", MediumOutpatientRiskMember);

            String MediumOutpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Outpatient Percentage memeber: %s\n", MediumOutpatientpcmember);

            /* Normal RISK */
            System.out.println("*--------------------Normal RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String NormalOutpatientRiskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Outpatient Risk Spend:%s\n", NormalOutpatientRiskspend);

            String NormalOutpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Outpatient Risk Member:%s\n", NormalOutpatientRiskMember);

            String NormalOutpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Outpatient Percentage memeber: %s\n", NormalOutpatientpcmember);

            /* LOW RISK */
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String LowOutpatientriskspend = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Risk Spend:%s\n", LowOutpatientriskspend);

            String LowOutpatientRiskMember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Outpatient Risk Member:%s\n", LowOutpatientRiskMember);

            String LowOutpatientpcmember = driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Outpatient Percentage memeber: %s\n", LowOutpatientpcmember);


            // For PMPM
            driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
            // js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String HighOutpatientRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High Outpatient Risk PMPM: %s\n", HighOutpatientRiskPMPM);

            /* Medium RISK */

            String MediumOutpatientRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Outpatient Risk PMPM: %s\n", MediumOutpatientRiskPMPM);

            /* Normal RISK */
            System.out.println("*--------------------Normal RISK---------------------------*\n");


            String NormalOutpatientRiskpmpm = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Risk PMPM: %s\n", NormalOutpatientRiskpmpm);

            /* LOW RISK */
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            String LowOutpatientRiskPMPM = driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Outpatient Risk PMPM: %s\n", LowOutpatientRiskPMPM);


        }
    }







