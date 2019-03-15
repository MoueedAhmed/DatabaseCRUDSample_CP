package com.example.databasecrudsample;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myprovidercontract.MyProviderContract;

public class AddEmployeeActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        nameEditText = (EditText) findViewById(R.id.name_edittext);
        addressEditText = (EditText) findViewById(R.id.address_edittext);


    }
    public void addButtonPressed(View view) {
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);

        getContentResolver().insert(MyProviderContract.CONTENT_URI, values);

        finish();
    }
}
