import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path

import com.kazurayam.materials.MaterialRepository
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import internal.GlobalVariable as GlobalVariable


// Send the request to https://openweathermap.org/current#current_JSON and get the response
response = WS.sendRequest(findTestObject('webservice/openweathermap/Call for several city IDs'))

// Verify the response status
WS.verifyResponseStatusCode(response, 200)

// Verify the responded data
/*
{
	"message":"accurate",
	"cod":"200",
	"count":3,
	"list":[
	  {
		"id":2641549,
		"name":"Newtonhill",
		...
 */
WS.verifyElementPropertyValue(response, 'message', 'accurate')
WS.verifyElementPropertyValue(response, 'cod', '200')
WS.verifyElementPropertyValue(response, 'count', '3')
WS.verifyElementPropertyValue(response, 'list[0].id', '2641549')
WS.verifyElementPropertyValue(response, 'list[0].name', 'Newtonhill')

// get the reference to the MaterialRepository objected created by TestListener
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// resolve path of files to store the JSON data
Path data = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, 'weatherData.json')

// remember the path
GlobalVariable.dataPath = data

// save the JSON data into a file under the Materials directory with specifying encoding
data.toFile().write(JsonOutput.prettyPrint(response.getResponseText()),"utf-8")
