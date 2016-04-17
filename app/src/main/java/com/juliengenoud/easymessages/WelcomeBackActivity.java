package com.juliengenoud.easymessages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Author : juliengenoud
 * 17/04/16
 **/
public class WelcomeBackActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.btn_login_email).setOnClickListener(this);
        findViewById(R.id.btn_login_wechat).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}