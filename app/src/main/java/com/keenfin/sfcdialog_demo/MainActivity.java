/*          Copyright © 2015 Stanislav Petriakov
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          http://www.boost.org/LICENSE_1_0.txt)
*/
package com.keenfin.sfcdialog_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.keenfin.sfcdialog.SimpleFileChooser;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textview);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleFileChooser sfcDialog = new SimpleFileChooser();

                sfcDialog.setOnChosenListener(new SimpleFileChooser.SimpleFileChooserListener() {
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

                sfcDialog.setShowHidden(false);
                sfcDialog.show(getFragmentManager(), "SimpleFileChooserDialog");
            }
        });
    }

    private void setText(String text) {
        tv.setText(text);
    }
}
