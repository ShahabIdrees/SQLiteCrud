package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Add = findViewById(R.id.buttonAdd);
        Button ViewAll = findViewById(R.id.buttonViewAll);
        TextView Name = findViewById(R.id.editTextName);
        TextView RollNum = findViewById(R.id.editTextRollNumber);
        ListView listViewStudent = findViewById(R.id.listViewStudent);
        Add.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;
            @Override
            public void onClick(View v) {

                try {
                    studentModel = new StudentModel(Name.getText().toString(), Integer.parseInt(RollNum.getText().toString()));
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper  = new DBHelper(MainActivity.this);
                dbHelper.addStudent(studentModel);
                Toast.makeText(MainActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
            }
        });
        ViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ViewAll Clicked", Toast.LENGTH_SHORT).show();
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                ArrayList<StudentModel> list = dbHelper.getAllStudents();
                StudentAdaptor arraylistAdapter = new StudentAdaptor(MainActivity.this,list);
                ListView listView = findViewById(R.id.listViewStudent);

                listView.setAdapter(arraylistAdapter);


            }
        });
    }
}