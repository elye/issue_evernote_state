package com.elyeproj.evernotestateissue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;

public class MainActivity extends AppCompatActivity {

    @State int myStateValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            StateSaver.restoreInstanceState(this, savedInstanceState);

            if (myStateValue == 1) {
                Toast.makeText(this, "State is correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "State is wrong", Toast.LENGTH_SHORT).show();
            }
        }

        myStateValue = 1;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        StateSaver.saveInstanceState(this, outState);
        super.onSaveInstanceState(outState);

        Log.d("Nothing", "Just log");
    }
}
