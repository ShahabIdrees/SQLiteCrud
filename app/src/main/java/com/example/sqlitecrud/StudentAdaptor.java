package com.example.sqlitecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

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

        Rollnum.setText(list.getRollNmber());

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHelper = new DBHelper(getContext());
                /*dbHelper.Delete(roll);
                remove(list);*/

            }
        });
        /*Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, UpdateActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("roll",roll);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });*/

        return convertView;
    }



}
