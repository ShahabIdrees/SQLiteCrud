package com.example.sqlitecrud;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdaptor extends ArrayAdapter<StudentModel> {
    private  Context context;
   public StudentAdaptor(Context context1, ArrayList<StudentModel> arrayList){
       super(context1,R.layout.activity_student, arrayList);
       this.context = context1;
   }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        StudentModel list = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_student, parent, false);
        TextView Name = convertView.findViewById(R.id.textView);
        TextView Rollnum = convertView.findViewById(R.id.textView2);

        Button del = convertView.findViewById(R.id.button2);
        Button Update = convertView.findViewById(R.id.button);
        Name.setText(list.getName());

        Rollnum.setText(String.valueOf(list.getRollNmber()));
        String name = list.getName();
        String roll= String.valueOf(list.getRollNmber());
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog delete_entry = new AlertDialog.Builder(context)
                        .setTitle("Delete Student")
                        .setMessage("Are you sure you want to delete this Student?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper dbHelper = new DBHelper(getContext());
                                dbHelper.deleteStudent(list.rollNmber);
                                remove(list);
                                Toast.makeText(context, "Student Deleted", Toast.LENGTH_SHORT).show();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, UpdateActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("roll",roll);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return convertView;
    }



}
