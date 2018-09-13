Using Materials in Katalon Studio
=====================================

# What is this?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this out to your PC and run it with your Katalon Studio.

This project was developed using Katalon Studio 5.7.0.

I have developed another project named ['Materials'](https://github.com/kazurayam/Materials). The Materials project is developed in Groovy language, provides a jar file. The jar file Materials-x.x.jar is supposed to be imported into a Katalon Studio project as one of the [External library](https://docs.katalon.com/display/KD/External+Libraries).

A term *Material* means



![TSC01_marked](docs/TSC10_marked.png)


# How to set up

The UsingMaterialsInKatalonStudio project


# Sample Codes

## Test Case `TC01_starter`

The test case script is [here](Scripts/TC1_starter/Script1536633564054.groovy)

This test case takes screenshot of a Web page `http://demoaut.katalon.com` and save the image into a file at `<project dir>/tmp/TC1.png`.

Running this test case will result in the following tree:
```
$ cd UsingMaterialsInKatalonStudio/
$ tree tmp
tmp
└── TC01_screenshot.png
```

Note that `java.nio.Path`, `java.nio.Paths` and `java.nio.Files` are used extensively. These classes helps making tidy programs that makes local file I/O.

## Test Case `TC02_MaterialRepository`

The test case script is  [here](Scripts/TC02_MaterialRepository/Script1536642272611.groovy).

Running this test case will result in the following tree:
```
$ tree Materials
Materials
└── _
    └── _
        └── TC02_MaterialRepository
            └── TC02_screenshot.png
```

## Test Case `TC03_subdirectories under testCaseName`

The test case script is
[here](Scripts/TC03_subdirectories under testCaseName/Script1536642359919.groovy).


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

## Test Case `TC04_URL-based filename`

The test case script is
[here](Scripts/TC04_URL-based filename/Script1536642448370.groovy).

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

## Test Case `TC05_GlobalVariable.CURRENT_TESTCASE_ID`

The test case script is  [here](Scripts/TC05_GlobalVariable.CURRENT_TESTCASE_ID/Script1536640253323.groovy).

```
:UsingMaterialsInKatalonStudio [master]$ tree Materials
Materials
└── _
    └── _
        └── TC05_GlobalVariable.CURRENT_TESTCASE_ID
            └── TC05_screenshot.png
```

## Test Case `TC06_GlobalVariable.MATERIAL_REPOSITORY`

The test case script is [here](Scripts/TC06_GlobalVariable.MATERIAL_REPOSITORY/Script1536640238920.groovy).

```
$ tree Materials
Materials
└── _
    └── _
        └── TC06_GlobalVariable.MATERIAL_REPOSITORY
            └── TC06_screenshot.png
```

## Test Case `TC07_visiting a web page`

The test case script is [here](Scripts/TC07_visiting a web site/Script1536650683310.groovy).

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

## Test Case `TC08_makeIndex`

The test case script is [here](Scripts/TC08_makeIndex/Script1536651022281.groovy).

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



## Test Suite Collection `TSC09_visit a web site and make index`

![TSC09](docs/TSC09.png)


## Test Suite Collection `TSC10_visit 2 environments`

![TSC09](docs/TSC10_marked.png)
