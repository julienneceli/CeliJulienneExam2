package com.example.celijulienneexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText comment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ACTIVITY REGISTRATION");
        comment1 = findViewById(R.id.editText);
        cb1 = findViewById(R.id.checkBox2);
        cb2 = findViewById(R.id.checkBox3);
        cb3 = findViewById(R.id.checkBox5);
        cb4 = findViewById(R.id.checkBox6);
        cb5 = findViewById(R.id.checkBox7);
        cb6 = findViewById(R.id.checkBox8);
        cb7 = findViewById(R.id.checkBox9);
        cb8 = findViewById(R.id.checkBox10);
    }

    public void saveData(View v) {
        String comment1data = comment1.getText().toString();
        String events = "";
        if (cb1.isChecked()) {
            events = events + cb1.getText().toString() + "\n";
        }
        if (cb2.isChecked()) {
            events = events +  cb2.getText().toString()+ "\n" ;
        }
        if (cb3.isChecked()) {
            events = events +  cb3.getText().toString()+ "\n" ;
        }
        if (cb4.isChecked()) {
            events = events +  cb4.getText().toString()+ "\n" ;
        }
        if (cb5.isChecked()) {
            events = events +  cb5.getText().toString()+ "\n" ;
        }
        if (cb6.isChecked()) {
            events = events +  cb6.getText().toString()+ "\n" ;
        }
        if (cb7.isChecked()) {
            events = events +  cb7.getText().toString()+ "\n" ;
        }
        if (cb8.isChecked()) {
            events = events +  cb8.getText().toString()+ "\n" ;
        }

        FileOutputStream writer = null;
        FileOutputStream writer1 = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer1 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer1.write(events.getBytes());
            writer.write(comment1data.getBytes());
        } catch(FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        } finally {
            try {
                writer.close();
                writer1.close();
            } catch (IOException e) {
                Log.d("Error", "File not found.");
            }
        }
        Toast.makeText(this, "Data is saved.", Toast.LENGTH_LONG).show();
    }

    public void next(View v) {
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(i);
    }
}
