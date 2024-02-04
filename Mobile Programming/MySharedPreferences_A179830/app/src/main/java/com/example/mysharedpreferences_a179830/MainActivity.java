package com.example.mysharedpreferences_a179830;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_language , tv_theme, tv_wifi , tv_bluetooth ;
    LinearLayout ll_setting_language, ll_setting_notification, ll_setting_theme, ll_setting_wifi, ll_setting_bluetooth, ll_setting_airplane;
    Switch switch_notification , switch_airplane;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String SP_LANGUAGE = "language";
    String SP_NOTIFICATION = "notification";
    String SP_THEME = "theme";
    String SP_WIFI = "wifi";
    String SP_BLUETOOTH = "bluetooth";
    String SP_AIRPLANE = "airplane";

    String[] values = {"English", "Melayu", "Chinese", "Tamil"};
    String[] themevalues = {"Light mode", "Dark mode"};
    String[] wifivalues = {"Off","MyUKM","MyUKM_Staff","MyUKMg"};
    String[] bluetoothvalues = {"Off", "Iman'sPhone", "Loki","KUCAI"};
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_language = findViewById(R.id.tv_language);
        tv_theme = findViewById(R.id.tv_theme);
        tv_wifi = findViewById(R.id.tv_wifi);
        tv_bluetooth = findViewById(R.id.tv_bluetooth);
        switch_notification = findViewById(R.id.switch_notification);
        switch_airplane = findViewById(R.id.switch_airplane);
        ll_setting_language = findViewById(R.id.ll_setting_language);
        ll_setting_notification = findViewById(R.id.ll_setting_notification);
        ll_setting_theme = findViewById(R.id.ll_setting_theme);
        ll_setting_wifi = findViewById(R.id.ll_setting_wifi);
        ll_setting_bluetooth = findViewById(R.id.ll_setting_bluetooth);
        ll_setting_airplane = findViewById(R.id.ll_setting_airplane);
        sharedPref = getSharedPreferences("app_settings", MODE_PRIVATE);
        editor = sharedPref.edit();

        switch_notification.setChecked(sharedPref.getBoolean(SP_NOTIFICATION,false));
        tv_language.setText(values[sharedPref.getInt(SP_LANGUAGE,0)]);
        switch_airplane.setChecked(sharedPref.getBoolean(SP_AIRPLANE,false));
        tv_theme.setText(themevalues[sharedPref.getInt(SP_THEME,0)]);
        tv_wifi.setText(wifivalues[sharedPref.getInt(SP_WIFI,0)]);
        tv_bluetooth.setText(bluetoothvalues[sharedPref.getInt(SP_BLUETOOTH,0)]);

        switch_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SP_NOTIFICATION,b);
                editor.commit();
            }
        });

        ll_setting_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean switchState = switch_notification.isChecked();
                switch_notification.setChecked(!switchState);
                editor.putBoolean(SP_NOTIFICATION,!switchState);
                editor.commit();
            }
        });

        switch_airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SP_AIRPLANE,b);
                editor.commit();
            }
        });

        ll_setting_airplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean switchState = switch_airplane.isChecked();
                switch_airplane.setChecked(!switchState);
                editor.putBoolean(SP_AIRPLANE,!switchState);
                editor.commit();
            }
        });

        ll_setting_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowLanguageOptions();

            }
        });

        ll_setting_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowThemeOptions();

            }
        });

        ll_setting_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowWifiOptions();

            }
        });

        ll_setting_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowBluetoothOptions();

            }
        });

    }

    private void ShowLanguageOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select your language");
        builder.setSingleChoiceItems(values, sharedPref.getInt(SP_LANGUAGE,0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i){
                    case 0:
                        editor.putInt(SP_LANGUAGE,0);
                        editor.commit();
                        break;
                    case 1:
                        editor.putInt(SP_LANGUAGE,1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_LANGUAGE,2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_LANGUAGE,3);
                        editor.commit();
                        break;

                }
                alertDialog.dismiss();
                tv_language.setText(values[sharedPref.getInt(SP_LANGUAGE,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    private void ShowThemeOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select your Theme");
        builder.setSingleChoiceItems(themevalues, sharedPref.getInt(SP_THEME,0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i){
                    case 0:
                        editor.putInt(SP_THEME,0);
                        editor.commit();
                        break;
                    case 1:
                        editor.putInt(SP_THEME,1);
                        editor.commit();
                        break;

                }
                alertDialog.dismiss();
                tv_theme.setText(themevalues[sharedPref.getInt(SP_THEME,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    private void ShowWifiOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select your Wifi");
        builder.setSingleChoiceItems(wifivalues, sharedPref.getInt(SP_WIFI,0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i){
                    case 0:
                        editor.putInt(SP_WIFI,0);
                        editor.commit();
                        break;
                    case 1:
                        editor.putInt(SP_WIFI,1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_WIFI,2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_WIFI,3);
                        editor.commit();
                        break;

                }
                alertDialog.dismiss();
                tv_wifi.setText(wifivalues[sharedPref.getInt(SP_WIFI,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    private void ShowBluetoothOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select your Bluetooth");
        builder.setSingleChoiceItems(bluetoothvalues, sharedPref.getInt(SP_BLUETOOTH,0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i){
                    case 0:
                        editor.putInt(SP_BLUETOOTH,0);
                        editor.commit();
                        break;
                    case 1:
                        editor.putInt(SP_BLUETOOTH,1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_BLUETOOTH,2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_BLUETOOTH,3);
                        editor.commit();
                        break;

                }
                alertDialog.dismiss();
                tv_bluetooth.setText(bluetoothvalues[sharedPref.getInt(SP_BLUETOOTH,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}