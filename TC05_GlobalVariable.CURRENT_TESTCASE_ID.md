## Test Case `TC05_GlobalVariable.CURRENT_TESTCASE_ID`

### source and description

Here we introduce a GlobalVariable named `CURRENT_TESTCASE_ID`. And we introduce a Test Listener
[`MyTestListerner`](Test%20Listeners/MyTestListener.groovy). In the method annotated with `@BeforeTestCase` we will seth the ID of current test case to the `GlobalVariable.CURRENT_TESTCASE_ID`.
```
@BeforeTestCase
def beforeTestCase(TestCaseContext testCaseContext) {
    GlobalVariable.CURRENT_TESTCASE_ID = testCaseContext.getTestCaseId()
```

On the other hand, the test case [`TC05_GlobalVariable.CURRENT_TESTCASE_ID`](Scripts/TC05_GlobalVariable.CURRENT_TESTCASE_ID/Script1536640253323.groovy) will refer to the value of `CURRENT_TESTCASE_ID`.

```
String testCaseId = (String)GlobalVariable.CURRENT_TESTCASE_ID
assert testCaseId != null
assert testCaseId.length() > 0
Path pngFile = mr.resolveMaterialPath(testCaseId, 'TC05_screenshot.png')
```

This tricky coding resolves the test case name automatically. You do not have hard-code test case names in the scripts as we did in  [TC02_MaterialRepository](Scripts/TC02_MaterialRepository/Script1536642272611.groovy).

### output

```
$ cd UsingMaterialsInKatalonStudio
$ tree Materials
Materials
└── _
    └── _
        └── TC05_GlobalVariable.CURRENT_TESTCASE_ID
            └── TC05_screenshot.png
```
