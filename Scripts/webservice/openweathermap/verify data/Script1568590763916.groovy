import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path

import com.kazurayam.materials.MaterialRepository
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable


// get the reference to the MaterialRepository objected created by TestListener
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// resolve path of files to store the JSON data
Path dataPath = (Path)GlobalVariable.dataPath

// read data from a file under the Materials directory
String json = dataPath.toFile().text
def data = new JsonSlurper().parseText(json)

// Verify the responded JSON data
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
assert data.message == 'accurate'
assert data.cod == '200'
assert data.count == 3
assert data.list[0].id == 2641549
assert data.list[0].name == 'Newtonhill'
