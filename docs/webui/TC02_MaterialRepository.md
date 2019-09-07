## Test Case `TC02_MaterialRepository`

### source
The test case script is  [here](Scripts/TC02_MaterialRepository/Script1536642272611.groovy).

Fragment:
```
import com.kazurayam.materials.MaterialRepository
import com.kazurayam.materials.MaterialRepositoryFactory
```

```
// descide in which directory we will create a MaterialRepository
Path materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')

// create an instance of MaterialRepository
MaterialRepository mr = MaterialRepositoryFactory.createInstance(materialsDir)

// resolve the location of PNG file to save the screenshot
Path pngFile = mr.resolveMaterialPath('TC02_MaterialRepository', 'TC02_screenshot.png')
```

### description

The test case `TC02_MaterialRepository` takes a screenshot of Web page `http://demoaut.katalon.com` and save the image into a file under the directory   `${UsingMaterialsInKatalonStudio}/Materials`. The file path is `Materials/_/_/TC02_MaterialRepository/TC02_screenshot.png`.

### how to run it

In Katalon Studio GUI, open the test case `TC02_MaterialRepository` and run it by clicking the run button
![run](docs/images/run_button.PNG)

### output

Running this test case will result in the following tree:

```
$ cd UsingMaterialsInKatalonStudio
$ tree Materials
Materials
└── _
    └── _
        └── TC02_MaterialRepository
            └── TC02_screenshot.png
```

### notes

1. `resolveMaterialPath(String testCaseName, String fileName)` method resolves the path for a *material*. A File will be created with length=0 by this method call.
