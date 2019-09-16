Using Materials in Katalon Studio
=====================================

# What is this repository?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this out to your PC and run it with your Katalon Studio.

This project was developed using Katalon Studio 5.7.0.

I have developed another project on GitHub named ['Materials'](https://github.com/kazurayam/Materials). The project is developed in Groovy language, provides a jar file. You can download Materials-x.x.x.jar file from the [Release](https://github.com/kazurayam/Materials/releases) page. The jar is supposed to be imported into Katalon Studio projects as [External library](https://docs.katalon.com/display/KD/External+Libraries).

In this 'UsingMaterialsInKatalonStudio' project, I will show you, step by step, how to write test scripts in Katalon Studio making use of the  ['Materials'](https://github.com/kazurayam/Materials) library.

The Groovydoc of the `Materials` is published [here](https://kazurayam.github.io/Materials/).

# Problem to solve

What is a *material*? By the term *Material* I mean any file created by test scripts on the fly. A typical example of a *Material* is a PNG file as screenshot of web page taken by [WebDriver API](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/TakesScreenshot.html). Other examples of *Material* would include:
1. PDF files downloaded from web site
2. Excel/CSV files created by test script
3. JSON/XML responses from RESTful API call
4. HTTP Response Header in plain \*.txt format

Selenium WebDriver and Katalon Studio provide sound support for interacting with web. But their support falls short of the following  problem: **which path to save a file as?**

Specifying a one-off path is trivial. Say, `C:\Users\myname\tmp\sample_screenshot.png` would be fine. However if we are to make dozens of *materials* repeatedly and **if we are to reuse the files after interating with web**, then it becomes an itchy problem how to resolve paths for all *materials* appropriately.

How do I want to reuse materials? For example, I want to perform **Visual Testing** in Katalon Studio. I would take 30 screenshots of my web app in both of the production environment and the development environment. After taking screenshots, I want to compare pairs of images to find out if any differences are found.

Another usecase of materials is just for logging purpose. When I test RESTful API, it is likely I want to save HTTP Respose and Body into files just for logging.

My problem is that I have to design the paths for those files. I want a reusable solution for resolving material paths: a class library which implements a designed repository for the files (*materials*) with intuitive access methods.

# Solution

The [`Materials`](https://github.com/kazurayam/Materials) library implements the  `com.kazurayam.materials.MaterialRepository` object. A test script in Katalon Studio can ask the  `MaterialRepository` object to resolve path for a *material* for you. The path would be in the format as follows:

`${projectDir}/Materials/${testSuiteName}/${testSuiteTimestamp}/${testCaseName}/${subdirs}/${fileName}`

For example,

`./Materials/TS07_visit_a_web_site/20180919_132138/TC07_visit_a_web_site/1 CURA_Homepage.png`

An example of file tree created is like this:
![TS07_tree](docs/images/TS07/TS07_tree.png)

Also the `com.kazurayam.materials.MaterialRepository` object can make `./Materials/index.html` file. This HTML file is a viewer, provides easy access to the files contained in the repository. The following picture shows an example of the `./Materials/index`.

| index.html | screen shot shown in modal |
|:-----------|:---------------------------|
| ![index](docs/images/index.png) | ![index_modal](docs/images/index_modal.png) |

# How to set up

This project depends on the jar provided by the Materials project on GitHub. The jar files are downloadable from the [`Releases`](https://github.com/kazurayam/Materials/releases) page. You can import the jar file into your Katalon Studio project as an [External library](https://docs.katalon.com/display/KD/External+Libraries).

At early Septermber 2019, `${projectDir}/Drivers/Materials-0.72.1.jar` is bundled in this demo project.

# Description of codes

I will describe all test scripts one by one. Please retrieve each pages by clicking the links.

## Test Cases

- [`webui/TC01_starter`](./docs/webui/TC01_starter.md)
- [`webui/TC02_MaterialRepository`](./docs/webui/TC02_MaterialRepository.md)
- [`webui/TC03_subdirectories_under_testCaseName`](./docs/webui/TC03_subdirectories_under_testCaseName.md)
- [`webui/TC04_URL-based_filename`](./docs/webui/TC04_URL-based_filename.md)
- [`webui/TC05_GlobalVariable.CURRENT_TESTCASE_ID`](./docs/webui/TC05_GlobalVariable.CURRENT_TESTCASE_ID.md)

## Test Suites

- [`webui/TS06_GlobalVariable.MATERIAL_REPOSITORY`](./docs/webui/TS06_GlobalVariable.MATERIAL_REPOSITORY.md)
- [`webui/TS07_visit_a_web_site`](./docs/webui/TS07_visit_a_web_site.md)
- [`webui/TS08_makeIndex`](./docs/webui/TS08_makeIndex.md)

## Test Suite Collections

- [`webui/TSC09_visit_a_web_site_and_make_index`](./docs/webui/TSC09_visit_a_web_site_and_make_index.md)
- [`webui/TSC10_visit_2_environments`](./docs/webui/TSC10_visit_2_environments.md)


# Possible usecases

## Not only for screen shots but other types of files

The `resolveMaterialPath` method of [`MaterialRepository`]( https://kazurayam.github.io/Materials/com/kazurayam/materials/MaterialRepository.html) returns a `java.nio.file.Path` object = the location of a file. It does not read or write `java.io.File` object. This means that the `Materials` library does not restrict the types of files to be stored in the MaterialRepository.

This demo project describes how to store screen shots into the `<projectDir>/Materials` folder. Of course, it is a typical usecase. However you can store other types of files there: PDF files downloaded from web, Excel files createdy by test scripts on the fly, XML and JSON responded Web API services, etc.



## Not only for Katalon Studio but other testing frameworks

The `Materials-x.x.x.jar` depends on Java8, [slf4j](https://www.slf4j.org/) and [logback](https://logback.qos.ch/) as the  [build.gradle](https://github.com/kazurayam/Materials/blob/master/build.gradle) file shows. That's all. It does not depend on the [Katalon Studio's API](https://api-docs.katalon.com/) at all.

Therefore it is possible to use the jar with other Java-based testing frameworks such as [JUnit](https://junit.org/junit5/) and [Spock](http://spockframework.org/).
