/*          Copyright © 2015-2016 Stanislav Petriakov
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          http://www.boost.org/LICENSE_1_0.txt)
*/
package com.keenfin.sfcdialog_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.keenfin.sfcdialog.SimpleFileChooser;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private SimpleFileChooser mSFCDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textview);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSFCDialog = new SimpleFileChooser();

                if (SimpleFileChooser.isPermissionGranted(MainActivity.this))
                    showSFCDialog();
                else
                    mSFCDialog.requestPermission(MainActivity.this);
            }
        });
    }

    private void showSFCDialog() {
        mSFCDialog.setOnChosenListener(new SimpleFileChooser.SimpleFileChooserListener() {
            @Override
            public void onFileChosen(File file) {
                setText("File is chosen:\r\n" + file.getAbsolutePath());
            }

            @Override
            public void onDirectoryChosen(File directory) {
                setText("Directory is chosen:\r\n" + directory.getAbsolutePath());
            }

            @Override
            public void onCancel() {
                setText("onCancel");
            }
        });

        mSFCDialog.setShowHidden(false);
        mSFCDialog.show(getFragmentManager(), "SimpleFileChooserDialog");

    }

    private void setText(String text) {
        mTextView.setText(text);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case SimpleFileChooser.PERMISSION_REQUEST:
                if (SimpleFileChooser.isGrantResultOk(grantResults))
                    showSFCDialog();
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
