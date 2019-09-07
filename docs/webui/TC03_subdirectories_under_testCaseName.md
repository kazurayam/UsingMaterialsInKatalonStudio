## Test Case `webui/TC03_subdirectories_under_testCaseName`

### source

The test case script is
[here](Scripts/TC03_subdirectories_under_testCaseName/Script1537147371115.groovy).

Fragment:
```
Path pngFile = mr.resolveMaterialPath('TC03_subdirectories_under_testCaseName', 'subdirA/subdirA/TC03_screenshot.png')

```

### description

Please note that we specified the 2nd argument to `resolveMaterialPath()` method call to have a prefix `subdirA/subdirB/`. This allows you to create sub-directories under the testCaseName directory.

### how to run it

In Katalon Studio GUI, open the test case `TC03_subdirectories_under_testCaseName` and run it by clicking the run button  ![run](./images/TC03/run_button.PNG)

### output

Running this test case will result in the following tree:

```
$ cd UsingMaterialsInKatalonStudio
$ tree Materials
Materials
└── _
    └── _
        └── TC03_subdirectories_under_testCaseName
            ├── subdirA
            │   └── subdirA
            │       └── TC03_screenshot.png
            └── subdirB
                └── subdirB
                    └── TC03_screenshot.png
```
