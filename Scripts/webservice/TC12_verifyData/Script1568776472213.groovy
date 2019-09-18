import java.nio.file.Path

import com.kazurayam.ksbackyard.Assert
import com.kazurayam.materials.MaterialRepository

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable


// get the reference to the MaterialRepository objected created by TestListener
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// resolve path of files to store the JSON data
Path dataPath = (Path)GlobalVariable.dataPath

// read data from a file under the Materials directory
String json = dataPath.toFile().getText("utf-8")
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


// parse the JSON text
def data = new JsonSlurper().parseText(json)

// Verify the responded data

// verify data using Groovy's assert statement
assert data.message == 'accurate'
assert data.cod == '200'

// verify data using com.kazurayam.ksbackyard.Assert class
Assert.assertEquals("expected data.count to be 3 but was ${data.count}",
	3,
	data.count)

Assert.assertEquals("expected data.list[0].id to be 2641549 but was ${data.list[0].id}",
	2641549,
	data.list[0].id)

Assert.assertEquals("expected data.list[0].name to be Newtonhill but was ${data.list[0].name}",
	'Newtonhill',
	data.list[0].name)