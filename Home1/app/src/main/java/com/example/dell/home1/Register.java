package com.example.dell.home1;

import android.app.Activity;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
Button btn11;
Button btn13;

EditText etxt11;
EditText etxt12;
EditText etxt13;
EditText etxt14;
EditText etxt15;

public Data_Base dim;
DatabaseErrorHandler db;
Data_Base dataBase;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sign_in);

    btn11 = (Button) findViewById(R.id.b11);
  //  btn12 = (Button) findViewById(R.id.b12);
    btn13 = (Button) findViewById(R.id.b13);

    etxt11= (EditText) findViewById(R.id.et11);
    etxt12= (EditText) findViewById(R.id.et12);
    etxt13= (EditText) findViewById(R.id.et13);
    etxt14= (EditText) findViewById(R.id.et14);
    etxt15= (EditText) findViewById(R.id.et15);

    dim = new Data_Base(this);
    btn11.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            if(etxt11.length() > 0 && etxt12.length() > 0 && etxt13.length() > 0 && etxt14.length() > 0  && etxt15.length() > 0 ) {
                dim.oninsert(etxt11.getText().toString(), etxt12.getText().toString(), etxt14.getText().toString(), etxt15.getText().toString());

                Toast.makeText(getApplicationContext(), "Details are saved",
                        Toast.LENGTH_SHORT).show();

                etxt11.setText("");
                etxt12.setText("");
                etxt13.setText("");
                etxt14.setText("");
                etxt15.setText("");
            }
            else {
                Toast.makeText(getApplicationContext(), "Fill all above details",
                        Toast.LENGTH_SHORT).show();
            }

        }
    });

  /*  btn12.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            etxt11.setText("");
            etxt12.setText("");
            etxt13.setText("");
            etxt14.setText("");
            etxt15.setText("");
        }
    });*/
    btn13.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();
        }

    });

}
}
