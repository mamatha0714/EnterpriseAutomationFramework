package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverFactory;



public class ScreenshotUtil {
	
	public static byte[] captureForAllure() {

	    return ((TakesScreenshot)
	            DriverFactory.getDriver())
	            .getScreenshotAs(
	                    OutputType.BYTES);
	}

	/*
	 * public static String capture(String testName) {
	 * 
	 * try {
	 * 
	 * File source = ((TakesScreenshot) DriverFactory.getDriver()) .getScreenshotAs(
	 * OutputType.FILE);
	 * 
	 * String destination = "screenshots/" + testName + ".png";
	 * 
	 * Files.copy( source.toPath(), new File(destination).toPath(),
	 * StandardCopyOption.REPLACE_EXISTING);
	 * 
	 * return destination;
	 * 
	 * } catch(Exception e) {
	 * 
	 * return null; } }
	 */
}