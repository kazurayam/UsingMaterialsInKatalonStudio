import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext

import internal.GlobalVariable as GlobalVariable

class MyTestListener {
	
	/**
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		GlobalVariable.CURRENT_TESTCASE_ID = testCaseContext.getTestCaseId()
	}

	/**
	 * @param testCaseContext related information of the executed test case.
	 *
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
	}
	 */

	/**
	 * @param testSuiteContext: related information of the executed test suite.
	 *
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
	}
	 */

	/**
	 * @param testSuiteContext: related information of the executed test suite.
	 *
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
	}
	 */
}