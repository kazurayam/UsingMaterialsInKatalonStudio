import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kazurayam.materials.MaterialRepository
import com.kazurayam.materials.MaterialRepositoryFactory

import internal.GlobalVariable

/**
 * webui/TC05_GlobalVariable.CURRENT_TESTCASE_ID
 *
 * Open http://demoaut.katalon.com, take screenshot and save it into a file.
 * The location of the screenshot file is resolved by MaterialRespository.
 * 
 * GlobalVariable.CURRENT_TESTCASE_ID is introduced.
 * A method annotated with @BeforeTestCase in the MyTestListener set its value.
 * TC03 reads the GlobalVariable.CURRENT_TESTCASE_ID to pass to the resolve
 */

// open browser, navigate to a Katalon demo site, make sure the page is displayed
WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 768)
WebUI.navigateToUrl('http://demoaut.katalon.com')
WebUI.verifyElementPresent(
	findTestObject('webui/Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// prepare instance of MaterialRepository
Path materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')
// The directory 'Materials' will be created if not present by the MaterialRepository
MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)

// resolve the location of PNG file to save the screenshot
String testCaseId = (String)GlobalVariable.CURRENT_TESTCASE_ID 
assert testCaseId != null
assert testCaseId.length() > 0
// get the testCaseId from GlobalVariable.CURRENT_TESTCASE_ID which is set by MyTestListener
Path pngFile = mr.resolveMaterialPath(testCaseId, 'TC05_screenshot.png')
// --> pngFile will be <project dir>/Materials/_/_/<test case name>/<file name>
// -->           e.g., <project dir>/Materials/_/_/TC05_GlobalVariable.CURRENT_TESTCASE_ID/TC05_screenshot.png

// take a screenshot of the page
WebUI.takeScreenshot(pngFile.toFile().toString())

WebUI.comment("saved the screenshot into ${pngFile.toAbsolutePath().toString()}")

// Good Bye
WebUI.closeBrowser()