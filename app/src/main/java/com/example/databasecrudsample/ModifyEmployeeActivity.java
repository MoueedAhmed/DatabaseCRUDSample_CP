package com.example.databasecrudsample;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myprovidercontract.MyProviderContract;

public class ModifyEmployeeActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText addressText;
    private long _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_employee);

        nameText = (EditText) findViewById(R.id.name_edittext);
        addressText = (EditText) findViewById(R.id.address_edittext);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("address");

        _id = Long.parseLong(id);

        nameText.setText(name);
        addressText.setText(desc);
    }

    private void returnToMainActivity()
    {
        finish();
    }

    public void updateButtonPressed(View view) {
        String name = nameText.getText().toString();
        String address = addressText.getText().toString();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);

        Uri employee = Uri.parse(MyProviderContract.CONTENT_URI + "/" + _id);

        getContentResolver().update(employee, values, null, null);

        returnToMainActivity();
    }

    public void deleteButtonPressed(View view) {

        Uri employee = Uri.parse(MyProviderContract.CONTENT_URI + "/" + _id);

        getContentResolver().delete(employee, null, null);
        returnToMainActivity();

    }
}
