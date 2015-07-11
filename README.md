Simple File/Directory Chooser for Android
==========
####Description:
It's based on dialog fragment so min api is 11+ by default. All styles are like current system theme.

There are 3 callbacks:

* onFileChosen(File file): user clicks OK and file is chosen. file = selected file
* onDirectoryChosen(File directory): user clicks OK and file is not chosen. directory = current directory
* onCancel(): user clicks Cancel. void

####Manifest:
```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

####Usage:
Now available at jcenter! As soon as Maven Central will approve my account I'll add it there too.
```
    compile 'com.4ert.sfcdialog:sfcdialog:0.1'
```

Like any other DialogFragment:
```java
SimpleFileChooser sfcDialog = new SimpleFileChooser();

sfcDialog.setOnChosenListener(new SimpleFileChooser.SimpleFileChooserListener() {
    @Override
    public void onFileChosen(File file) {
        // File is chosen
    }

    @Override
    public void onDirectoryChosen(File directory) {
        // Directory is chosen
    }

    @Override
    public void onCancel() {
        // onCancel
    }
});

sfcDialog.show(getFragmentManager(), "SimpleFileChooserDialog");
```

####Features:
* setShowHidden(boolean showHidden): show/hide hidden files/directories. default = true
* setRootPath(String rootPath): sets root path. default = external storage