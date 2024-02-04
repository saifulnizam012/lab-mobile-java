package com.example.mycafeapp_a179830;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton imgBtnCall,imgBtnWeb,imgBtnEmail,imgBtnMap,imgBtnSmile;
    TextView tvName,tvQuantity,tvQuantitys;
    String name;
    int quantity,quantitys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        imgBtnCall = findViewById(R.id.img_btn_call_order_act);
        imgBtnWeb = findViewById(R.id.img_btn_web_order_act);
        imgBtnEmail = findViewById(R.id.img_btn_email_order_act);
        imgBtnMap = findViewById(R.id.img_btn_map_order_act);
        imgBtnSmile = findViewById(R.id.img_btn_smile_order_act);


        tvName = findViewById(R.id.tv_name_order_act);
        tvQuantity = findViewById(R.id.tv_quantity_order_act);
        tvQuantitys = findViewById(R.id.tv_quantitys_order_act);

        Intent intent = getIntent();
        quantity = intent.getIntExtra("quantity",0);
        quantitys = intent.getIntExtra("quantitys",0);
        name = intent.getStringExtra("name");

        tvName.setText(name);
        tvQuantity.setText(""+quantity);
        tvQuantitys.setText(""+quantitys);

        imgBtnCall.setOnClickListener(this);
        imgBtnWeb.setOnClickListener(this);
        imgBtnEmail.setOnClickListener(this);
        imgBtnMap.setOnClickListener(this);
        imgBtnSmile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img_btn_call_order_act:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0112345678"));

                if(callIntent.resolveActivity(getPackageManager ())!=null){
                    startActivity(callIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.img_btn_web_order_act:
                Uri webpage = Uri.parse("http://www.google.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

                if(webIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(webIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.img_btn_email_order_act:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your order from Saiful's Cafe App");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message: Information about order.");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mycafeapp@company.com"});

                if(emailIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(emailIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.img_btn_map_order_act:
                Uri googleMapIntent = Uri.parse("geo:2.9258810009692358, 101.78172839868598?q=" + Uri.encode("BookWorm Café UKM"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, googleMapIntent);
                mapIntent.setPackage("com.google.android.apps.maps");
                if(mapIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(mapIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.img_btn_smile_order_act:
                Uri smilewebpage = Uri.parse("https://cdn.pixabay.com/photo/2020/12/27/20/24/smile-5865208_1280.png");
                Intent smileIntent = new Intent(Intent.ACTION_VIEW,smilewebpage);

                if(smileIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(smileIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}