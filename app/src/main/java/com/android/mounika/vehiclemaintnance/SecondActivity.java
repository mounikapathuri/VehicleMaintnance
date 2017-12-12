package com.android.mounika.vehiclemaintnance;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    SQLiteDatabase database = null;
    DatePicker datePicker;
    EditText Amount;
    EditText Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       saveDetails();
        getDetails();


        VehicleDB db = new VehicleDB(this);
        database = db.getWritableDatabase();

    }
   public void saveDetails(){
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        Amount = (EditText) findViewById(R.id.editText1);
        Message = (EditText) findViewById(R.id.editText2);
        Button button = (android.widget.Button) findViewById(R.id.button1);
      // Object view;
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String d = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();

               int a = Integer.parseInt(Amount.getText().toString());
               String m = Message.getText().toString();

               ContentValues map = new ContentValues();
               map.put("Date", d);
               map.put("Amount", a);
               map.put("Message", m);

               database.insert("VehicleDB", null, map);

               Toast.makeText(SecondActivity.this, "Details Saved...", Toast.LENGTH_LONG).show();
           }
       });

    }
    public void getDetails(){
     Button button= (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(i);
            }
        });
    }
}

