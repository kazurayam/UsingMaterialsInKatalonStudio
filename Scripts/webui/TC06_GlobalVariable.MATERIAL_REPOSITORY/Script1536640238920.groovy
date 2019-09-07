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
 * TC06_GlobalVariable.MATERIAL_REPOSITORY
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
// it is necessary to explicitly cast the type from java.lang.Object to
// com.kazurayam.materials.MaterialRepository
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// resolve the location of PNG file to save the screenshot
// Again it is necessary to explicitly cast the type from java.lang.Object
// to java.lang.String
String testCaseId = (String)GlobalVariable.CURRENT_TESTCASE_ID
assert testCaseId != null
// get the testCaseId from GlobalVariable.CURRENT_TESTCASE_ID which is set by MyTestListener
Path pngFile = mr.resolveMaterialPath(testCaseId, 'TC06_screenshot.png')
/*
 * When the Test Case selected by man and executed, then pngFile will be
 * <project dir>/Materials/_/_/<test case name>/<file name>
 * for example ./Materials/_/_/TC06_GlobalVariable.MATERIAL_REPOSITORY/TC06_screenshot.png
 *
 * When the Test Suite TS06 is selected by man, by which the Test Case TC06 is called, then pngFile will be
 * <project dir>/Materials/<Test Suite name>/<Test Suite timestamp>/<Test Case name>/<filename>
 * for example ./Materials/TS06/20180911_154454/TC06_GlobalVariable.MATERIAL_REPOSITORY/TC06_screenshot.png
 *
 * The @BeforeTestSuite-annotated method of the TestListener is supposed to call
 * MaterialRepsitory#putCurrentTestSuite(String, String) method in order to mark which Test Suite is current.
 * <pre>
 * // tell the MaterialRespository of the current Test Suite
 * mr.putCurrentTestSuite(testSuiteId, testSuiteTimestamp)
 * </pre>
 */

// take a screenshot of the page
WebUI.takeScreenshot(pngFile.toFile().toString())

WebUI.comment("saved the screenshot into ${pngFile.toAbsolutePath().toString()}")

// Good Bye
WebUI.closeBrowser()
