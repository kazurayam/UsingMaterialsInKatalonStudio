import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor

import com.kazurayam.materials.MaterialRepository
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable as GlobalVariable

MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 768)

// open the target website
WebUI.navigateToUrl("http://${GlobalVariable.Hostname}/")

WebUI.verifyElementPresent(findTestObject('webui/Page_CuraHomepage/a_Make Appointment'),
		10, FailureHandling.STOP_ON_FAILURE)

Path png1 = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "1 CURA_Homepage.png")
WebUI.takeScreenshot(png1.toFile().toString())


// click the "a_Make Appointment" button to open the Login page
WebUI.click(findTestObject('webui/Page_CuraHomepage/a_Make Appointment'))

// make sure that we are transfered to the Login page
WebUI.verifyElementPresent(findTestObject('webui/Page_Login/button_Login'),
	10, FailureHandling.STOP_ON_FAILURE)

// type Username and Password into the fields
WebUI.setText(findTestObject('webui/Page_Login/input_username'), GlobalVariable.Username)
WebUI.setText(findTestObject('webui/Page_Login/input_password'), GlobalVariable.Password)

// takes Screenshot of the Login page
Path png2 = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "2 CURA_Login.png")
WebUI.takeScreenshot(png2.toFile().toString())

// click the "button_login"
WebUI.click(findTestObject('webui/Page_Login/button_Login'))

// make sure that we are transfered to the CuraAppointment page
WebUI.verifyElementPresent(findTestObject('webui/Page_CuraAppointment/button_Book Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// select Tokyo
WebUI.selectOptionByValue(findTestObject('webui/Page_CuraAppointment/select_Tokyo CURA Healthcare C'),
	'Hongkong CURA Healthcare Center',
	true)

// select hostpital readmission on
WebUI.click(findTestObject('webui/Page_CuraAppointment/input_hospital_readmission'))

// select medicated
WebUI.click(findTestObject('webui/Page_CuraAppointment/input_programs'))

// select the day 1 week later
def visitDate = LocalDateTime.now().plusWeeks(1)
def visitDateStr = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(visitDate)
WebUI.setText(findTestObject('webui/Page_CuraAppointment/input_visit_date'), visitDateStr)

// send ENTER to close the date picker dialog
WebUI.sendKeys(findTestObject('webui/Page_CuraAppointment/input_visit_date'), Keys.chord(Keys.ENTER))

// type comment in
WebUI.setText(findTestObject('webui/Page_CuraAppointment/textarea_comment'), 'This is a comment')

// takes Screenshot of the CURA Appointment page
Path png3 = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "3 CURA_Appointment.png")
WebUI.takeScreenshot(png3.toFile().toString())

// click the "Book Appointment" button
WebUI.click(findTestObject('webui/Page_CuraAppointment/button_Book Appointment'))


// make sure that we are transfered to the AppointmentConfirmation page
WebUI.verifyElementPresent(findTestObject('webui/Page_AppointmentConfirmation/a_Go to Homepage'),
	10, FailureHandling.STOP_ON_FAILURE)



// Now we will check if the appointment has been made correctly -----------------------

// check the facility
def facility = WebUI.getText(findTestObject('webui/Page_AppointmentConfirmation/p_facility'))
WebUI.verifyMatch(facility,
	'^(Tokyo|Hongkong|Seoul) CURA Healthcare Center$', true)

// check the readmission
def readmission = WebUI.getText(findTestObject('webui/Page_AppointmentConfirmation/p_hospital_readmission'))
WebUI.verifyMatch(readmission,
	'(Yes|No)', true)

// check the program
def program = WebUI.getText(findTestObject('webui/Page_AppointmentConfirmation/p_program'))
WebUI.verifyMatch(program,
	'(Medicare|Medicaid|None)', true)

// check the date
def visitDateStr2 = WebUI.getText(findTestObject('webui/Page_AppointmentConfirmation/p_visit_date'))
WebUI.verifyMatch(visitDateStr2,
	'[0-9]{2}/[0-9]{2}/[0-9]{4}',
	true, FailureHandling.CONTINUE_ON_FAILURE)
TemporalAccessor parsed = DateTimeFormatter.ofPattern('dd/MM/uuuu').parse(visitDateStr2)
LocalDateTime visitDate2 = LocalDate.from(parsed).atStartOfDay()
// the date should be in future
boolean isAfterNow = visitDate2.isAfter(LocalDateTime.now())
WebUI.verifyEqual(isAfterNow, true, FailureHandling.CONTINUE_ON_FAILURE)
// the date should not be Sunday
def dayOfWeek = DateTimeFormatter.ofPattern('E').withLocale(Locale.US).format(parsed)
WebUI.verifyNotEqual(dayOfWeek, 'Sun')

// check comment
def comment = WebUI.getText(findTestObject('webui/Page_AppointmentConfirmation/p_comment'))
if (comment != null) {
	WebUI.verifyLessThan(comment.length(), 400)
}

// takes Screenshot of the Appointment Confirmation page
Path png4 = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "4 CURA_AppointmentConfirmation.png")
WebUI.takeScreenshot(png4.toFile().toString())

// click the "Go to Homepage" button
WebUI.click(findTestObject('webui/Page_AppointmentConfirmation/a_Go to Homepage'))


// make sure we are transfered to the CuraHomepage
WebUI.verifyElementPresent(findTestObject('webui/Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// takes Screenshot of the Homepage revisited
Path png5 = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "5 CURA_Homepage_revisited.png")
WebUI.takeScreenshot(png5.toFile().toString())

// Bye
WebUI.closeBrowser()
