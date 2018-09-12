Using Materials in Katalon Studio
=====================================

# Sample Codes

## [TC01_starter](Scripts/TC1/Script1536558958620.groovy)

This Test Case takes a screenshot of http://demoaut.katalon.com and save it into
a file at `<project dir>/tmp/TC1.png`.

Running this test case will result in the following tree:
```
$ cd UsingMaterialsInKatalonStudio/
$ tree tmp
tmp
└── TC01_screenshot.png
```

Note that `java.nio.Path`, `java.nio.Paths` and `java.nio.Files` are used extensively.
These classes helps making tidy programs that makes local file I/O.

## [TC02_MaterialRepository](Scripts/TC02_MaterialRepository/Script1536642272611.groovy)

Running this test case will result in the following tree:
```
$ tree Materials
Materials
└── _
    └── _
        └── TC02_MaterialRepository
            └── TC02_screenshot.png
```

## [TC03_subdirectories under testCaseName]

```
$ tree Materials
Materials
└── _
    └── _
        └── TC03_subdirectories under testCaseName
            ├── subdirA
            │   └── subdirA
            │       └── TC03_screenshot.png
            └── subdirB
                └── subdirB
                    └── TC03_screenshot.png
```

## [TC04_URL-based filename]

```
$ tree Materials
Materials
└── _
    └── _
        └── TC04_URL-based filename
            ├── http%3A%2F%2Fdemoaut.katalon.com.png
            └── subdir
                └── http%3A%2F%2Fdemoaut.katalon.com.png

```

## [TC05_GlobalVariable.CURRNET_TESTCASE_ID]

```
:UsingMaterialsInKatalonStudio [master]$ tree Materials
Materials
└── _
    └── _
        └── TC05_GlobalVariable.CURRENT_TESTCASE_ID
            └── TC05_screenshot.png
```

## [TC06_GlobalVariable.MATERIAL_REPOSITORY]

```
$ tree Materials
Materials
└── _
    └── _
        └── TC06_GlobalVariable.MATERIAL_REPOSITORY
            └── TC06_screenshot.png
```

## [TC07_visiting a web site]

```
$ tree Materials
Materials
└── _
    └── _
        └── TC07_visiting a web site
            ├── CURA_Appointment.png
            ├── CURA_AppointmentConfirmation.png
            ├── CURA_Homepage.png
            ├── CURA_Homepage_revisited.png
            └── CURA_Login.png
```

## [TC08_makeIndex]

```
$ tree Materials
Materials
├── _
│   └── _
│       └── TC08_makeIndex
│           ├── CURA_Appointment.png
│           ├── CURA_AppointmentConfirmation.png
│           ├── CURA_Homepage.png
│           ├── CURA_Homepage_revisited.png
│           └── CURA_Login.png
└── index.html

```
