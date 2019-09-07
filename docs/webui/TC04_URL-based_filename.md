## Test Case `TC04_URL-based_filename`

### source

The test case script is
[here](Scripts/TC04_URL-based_filename/Script1537147401510.groovy).

Fragments:

```
String urlString = 'http://demoaut.katalon.com'

...

File pngFile = mr.resolveScreenshotPath('TC04_URL-based_filename', new URL(urlString))

...

pngFile = mr.resolveScreenshotPath('TC04_URL-based_filename', Paths.get('subdir'), new URL(urlString))
```

### description

How a screenshot of a web page should be named? You can name it as 'sample1.png' or 'demoX.png'. That's fine. But the easiest way to name a screenshot file is to name it the same as its URL.

`MaterialRepository` provides another method `resolveScreenshotPath(String testCaseName, URL url)` and `resolveScreenshotPath(String testCaseName, Path subdir, URL url)`. The `resolveScreeshotPath` method does URL-encoding to the URL string so that we can escape special characters into %xx format.

### output
```
$ cd UsingMaterialsInKatalonStudio
$ tree Materials
Materials
└── _
    └── _
        └── TC04_URL-based_filename
            ├── http%3A%2F%2Fdemoaut.katalon.com.png
            └── subdir
                └── http%3A%2F%2Fdemoaut.katalon.com.png

```
