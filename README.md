# Voss
Voss Assessment - Siduduzo

## Prerequisites
1. Assuming you have Java installed downloade eclipse IDE.
2. Install Mavem - useful link https://maven.apache.org/download.cgi
3. Install TestNG - https://testng.org/doc/eclipse.html

In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system. By default, this repo is configured to launch Firefox.
Chrome or Internet Explorer. Added a io.github.bonigarcia dependecy to POM xml file.

To change the browser Selenium will launch, edit Class : classLevelSetup src/test/java/siduduzo/voss/tests/BaseTest.javaas per below.


To run FireFox, 

WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();


To run Internet Explorer

WebDriverManager.iedriver().setup();
driver = new InternetExplorerDriver();

To run Chrome, 

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
 

To run Edge:

WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();



2. To run Test Suits - Expand /src/test/resources/TestSuites right click indivisual files choose Run As 1 testNG Suite to execute tests or 

right click AllTest xml file and Run As 1 testNG Suite to execute end to end test.
