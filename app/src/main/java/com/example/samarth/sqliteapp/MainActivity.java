package com.example.samarth.sqliteapp;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText empname;
    EditText deptname;
    TextView textView;
    DB_Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empname=(EditText)findViewById(R.id.editText);
        deptname=(EditText)findViewById(R.id.editText2);
        textView=(TextView)findViewById(R.id.textView);
        controller=new DB_Controller(this,"",null,1);
    }

    public void btn_click(View view) {
        switch (view.getId())
        {
            case R.id.button:
                break;
            case R.id.button2:
                try{
                    controller.insertEmployee(empname.getText().toString(),deptname.getText().toString());
                }
                catch (SQLiteException e)
                {
                    Toast.makeText(MainActivity.this,"ALREADY EXISTS",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button3:
                controller.listRecord(textView);
                break;
        }

    }
}
