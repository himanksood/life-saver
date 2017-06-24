package com.example.dell.home1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btn1;
    Button btn2;

    EditText etxt1;
    EditText etxt2;
    EditText etxt3;
    Data_Base dataBase;

    Editor edit;
    //SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxt1 = (EditText) findViewById(R.id.txtUserName);
        etxt2 = (EditText) findViewById(R.id.txtPasswosd);
       // etxt3 = (EditText) findViewById(R.id.et3);

        //  sp = getSharedPreferences("Data", Context.MODE_PRIVATE);

        dataBase = new Data_Base(MainActivity.this);
        btn1 = (Button) findViewById(R.id.b1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String name = etxt1.getText().toString();
                String passw = etxt2.getText().toString();
               // String cont = etxt3.getText().toString();

                if (name.length() > 0 && passw.length() > 0) {
                    Log.e("tag", "======");
                    if (dataBase.validate(name, passw) > 0) {
                        Intent intent = new Intent(MainActivity.this,
                                MyNewActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Enter valid login details", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Fill all above details ", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });


        btn2 = (Button) findViewById(R.id.b2);
        btn2.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent log = new Intent(MainActivity.this,
                        Register.class);
                startActivity(log);

            }
        });
    }


}