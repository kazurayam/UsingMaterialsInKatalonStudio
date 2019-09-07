## Test Suite Collection `webui/TSC09_visit_a_web_site_and_make_index`

### description

Now we make a Test Suite Collection named `webui/TSC09_visit_a_web_site_and_make_index`.

This Test Suite Collection executes 3 test suites sequentially:

1. `webui/TS00_clearMaterials` --- this test suite deletes all files under the `<project>/Materials` directory.
2. `webui/TS07_visit_a_web_site` --- this test suite visits a web site and taks screenshots.
3. `webui/TS08_makeIndex` --- this test suite makes an HTML `<project>/Materials/index.html`

Here we apply the Execution Profile `default`.

![TSC09](docs/images/webui/TSC09/TSC09.png)

### how to execute it

In the Test Suite Collection pane, you can find a green button labeled `Execute`
![TSC09](docs/images/webui/TSC09/How_to_run_TSC09.PNG)
Click this button, then the test suite collection will start running.

### how to retrieve the logs in Test Suite Collection

A Test Suite Collection consists of multiple Test Suites. Once you execute it, you will want to view all the logs emitted by test suites. However Katalon Studio GUI is a bit blunt and you are likely to wonder how you can view the logs.

There is an *eye icon* in the Test Suite Collection pane. See the following screenshot. By clicking the eye icon you will see a drop-down list of test suite logs where you can choose one to retrieve.
![eye_icon](docs/images/webui/TSC09/How_to_retrieve_testsuite_log_in_testsuitescollection.png)
