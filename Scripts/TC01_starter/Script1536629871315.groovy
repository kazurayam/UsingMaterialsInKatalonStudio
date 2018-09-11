import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * TC01_starter
 * 
 * Open http://demoaut.katalon.com, take screenshot and save it into a file.
 * 
 * Here we use Java 8 features extensively:
 * - java.nio.file.Path
 * - java.nio.file.Paths
 * - java.nio.file.Files
 */

// open browser, navigate to a Katalon demo site, make sure the page is displayed
WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 768)
WebUI.navigateToUrl('http://demoaut.katalon.com')
WebUI.verifyElementPresent(
	findTestObject('Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// resolve the location of PNG file to save the screenshot using Java 8 Path
Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path tmpDir = projectDir.resolve('tmp')
Files.createDirectories(tmpDir)
Path pngFile = tmpDir.resolve('TC01_screenshot.png')

// take a screenshot of the page
WebUI.takeScreenshot(pngFile.toFile().toString())

WebUI.comment("saved the screenshot into ${pngFile.toAbsolutePath().toString()}")

// Good Bye
WebUI.closeBrowser()