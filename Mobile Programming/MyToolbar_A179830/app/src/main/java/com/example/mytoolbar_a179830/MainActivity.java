package com.example.mytoolbar_a179830;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;
        switch(item.getItemId()){

            case R.id.menu_notification:
                Toast.makeText(MainActivity.this,"Notification",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_sync:
                Toast.makeText(MainActivity.this,"sync",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, SyncActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_setting:
                Toast.makeText(MainActivity.this,"setting",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_information:
                Toast.makeText(MainActivity.this,"information",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_message:
                Toast.makeText(MainActivity.this,"Contact",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_search:
                Uri webpage = Uri.parse("http://www.google.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

                if(webIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(webIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
