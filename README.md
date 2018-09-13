Using Materials in Katalon Studio
=====================================

# What is this?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this out to your PC and run it with your Katalon Studio.

This project was developed using Katalon Studio 5.7.0.




![TSC01_marked](docs/TSC10_marked.png)


# How to set up

The UsingMaterialsInKatalonStudio project


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

## [TC03_subdirectories under testCaseName](Scripts/TC03_subdirectories under testCaseName/Script1536642359919.groovy)

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

## [TC04_URL-based filename](Scripts/TC04_URL-based filename/Script1536642448370.groovy)

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

## [TC05_GlobalVariable.CURRNET_TESTCASE_ID](Scripts/TC05_GlobalVariable.CURRENT_TESTCASE_ID/Script1536640253323.groovy)

```
:UsingMaterialsInKatalonStudio [master]$ tree Materials
Materials
└── _
    └── _
        └── TC05_GlobalVariable.CURRENT_TESTCASE_ID
            └── TC05_screenshot.png
```

## [TC06_GlobalVariable.MATERIAL_REPOSITORY](Scripts/TC06_GlobalVariable.MATERIAL_REPOSITORY/Script1536640238920.groovy)

```
$ tree Materials
Materials
└── _
    └── _
        └── TC06_GlobalVariable.MATERIAL_REPOSITORY
            └── TC06_screenshot.png
```

## [TC07_visiting a web site](Scripts/TC07_visiting a web site/Script1536650683310.groovy)

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

## [TC08_makeIndex](Scripts/TC08_makeIndex/Script1536651022281.groovy)

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

## [TSC09_visit a web site and make index]()

![TSC09](docs/TSC09.png)


## [TSC10_visit 2 environments]()

![TSC09](docs/TSC10_marked.png)
