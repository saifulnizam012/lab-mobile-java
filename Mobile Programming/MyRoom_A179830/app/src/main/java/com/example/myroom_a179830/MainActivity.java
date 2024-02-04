package com.example.myroom_a179830;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myroom_a179830.entities.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave,btnUpdate;
    EditText etName,etPrice;
    TextView tvFruitId;
    ListView lvFruit;

    ArrayAdapter<String>fruitListAdapter;
    ArrayList<String>fruitsArray;
    ArrayList<Integer>fruitsID;

    public static MyFruitDB myFruitDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btn_save);
        btnUpdate = findViewById(R.id.btn_update);
        etName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);

        tvFruitId = findViewById(R.id.tv_fruit_id);
        lvFruit = findViewById(R.id.lv_main);

        fruitListAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        fruitsArray = new ArrayList<String>();
        fruitsID = new ArrayList<Integer>();

        myFruitDB = Room.databaseBuilder(MainActivity.this, MyFruitDB.class,"fruitDB").build();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextIsEmpty())
                    return;
                saveFruit();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextIsEmpty())
                    return;
                updateFruit();
            }
        });

        lvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvFruitId.setText(fruitsID.get(i).toString());
            }
        });

        lvFruit.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Remove Fruit");
                alertDialogBuilder.setMessage("Are you sure you want to remove the fruit: " + fruitsID.get(position));
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toast(getApplicationContext(), "Action Cancelled");
                    }
                });

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Fruit fruit = new Fruit(Integer.parseInt(fruitsID.get(position).toString()));
                        deleteFruit(fruit);
                    }
                });
                alertDialogBuilder.show();
                return true;
            }
        });
    }
    public void saveFruit(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Fruit fruit = new Fruit(etName.getText().toString(), Float.parseFloat(etPrice.getText().toString()));
                myFruitDB.fruitDao().insertFruit(fruit);
                toast(getApplicationContext(), "Fruit Added");
                getAllFruits();
            }
        }).start();

    }
    public void updateFruit(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Fruit fruit = new Fruit(Integer.parseInt(tvFruitId.getText().toString()), etName.getText().toString(), Float.parseFloat(etPrice.getText().toString()));
                myFruitDB.fruitDao().updateFruit(fruit);
                toast(getApplicationContext(), "Fruit Updated");
                getAllFruits();
            }
        }).start();

    }
    public void deleteFruit(final Fruit bev){
        new Thread(new Runnable() {
            @Override
            public void run() {
                myFruitDB.fruitDao().deleteFruit(bev);
                toast(getApplicationContext(), "Fruit Removed");
                getAllFruits();
            }
        }).start();
    }
    public void getAllFruits(){

        fruitsID.clear();
        fruitsArray.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Fruit> fruits = myFruitDB.fruitDao().getAllFruits();
                String fruitInfor;
                for (Fruit fruit : fruits) {
                    fruitInfor = "ID: " + fruit.getFruitID() +
                            "\n Name: " + fruit.getFruitName() +
                            " Price: " + fruit.getFruitPrice();
                    fruitsArray.add(fruitInfor);
                    fruitsID.add(fruit.getFruitID());
                }
                showDataInListView();
            }
        }).start();

    }
    public void showDataInListView(){

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fruitListAdapter.clear();
                fruitListAdapter.addAll(fruitsArray);
                lvFruit.setAdapter(fruitListAdapter);
            }
        });

    }

    private boolean editTextIsEmpty(){

        if(TextUtils.isEmpty(etName.getText().toString())){
            etName.setError("Cannot be Empty");
        }
        if(TextUtils.isEmpty(etPrice.getText().toString())){
            etPrice.setError("Cannot be Empty");
        }
        if(TextUtils.isEmpty(etName.getText().toString())||TextUtils.isEmpty(etPrice.getText().toString())){
            return true;
        }
        else {
            return false;
        }

    }

    public void toast(final Context context, final String text){

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        getAllFruits();
    }
}