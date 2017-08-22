package ConfigFiles;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreencastCapturing {
	
	public static String timestamp;
	public static String systime;
	
	public static void Snapshot(WebDriver driver, String SnapshotName) throws IOException
	{
		File SourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, new File(Constants.DestPath+SnapshotName+" "+Timestamp()+".jpg"));
	} 
	
	public static String Timestamp()
	{
		Calendar cal=Calendar.getInstance();
		Date time=cal.getTime();
		timestamp=time.toString();
		systime=timestamp.replace(":", "-");
		return systime;
	}
}
