package com.bsr.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText editTextUserName;
    TextView textViewUserName;
    Button buttonSubmit;

   // static final String USER_NAME = "textViewUserName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        textViewUserName = (TextView) findViewById(R.id.textViewUserName);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text user has written
                String userData = editTextUserName.getText().toString();
                //set this text to textview
                textViewUserName.setText(userData);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // get the value you have stored.
        String tvUserName = savedInstanceState.getString("textViewUserData");
        // set the stored value in textview
        textViewUserName.setText(tvUserName);
    }

    //if you change orientation of mobile the data stored in onClick
    //will be gone. To store data we are going to use Bundle object
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //save data as key-value pair
        outState.putString("textViewUserData",textViewUserName.getText().toString());
    }
}
