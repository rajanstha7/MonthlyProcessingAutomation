package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ERActive {

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


            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'ER')]")).click();

            System.out.println("For Dashboard Section");

            //Annual Spend
            String ERactiveAnnualSpend= driver.findElement(By.xpath("//h4[contains(text(),'Annual Spend')]//following-sibling::span")).getText();
            System.out.format("ER Annual Spend : %s\n",ERactiveAnnualSpend);

            System.out.println("*----------------ER Member Count---------------------------*");
            String ERactiveMemberCount=driver.findElement(By.xpath("//h4[contains(text(),'Member Count')]//following-sibling::span[@class='number']")).getText();
            System.out.format("ER Member Count : %s \n",ERactiveMemberCount);

            System.out.println("*----------------ER Current Risk---------------------------*");
            String ERactiveCurrentRisk=  driver.findElement(By.xpath("//h4[contains(text(),'Current Risk')]//following-sibling::span[@class='number']")).getText();
            System.out.format("ER Current Risk: %s\n",ERactiveCurrentRisk);
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
            System.out.println("*----------------ER active PMPM---------------------------*");
            //  String ERPMPM=driver.findElement(By.xpath("//g[@class='svgtooltip']//li[1]")).getText();
            //System.out.format("ER PMPM : %s\n",ERPMPM);

            String ReportingPeriod=driver.findElement(By.xpath("//span[contains(text(),'Reporting Period')]//following-sibling::span")).getText();
            System.out.format("Reporting Period  : %s\n",ReportingPeriod);

            // String AllConditionServiceSpend= driver.findElement(By.xpath("//div[@class='tab-pane active']//h3[@class='entry-title'][contains(text(),'Service Spend')]")).getText();
            //  System.out.println(AllConditionServiceSpend);


            js.executeScript("window.scrollBy(0,180)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[contains(text(),'Demographics')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("All Pharmacy Population : Age");
            // driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]")).click();
            //div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Members')]
            js.executeScript("window.scrollBy(0,500)");



            System.out.println("All ER Population : Age");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String ERactiveSpendAgeASpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Spend=%s\n", ERactiveSpendAgeASpend);

            String ERactiveSpendAgeAmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("0-19 Member Count=%s\n", ERactiveSpendAgeAmember);

            String ERactiveSpendAgeBSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Spend=%s\n", ERactiveSpendAgeBSpend);

            String ERactiveSpendAgeBmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("20-39 Member Count=%s\n", ERactiveSpendAgeBmember);

            String ERactiveSpendAgeCSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Spend=%s\n", ERactiveSpendAgeCSpend);

            String ERactiveSpendAgeCmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("40-59 Member Count=%s\n", ERactiveSpendAgeCmember);


            String ERactiveSpendAgeDSpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Spend=%s\n", ERactiveSpendAgeDSpend);
            String ERactiveSpendAgeDmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("60-64 Member Count=%s\n", ERactiveSpendAgeDmember);

            String ERactiveSpendAgeESpend = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Spend=%s\n", ERactiveSpendAgeESpend);
            String ERactiveSpendAgeEmember = driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][6]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("65+ Member Count=%s\n", ERactiveSpendAgeEmember);




            System.out.println("*-------------------For Demoraphic with Gender------------------------------*");
            String ERactiveMaleSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("ERactiveMale Spend Pharmacy=%s\n",ERactiveMaleSpendPharmacy);
            String ERactiveMaleMembersPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("ERactiveMale Members Count=%s\n",ERactiveMaleMembersPharmacy);

            String ERactiveFemaleSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("ERactiveFemale Spend=%s\n",ERactiveFemaleSpendPharmacy);
            String ERactiveFemaleMembersPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("ERactiveFemale Members Count=%s\n",ERactiveFemaleMembersPharmacy);

            String USpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Spend=%s\n",USpendPharmacy);
            String UmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Unknown Member Count=%s\n",UmemberPharmacy);




            System.out.println("*----------------------- For Demographic with Relationship---------------------------------------------*");
            System.out.println("*------------------------------Relationship---------------------------------------*");


            String RelationshipNameA=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameA);
            String EROthersRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Spend=%s\n",EROthersRelSpendPharmacy);
            String EROthersRelmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameA+" Relationship Member Count=%s\n",EROthersRelmemberPharmacy);

            String RelationshipNameB=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameB);
            String ERactiveEmoloyeeRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+"Relationship Spend=%s\n",ERactiveEmoloyeeRelSpendPharmacy);
            String ERactiveEmoloyeeRelmemberPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameB+"Relationship Member=%s\n",ERactiveEmoloyeeRelmemberPharmacy);

            String RelationshipNameC=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();


            System.out.println(RelationshipNameC);
            String ERactiveSpouseRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Spend=%s\n",ERactiveSpouseRelSpendPharmacy);
            String ERactiveSpouseRelMemberCountPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameC+" Relationship Member Count=%s\n",ERactiveSpouseRelMemberCountPharmacy);

