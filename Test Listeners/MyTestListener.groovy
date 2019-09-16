import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.materials.MaterialRepository
import com.kazurayam.materials.MaterialRepositoryFactory
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class MyTestListener {

	static Path materialsDir

	static {
		materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')
	}

	/**
	 *
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		// save the current Test Case ID into a GlobalVariable
		// in order to make it visible to the test case script when it run
		GlobalVariable.CURRENT_TESTCASE_ID = testCaseContext.getTestCaseId()

		// prepare an instance of MaterialRepository
		// The directory 'Materials' will be created if not present by the MaterialRepository
		// This is necessary for the case a Test Case is executed directly without being wrapped by a Test Suite.
		if (GlobalVariable.MATERIAL_REPOSITORY == null) {
			// If wrapped by a Test Suite, the handler method annotated with @BeforeTest suite will be called
			// and it will instantiate a MaterialRepository and store it into GlobalVariable. Therefore
			// we check if the GlobalVariable is null or not. We will instantiate new one
			// only when the GlobalVariable is null.
			MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)
			GlobalVariable.MATERIAL_REPOSITORY = mr
		}
	}

	/**
	 *
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		// prepare instance of MaterialRepository
		// The directory '<project dir>/Materials' will be created if not present
		// by the constructor of MaterialRepository
		MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)

		// Find out the Test Suite ID
		String testSuiteId = testSuiteContext.getTestSuiteId()
		WebUI.comment(">>> testSuiteId=${testSuiteId}")   // e.g. 'Test Suites/TS07_visit a web site'

		// Find out the Test Suite Timestamp
		Path reportDir = Paths.get(RunConfiguration.getReportFolder())
		String testSuiteTimestamp = reportDir.getFileName().toString()
		WebUI.comment(">>> testSuiteTimestamp=${testSuiteTimestamp}")    // e.g. '20180618_165141'

		// inform the MaterialRespository of the current Test Suite
		mr.markAsCurrent(testSuiteId, testSuiteTimestamp)
		
		// save the instance into GlobalVariable so that it is visible
		// for all test cases activated by the Test Suite
		GlobalVariable.MATERIAL_REPOSITORY = mr
	}

}
