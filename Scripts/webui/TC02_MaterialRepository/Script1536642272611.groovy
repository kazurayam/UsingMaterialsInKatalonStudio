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
 * TC02_introducing_MaterialRespository
 *
 * Open http://demoaut.katalon.com, take screenshot and save it into a file.
 * The location of the screenshot file is resolved by MaterialRespository.
 */

// open browser, navigate to a Katalon demo site, make sure the page is displayed
WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 768)
WebUI.navigateToUrl('http://demoaut.katalon.com')
WebUI.verifyElementPresent(
	findTestObject('webui/Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// descide in which directory we will create a MaterialRepository
Path materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')

// create an instance of MaterialRepository
MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)

// resolve the location of a PNG file and save the screenshot into it
Path pngFile = mr.resolveMaterialPath('TC02_MaterialRepository', 'TC02_screenshot.png')
// --> pngFile will be <project dir>/Materials/_/_/<test case name>/<file name>
// -->           e.g., <project dir>/Materials/_/_/TC02_MaterialRepository/TC2_screenshot.png
// The pngFile will be created with 0-bytes length.

// take a screenshot of the page
WebUI.takeScreenshot(pngFile.toFile().toString())

WebUI.comment("saved the screenshot into ${pngFile.toAbsolutePath().toString()}")

// Good Bye
WebUI.closeBrowser()
