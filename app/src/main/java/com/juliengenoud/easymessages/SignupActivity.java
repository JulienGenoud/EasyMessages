package com.juliengenoud.easymessages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomeBackActivity.class));
            }
        });


        findViewById(R.id.toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "toot",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d = new AlertDialog.Builder(
                        SignupActivity.this);
                d.setTitle("Your Title");
                AlertDialog alertDialog = d.create();
                alertDialog.show();
            }
        });



        ListView lv = (ListView) findViewById(R.id.list);

        List<String> e = new ArrayList<>();
        e.add("dd");

        assert lv != null;

        String[] cities = getResources().getStringArray(R.array.name);

        ArrayList<String> stockList = new ArrayList(Arrays.asList(cities ));// Arrays.asList(cities);

        for (int i = 0;i<10000;i++) {
            stockList.add(String.valueOf(i));
        }

        String[] stockArr = stockList.toArray(new String[stockList.size()]);

        for(String s : stockArr)
            System.out.println(s);

        lv.setAdapter( new ArrayAdapter<String>(this, R.layout.tttt, R.id.label, stockArr));
    }
}
