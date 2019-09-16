import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kazurayam.materials.MaterialRepository
import com.kazurayam.materials.MaterialRepositoryFactory

/**
 * webui/TC04_URL-based_filename
 * 
 * Open http://demoaut.katalon.com, take screenshot and save it into a file.
 * The location of the screenshot file is resolved by MaterialRespository.
 * The file name is derived from the URL.
 */

// open browser, navigate to a Katalon demo site, make sure the page is displayed
WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 768)
String urlString = 'http://demoaut.katalon.com'
WebUI.navigateToUrl(urlString)
WebUI.verifyElementPresent(
	findTestObject('webui/Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// prepare instance of MaterialRepository
Path materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')
// The directory 'Materials' will be created if not present by the MaterialRepository
MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)

// resolve the location of PNG file to save the screenshot
Path pngFile = mr.resolveScreenshotPath('TC04_URL-based_filename', new URL(urlString))
// --> <project dir>/Materials/_/_/TC04_URL-based_filename/http%3A%2F%2Fdemoaut.katalon.com.png
// The parent directories of the pngFile will be automatically created.
// The pngFile will be created with 0-bytes length.
WebUI.takeScreenshot(pngFile.toFile().toString())
// The pngFile will be stuffed with image bytes.

// make one more file under sub-directory
pngFile = mr.resolveScreenshotPath('TC04_URL-based_filename', 'subdir', new URL(urlString))
// --> <project dir>/Materials/_/_/TC04_URL-based_filename/subdir/http%3A%2F%2Fdemoaut.katalon.com.png
WebUI.takeScreenshot(pngFile.toFile().toString())

// Good Bye
WebUI.closeBrowser()