package com.juliengenoud.easymessages;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.juliengenoud.easymessages.db.AppPreferences;
import com.thebluealliance.spectrum.SpectrumDialog;

/**
 * Author : juliengenoud
 * 21/04/16
 **/
public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {


    int mColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findViewById(R.id.button).setOnClickListener(this);


        ((EditText)findViewById(R.id.name_e)).setText(new AppPreferences(getApplicationContext()).getName());
        ((EditText)findViewById(R.id.surname_e)).setText(new AppPreferences(getApplicationContext()).getSurname());


        ((EditText)findViewById(R.id.name_e)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                new AppPreferences(getApplicationContext()).setName(s.toString());
            }
        });
        ((EditText)findViewById(R.id.surname_e)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                new AppPreferences(getApplicationContext()).setSurname(s.toString());
            }
        });

        mColor = new AppPreferences(getApplicationContext()).getColor();
    }

    @Override
    public void onClick(View v) {
        new SpectrumDialog.Builder(getApplicationContext())
                .setColors(R.array.demo_colors)
                .setSelectedColor(new AppPreferences(getApplicationContext()).getColor())
                .setDismissOnColorSelected(true)
                .setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() {
                    @Override public void onColorSelected(boolean positiveResult, @ColorInt int color) {
                        if(positiveResult) {
                            new AppPreferences(getApplicationContext()).saveColor(color);
                        }
                    }
                }).build().show(getSupportFragmentManager(), "dialog_demo_1");
//        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}