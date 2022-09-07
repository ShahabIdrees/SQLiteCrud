package com.example.sqlitecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentBaseAdaptor<StudentModel> extends BaseAdapter {
    Context studentContext;
    List<StudentModel> studentlist;
    LayoutInflater inflater ;
    StudentBaseAdaptor(Context context, List<StudentModel> StudentList){
        studentContext = context;
        studentlist = StudentList;
        LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return studentlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StudentModel list = (StudentModel) getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_student, parent, false);
        TextView Name = convertView.findViewById(R.id.textView);
        TextView Rollnum = convertView.findViewById(R.id.textView2);
        Button del = convertView.findViewById(R.id.button2);
        Button Update = convertView.findViewById(R.id.button);
        /*View singleEntityView= inflater.inflate(R.layout.activity_student, null,true);*/

        return convertView;
    }

    private Context getContext() {
        return studentContext;
    }


}
