package com.example.shubham.project1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        e4=(EditText)findViewById(R.id.editText6);
        e5=(EditText)findViewById(R.id.editText7);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 =e1.getText().toString();
                String s2 =e2.getText().toString();
                String s3 =e3.getText().toString();
                String s4 =e4.getText().toString();
                String s5 =e5.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(Second.this,"Plz fill the details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("project",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists login(username varchar,password varchar,email varchar,city varchar,phone varchar)");
                    String s6="select * from login where username='"+s1+"' and password='"+s2+"' and email='"+s3+"' and phone='"+s4+"'";

                    Cursor cursor=data.rawQuery(s6,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Second.this, "User Exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        data.execSQL("insert into login values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
                        Toast.makeText(Second.this,"Successfully Registered",Toast.LENGTH_LONG).show();
                        Intent j = new Intent(Second.this,MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Second.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });
    }
}
