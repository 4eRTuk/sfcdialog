Simple File/Directory Chooser for Android
==========
####Description:
It's based on dialog fragment so min api is 11+ by default. All styles are like current system theme.

There are 3 callbacks:

* onFileChosen(File file): user clicks OK and file is chosen. file = selected file
* onDirectoryChosen(File directory): user clicks OK and file is not chosen. directory = current directory
* onCancel(): user clicks Cancel. void

####Usage:
Now available at jCenter and Maven Central! Just add line to build.gradle:
```
dependencies {
    ...
    compile 'com.4ert:sfcdialog:0.1.1'
}
```

Like any other DialogFragment:
```
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