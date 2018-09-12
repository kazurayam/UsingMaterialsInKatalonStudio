import com.kazurayam.materials.MaterialRepository
import internal.GlobalVariable
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 
WebUI.callTestCase(findTestCase('Test Cases/TC07_visiting a web site'), [:])

// prepare instance of MaterialRepository
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// make ./Material/index.html file
mr.makeIndex()