/*
            String RelationshipNameD=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();
            System.out.println(RelationshipNameD);
            String ERactiveDependentRelSpendPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Spend=%s\n",ERactiveDependentRelSpendPharmacy);
            String ERactiveDependentRelmemberCountPharmacy=driver.findElement(By.xpath("//body/div[@id='aap']/div[@id='body']/div[@id='page']/div[@id='content']/div[@id='app']/section[@class='disease-wrapper']/div[@class='container']/div[@class='disease-item disease-tabs']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='demographics']/div[@class='tab-pane active']/div[@class='row']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format(RelationshipNameD+" Relationship Member Count=%s\n",ERactiveDependentRelmemberCountPharmacy);
*/





            //*--------------------------------------UTILIZATION-----------------------------------
            // js.executeScript("window.scrollBy(0,200)");


            System.out.println("*-------------------------Utilization-----------------------*");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();

            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'ER')]")).click();
            //js.executeScript("window.scrollBy(0,-1000)");
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();


            //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // driver.findElement(By.xpath("//ul[@class='nav nav-pills tabs-wrapper']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();

            String ERactiveClaimsbyprocedure=driver.findElement(By.xpath("//div[@id='z5erutbc025']//div[@class='bottom-placing']//div//p[contains(text(),'Total Procedure Spend')]")).getText();
            //System.out.format("ER claims By Procedure: %s",ERactiveClaimsbyprocedure);
            String word = "Total Procedure Spend";
            String ERactiveClaimsbyProcedure = ERactiveClaimsbyprocedure.replace(word, "");
            System.out.format("ER claims By Procedure: %s",ERactiveClaimsbyProcedure);
            //ERactiveClaimsbyprocedure = removeWord(ERactiveClaimsbyprocedure,word);

            String TotalAvoidableeRUse=driver.findElement(By.xpath("//div[@id='z5erutbc035']//div[@class='bottom-placing']//div//p[contains(text(),'Total Avoidable ER Spend')]")).getText();
            String wordremove="Total Avoidable ER Spend";
            String  TotalAvoidableERUse = TotalAvoidableeRUse.replace(wordremove,"");
            System.out.format("Total Avoidable ER Use: %s",TotalAvoidableERUse);

            String ERVoneTotalspend=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
            String wordremove1="Total ER Spend";
            String  ERVoneTotalSpend = ERVoneTotalspend.replace(wordremove1,"");

            System.out.format("Er Visit 1 or more total spend:%s",ERVoneTotalSpend);
            String ERVoneTotalmember=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
            String word1="Total Members";
            String  ERVoneTotalMember = ERVoneTotalmember.replace(word1,"");
            System.out.format("ER Visit one or more Total Member=%s\n",ERVoneTotalMember);

            // 2 or more ER visit last month

            driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//option[contains(text(),'2 or more')]")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String TotalERactiveSpendTOM= driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
            String wordremove2="Total ER Spend";
            String  TotalERActiveSpendTOM = TotalERactiveSpendTOM.replace(wordremove2,"");
            System.out.format("Total ER spend 2 or more last month=%s",TotalERActiveSpendTOM);

            String TotalmemeberTOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
            String wordremove3="Total Members";
            String  TotalMemeberTOM = TotalmemeberTOM.replace(wordremove3,"");
            System.out.format("Total ER Memeber 2 or more last month=%s\n",TotalMemeberTOM);

            // 3 or more last month
            driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//select[@class='form-control px-2 mx-2']")).click();
            driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//option[contains(text(),'3 or more')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String TotalERactiveSpendThOM= driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
            String wordremove4="Total ER Spend";
            String  TotalERActiveSpendThOM = TotalERactiveSpendThOM.replace(wordremove4,"");

            System.out.format("Total ER spend 3 or more last month=%s",TotalERActiveSpendThOM);
            String TotalmemberThOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
            String wordremove5="Total Members";
            String  TotalMemberTOM = TotalmemberThOM.replace(wordremove5,"");
            System.out.format("Total ER Member 3 or more last month=%s\n",TotalMemberTOM);

            // 4 or more last month
        /*

        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//select[@class='form-control px-2 mx-2']")).click();
        driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[@class='col-6']//div[@class='disease-box zph-tabs d-flex flex-column']//div//option[contains(text(),'4 or more')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String TotalERactiveSpendFOM= driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total ER Spend')]")).getText();
        String wordremove6="Total ER Spend";
        String  TotalERActiveSpendFOM = TotalERactiveSpendFOM.replace(wordremove6,"");
        System.out.format("Total ER spend 4 or more last month=%s",TotalERActiveSpendFOM);
        String TotalmemberFOM=driver.findElement(By.xpath("//div[@id='z5erutbc065']//div[@class='bottom-placing']//div//p[contains(text(),'Total Members')]")).getText();
         String wordremove7="Total Members";
        String  TotalMemberFOM = TotalmemberFOM.replace(wordremove7,"");
        System.out.format("Total ER spend 4 or more last month=%s",TotalMemberFOM);

*/



            //driver.findElement(By.xpath("")).getText();
            //driver.findElement(By.xpath("")).getText();

            System.out.println("*-------------Catastrophic Claims------------------*\n");
            System.out.println("Medical Catestrophic\n");
            String catestrophicmedERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
            System.out.println(catestrophicmedERactive);
            String MedCatestrophicUtilizationERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Med-Catestrophic-Utilization-Per-1000:%s\n",MedCatestrophicUtilizationERactive);

            String MedCatestrophicmemberERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medical-Catestrophic-member Count:%s\n",MedCatestrophicmemberERactive);

            String MedCatestrophicperchangeERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("MedCatestrophic percentage change :%s\n",MedCatestrophicperchangeERactive);


            System.out.println("Pharmacy Catestrophic\n");
            String catestrophicphrERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][2]")).getText();
            System.out.println(catestrophicphrERactive);
            String PhrCatestrophicUtilizationERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Pharmacy-Catestrophic-Utilization-Per-1000:  %s\n",PhrCatestrophicUtilizationERactive);

            String PhrCatestrophicmemberERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Pharmacy-Catestrophic-member Count:%s\n",PhrCatestrophicmemberERactive);

            String PhrCatestrophicperchangeERactive=driver.findElement(By.xpath("//div[@class='service-spend-item']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("MedCatestrophic percentage change :%s\n",PhrCatestrophicperchangeERactive);




            js.executeScript("window.scrollBy(0,1000)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("*-------------active ER USe and Urgent Care------------------*\n");
            System.out.println("Services:          Spend      Members\n");
            String NoPC=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();

            //driver.findElement(By.xpath("")).getText();
            System.out.println(NoPC);
            String NoPCSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();

            System.out.format("No Preventive Care Spend :%s\n",NoPCSpend);

            String NoPCMembers=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("No preventive Care Member Count:%s\n",NoPCMembers);

            System.out.println("Services:          Spend      Members\n");
            String UCERactive=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();

            //driver.findElement(By.xpath("")).getText();
            System.out.println(UCERactive);
            String UCERactiveSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();

            System.out.format("Urgent Care Spend :%s\n",UCERactiveSpend);

            String UCERactiveMembers=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Urgent Care Member Count:%s\n",UCERactiveMembers);

            System.out.println("Services:      Spend      Members\n");
            String ERactiveWChronic=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][1]/*[name()='tspan'][1]")).getText();

            System.out.println(ERactiveWChronic);
            String ERactiveChronicSpend=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();

            System.out.format("ER with Chronic Condition Spend :%s\n",ERactiveChronicSpend);

            String ERactiveChronicMemebers=driver.findElement(By.xpath("//div[@class='disease-box age-box']//div[@class='svg-data']//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("ER with Chronic Condition Member Count:%s\n",ERactiveChronicMemebers);


            //   js.executeScript("window.scrollBy(0,700)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@class='disease-box age-box']//a[@class='nav-link inactive'][contains(text(),'Utilization')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //   driver.findElement(By.xpath("//div[@id='Utilization']//div[@class='row']//div[1]//div[1]//ul[1]//li[2]//a[1]")).click();
            String ClaimsbyproTotalUtilizationperKERactive= driver.findElement(By.xpath("//div[@id='z5erutbc026']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            System.out.format("Claims By PRocedure Total Utilization Per 1000 : %s",ClaimsbyproTotalUtilizationperKERactive);
            String AvoidableERactiveTotalUtil= driver.findElement(By.xpath("//div[@id='z5erutbc036']//div[@class='bottom-placing']//div//p[contains(text(),'Total Utilization per 1000')]")).getText();
            System.out.format("Avoidable ER Use Total Utilization Per 1000 : %s",AvoidableERactiveTotalUtil);


            //--------------------------------------Wellness-----------------------------------
            // js.executeScript("window.scrollBy(0,200)");



            // ER  Risk SCORE
            // HIGH RISK
            System.out.println("*--------------------ER active RISK SCORE---------------------------*\n");
            System.out.println("*-------------------------Wellness-----------------------*");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@id='dropdownMenuButton']//img")).click();

            //select ER from quick links
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(text(),'ER')]")).click();
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[contains(text(),'Wellness')]")).click();

            js.executeScript("window.scrollBy(0,200)");
            System.out.println("*--------------------ER RISK SCORE---------------------------*\n");

            System.out.println("*--------------------HIGH RISK---------------------------*\n");
            js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //  System.out.println("Prospective Population Risk Stratification\n" );
            String HighERactiveriskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("High Risk Spend:%s\n",HighERactiveriskspend);

            String HighERactiveRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("High Risk Member:%s\n",HighERactiveRiskMember);

            String Highpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High percentage change member: %s\n",Highpcmember);

            // Medium RISK //

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("*--------------------MEDIUM RISK---------------------------*\n");
            //System.out.println("Prospective Population Risk Stratification\n" );
            String MediumERactiveriskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Risk Spend:%s\n",MediumERactiveriskspend);

            String MediumERactiveRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Risk Member:%s\n",MediumERactiveRiskMember);

            String Mediumpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Percenage memeber: %s\n",Mediumpcmember);

            // Normal RISK //
            System.out.println("*--------------------Normal RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //System.out.println("Prospective Population Risk Stratification\n" );
            String NormalERactiveRiskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Risk Spend:%s\n",NormalERactiveRiskspend);

            String NormalERactiveRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Risk Member:%s\n",NormalERactiveRiskMember);

            String Normalpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Percentage memeber: %s\n",Normalpcmember);

            // LOW RISK
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //System.out.println("Prospective Population Risk Stratification\n" );
            String LowERactiveriskspend=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][2]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Risk Spend:%s\n",LowERactiveriskspend);

            String LowERRiskMember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][3]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Risk Member:%s\n",LowERRiskMember);

            String Lowpcmember=driver.findElement(By.xpath("//div[@id='Wellness']//div[@class='tab-content']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Percentage memeber: %s\n",Lowpcmember);




            // For PMPM
            driver.findElement(By.xpath("//div[@id='Wellness']//a[@class='nav-link inactive'][contains(text(),'Pmpm')]")).click();
            // js.executeScript("window.scrollBy(0,500)");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String HighERactiveRiskPMPM=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][2]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("High Risk PMPM: %s\n",HighERactiveRiskPMPM);


            String MediumERactiveRiskPMPM=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Medium Risk PMPM: %s\n",MediumERactiveRiskPMPM);

            // Normal RISK
            System.out.println("*--------------------Normal RISK---------------------------*\n");


            String NormalERactiveRiskpmpm=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][4]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Normal Risk PMPM: %s\n",NormalERactiveRiskpmpm);

            // LOW RISK
            System.out.println("*--------------------Low RISK---------------------------*\n");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            String LowERactiveRiskPMPM=driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//div[2]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@class,'table row-')]//*[name()='g'][5]/*[name()='text'][1]/*[name()='tspan'][4]/*[name()='tspan'][1]")).getText();
            System.out.format("Low Risk PMPM: %s\n",LowERactiveRiskPMPM);


        }

    }





