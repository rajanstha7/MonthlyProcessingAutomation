# MonthlyProcessingAutomation
Selenium-JAVA
Author: Rajan Shrestha
@rajanstha7 
Link: https://github.com/rajanstha7/MonthlyProcessingAutomation

  
THIS is the project done for automating the monthly processing task for Zakipoint Health Care Clients

Specifications Needed:
1) Intellij Idea (Or any JAVA IDE such as Eclipse, STS )
2) This project is done in MAVEN. This is MAVEN JAVA PROJECT
3) In, maven usually all necesssary libraries can be imported using dependencies which you can see in pom.xml file of the project.
4) Some times the dependencies mightnot work properly so you can import jar files for neccessary libraries
 Some necessary jar files that could be needed to run the program :-
 1) Selenium-java jar file
 2) Junit
 3) Chromedriver
 4) testng jar file
 5) mysql connector jarfile
  You can download from mvnrepository.com > search (for example Junit)> in files YOu can find jar file option as well

  How to import the jar file in Maven Project:-
  a) Select the project first (for eg. click the project name here monthlyprocessing)
  b) click File at top of intellij (left top)
  c) CLick Project Structure (Ctrl + Alt+ Shift + S)
  d) Choose libraries option from menu
  e) You can see + sign in right then click that option
  f) Select Java option
  g) Browse he jarfiles where you have downloaded and click to apply and then ok

  All other necessary libraries are imported via dependencies that are kept in pom.xml you can simply copy the dependencies code and paste on your pom.xml and refresh sothat all your libraries gets installed

ERRORS INFO:
1) Some Errors might come after compalation is successfully done
    a) "Elements cannot be found" located by xpath, css -> This error usually occurs if the content is not displayed properly or there is lag in server to locate the element
        Elements are not loaded properly. You can use wait keyword sothat content are loaded properly.
    b) "Cannot be clickable at point(,)"-> This error occur usually if you try to fetch the data that are located beyond your desktop apperance means if you need to scroll down to locate tat element
           So, in this case you can use scroll keyword with appropriate coordinate for eg.(0, 500) . so that the websites scroll down to respected position where your desired element is placed in the website
           Use scroll and then wait keyword . This might works well.

     NOTE: THIS IS MOST

     a) I have erased my ID and password, db username, password for confedential in the above java-files-code.
     b) You just put your authorized username and password by taking a glance where mentioned. I have provided comment at that section.
     c) Chrome driver.exe path also should be provided in the above JAVA code. SO downlaod and provide your directory where you have downloaded or kept chromedriver.exe file

     Thank YOu !!!
     RAJAN SHRESTHA
© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About

