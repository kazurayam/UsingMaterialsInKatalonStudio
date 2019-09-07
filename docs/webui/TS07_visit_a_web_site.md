## Test Case `webui/TS07_visit_a_web_site`

The test suite `TS07_visit_a_web_site` visits http://demoaut.katalon.com/, traverse
the site, and takes 5 screenshots. The path of PNG files will be in the following format:

`./Materials/TS07_visit_a_web_site/yyyyMMdd_hhmmss/TC07_visit_a_web_site/filename.png`

The test case script `TC07_visit_a_web_site` is [here](Scripts/TC07_visit_a_web_site/Script1537330820326.groovy).
This script demonstrates how you can traverse a web site using Katalon Studio's commands, and also
how you can take screenshots of web pages.

### output

Running the test suite `TS07_visit_a_web_site` twice will result in the following tree:

```
$ cd UsingMaterialsInKatalonStudio
$ tree Materials
Materials
└─TS07_visit_a_web_site
    ├─20180919_132138
    │  └─TC07_visit_a_web_site
    │          1 CURA_Homepage.png
    │          2 CURA_Login.png
    │          3 CURA_Appointment.png
    │          4 CURA_AppointmentConfirmation.png
    │          5 CURA_Homepage_revisited.png
    │
    └─20180919_132139
        └─TC07_visit_a_web_site
                1 CURA_Homepage.png
                2 CURA_Login.png
                3 CURA_Appointment.png
                4 CURA_AppointmentConfirmation.png
                5 CURA_Homepage_revisited.png
```

Please note that 2 sets of screenshot files are retained.
