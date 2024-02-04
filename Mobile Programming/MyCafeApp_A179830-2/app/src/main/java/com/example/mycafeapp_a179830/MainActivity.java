package com.example.mycafeapp_a179830;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnMinus,btnCheckOut,btnAdds,btnMinuss;
    TextView tvQuantity,tvQuantitys;
    EditText etName;

    int quantity,quantitys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        btnCheckOut = findViewById(R.id.btn_check_out);
        tvQuantity = findViewById(R.id.tv_quantity);
        etName = findViewById(R.id.et_name);
        btnAdds = findViewById(R.id.btn_adds);
        btnMinuss = findViewById(R.id.btn_minuss);
        tvQuantitys = findViewById(R.id.tv_quantitys);

        quantity = 0;
        quantitys = 0;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                tvQuantity.setText(""+quantity);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity--;
                tvQuantity.setText(""+quantity);
            }
        });

        btnAdds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantitys++;
                tvQuantitys.setText(""+quantitys);
            }
        });

        btnMinuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantitys--;
                tvQuantitys.setText(""+quantitys);
            }
        });

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {
                name=etName.getText().toString();
                Toast.makeText(MainActivity.this,"Thank you "+name+" for order: "+quantity+" Coffee and "+quantitys+" Latte. ",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,OrderDetailActivity.class);
                intent.putExtra("quantity",quantity);
                intent.putExtra("quantitys",quantitys);
                intent.putExtra("name",name);


                startActivity(intent);

            }
        });
    }
}