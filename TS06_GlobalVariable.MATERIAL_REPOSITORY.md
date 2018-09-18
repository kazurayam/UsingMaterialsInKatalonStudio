## Test Suite `TS06_GlobalVariable.MATERIAL_REPOSITORY`

Until `TC05...` we executed indivisual Test Cases.
As of here, we will wrap each test cases with a test suite,
and will execute the test suite, rather than executing test cases.
Why we do so? What is the benefit of using Test Suites? --- I will exmplain it later.

### source

Here we introduce a GlobalVariable named `MATERIAL_REPOSITORY`.
![MATERIAL_REPOSITORY](docs/images/GlobalVariable.MATERIAL_REPOSITORY)

Please make sure that the `MATERIAL_REPOSITORY` is declared as type of Null which means an instance of `java.lang.Object`. `MASTERAL_REPOSITORY` must not be declared as other types such as `String`.

In the Test Listener [`Test Listeners/MyTestListener.groovy`](Test%20Listeners/MyTestListener.groovy) we will create an instance of `com.kazurayam.materials.Material` and store it into the GlobalVariable. In the method annotated with `@BeforeTestSuite` we do this:
```
@BeforeTestSuite
def beforeTestSuite(TestSuiteContext testSuiteContext) {
    // prepare instance of MaterialRepository
    // The directory 'Materials' will be created if not present by the MaterialRepository
    MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)

    // Find out the Test Suite ID
    String testSuiteId = testSuiteContext.getTestSuiteId()

    // Find out the Test Suite Timestamp
    Path reportDir = Paths.get(RunConfiguration.getReportFolder())
    String testSuiteTimestamp = reportDir.getFileName().toString()
    // e.g. '20180618_165141'

    // inform the MaterialRespository of the current Test Suite
    mr.putCurrentTestSuite(testSuiteId, testSuiteTimestamp)

    // save the instance into GlobalVariable so that it is visible
    // for all test cases activated by the Test Suite
    GlobalVariable.MATERIAL_REPOSITORY = mr
```

Also in the method annotated with `@BeforeTestCase` we do this:
`@BeforeTestCase
def beforeTestCase(TestCaseContext testCaseContext) {
    ...
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
```

Now the Test case [`TC06_GlobalVariable.MATERIAL_REPOSITORY`](Scripts/TC06_GlobalVariable.MATERIAL_REPOSITORY/Script1536640238920.groovy) refers to the `GlobalVariable.MATERIAL_REPOSITORY` like this:
```
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null
...
Path pngFile = mr.resolveMaterialPath(testCaseId, 'TC06_screenshot.png')

```

The [`Test Listener/MyTestListener`] now holds centralized control over instantiating
the `com.kazurayam.materials.MaterialRepository` object. You should no longer repeat


### output

```
$ cd UsingMaterialsInKatalonStudio
$ tree Materials
Materials
└── _
    └── _
        └── TC06_GlobalVariable.MATERIAL_REPOSITORY
            └── TC06_screenshot.png
```
