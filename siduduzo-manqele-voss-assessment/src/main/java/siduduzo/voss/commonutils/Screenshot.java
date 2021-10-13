package siduduzo.voss.commonutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    WebDriver driver;

    public Screenshot(WebDriver _driver) {
        this.driver = _driver;
    }

    public void takeSnapshot(String imageName) throws IOException {
    TakesScreenshot scrShot = ((TakesScreenshot)driver);
    File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
    String screenshotPahth = this.generateScreenshotPahth(imageName);  
    File destFile = new File(screenshotPahth);

    FileUtils.copyFile(scrFile, destFile);
    }

    private String generateScreenshotPahth (String imageName) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        String strDate = dateFormat.format(date);
        strDate = strDate.replace(" ", "-").replace(":", "-");
        Path path = Paths.get("C:", "Screenshots", strDate, imageName + ".png");
        String screenshotPahth = path.toString();

        return screenshotPahth;
    }
}
