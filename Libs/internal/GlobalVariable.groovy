package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : Method annotated with @BeforeTestCase in TestListener should set the value
Profile development : Method annotated with @BeforeTestCase in TestListener should set the value
Profile production : Method annotated with @BeforeTestCase in TestListener should set the value</p>
     */
    public static Object CURRENT_TESTCASE_ID
     
    /**
     * <p>Profile default : instance of com.kazurayam.materials.MaterialRepository
Profile development : instance of com.kazurayam.materials.MaterialRepository
Profile production : instance of com.kazurayam.materials.MaterialRepository</p>
     */
    public static Object MATERIAL_REPOSITORY
     
    /**
     * <p></p>
     */
    public static Object Hostname
     
    /**
     * <p></p>
     */
    public static Object Username
     
    /**
     * <p></p>
     */
    public static Object Password
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['CURRENT_TESTCASE_ID' : '', 'MATERIAL_REPOSITORY' : null, 'Hostname' : 'demoaut.katalon.com', 'Username' : 'John Doe', 'Password' : 'ThisIsNotAPassword'])
        allVariables.put('development', allVariables['default'] + ['CURRENT_TESTCASE_ID' : '', 'MATERIAL_REPOSITORY' : null, 'Hostname' : 'demoaut-mimic.kazurayam.com', 'Username' : 'John Doe', 'Password' : 'ThisIsNotAPassword'])
        allVariables.put('production', allVariables['default'] + ['CURRENT_TESTCASE_ID' : '', 'MATERIAL_REPOSITORY' : null, 'Hostname' : 'demoaut.katalon.com', 'Username' : 'John Doe', 'Password' : 'ThisIsNotAPassword'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        CURRENT_TESTCASE_ID = selectedVariables['CURRENT_TESTCASE_ID']
        MATERIAL_REPOSITORY = selectedVariables['MATERIAL_REPOSITORY']
        Hostname = selectedVariables['Hostname']
        Username = selectedVariables['Username']
        Password = selectedVariables['Password']
        
    }
}
