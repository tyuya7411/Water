package com.fju.water;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText month;
    EditText next;
    TextView pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month=findViewById(R.id.month);
        next=findViewById(R.id.next);
        pay=findViewById(R.id.pay);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void check(View view){
        String monthly;getText().toString();
        String dbmonthly;getText().toString();
        if (TextUtils.isEmpty()){
            return;
        }
        if (monthly.length()<=10){
            pay.setText(month*7.35);
        }
        if (monthly.length()<=30&&monthly.length()>10){
            pay.setText(month*9.45-21);
        }
        if (monthly.length()<=50&&monthly.length()>30){
            pay.setText(month*11.5-84);
        }
        if (monthly.length()>50){
            pay.setText(month*12.075-110.25);
        }
        if (dbmonthly.length()<=20){
            pay.setText(next*7.35);
        }
        if (dbmonthly.length()<=60&&dbmonthly.length()>20){
            pay.setText(next*9.45-42);
        }
        if (dbmonthly.length()<=100&&dbmonthly.length()>60){
            pay.setText(next*11.5-168);
        }
        if (dbmonthly.length()>50){
            pay.setText(next*12.075-220.5);
        }
    }

    private Object getText() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
