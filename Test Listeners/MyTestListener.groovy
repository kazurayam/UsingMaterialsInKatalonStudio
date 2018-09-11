import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.materials.MaterialRepository
import com.kazurayam.materials.MaterialRepositoryFactory
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable as GlobalVariable

class MyTestListener {
	
	static Path materialsDir
	
	static {
		materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')
	}
	
	/**
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		GlobalVariable.CURRENT_TESTCASE_ID = testCaseContext.getTestCaseId()
		// prepare instance of MaterialRepository
		// The directory 'Materials' will be created if not present by the MaterialRepository
		if (GlobalVariable.MATERIAL_REPOSITORY == null) {
			MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)
			GlobalVariable.MATERIAL_REPOSITORY = mr
		}
	}

	/**
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		// prepare instance of MaterialRepository
		// The directory 'Materials' will be created if not present by the MaterialRepository
		MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)
		
		// Find out the Test Suite ID and Test Suite Timestamp
		String testSuiteId = testSuiteContext.getTestSuiteId()
		Path reportDir = Paths.get(RunConfiguration.getReportFolder())
		String testSuiteTimestamp = reportDir.getFileName().toString()    // e.g., '20180618_165141'
		
		// tell the MaterialRespository of the current Test Suite
		mr.putCurrentTestSuite(testSuiteId, testSuiteTimestamp)
		
		// save the instance into GlobalVariable so that it is available 
		// to all test cases activated by the Test Suite
		GlobalVariable.MATERIAL_REPOSITORY = mr
	}

}