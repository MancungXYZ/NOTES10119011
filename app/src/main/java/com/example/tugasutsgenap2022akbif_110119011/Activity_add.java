package com.example.tugasutsgenap2022akbif_110119011;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Activity_add extends AppCompatActivity {
    DBHelper helper;
    EditText TxTitle, TxDetail, TxtKateg;
    Button btnSimpan;
    Toolbar toolbar;
    long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new DBHelper(this);

        id = getIntent().getLongExtra(DBHelper.row_id, 0);

        TxTitle = (EditText)findViewById(R.id.txTitle_Add);
        TxDetail = (EditText)findViewById(R.id.txDetail_Add);
        TxtKateg = (EditText)findViewById(R.id.txtKateg);


    }



    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_add:
                String title = TxTitle.getText().toString().trim();
                String detail = TxDetail.getText().toString().trim();
                String categor = TxtKateg.getText().toString().trim();

                //Get Date
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDate = new SimpleDateFormat("MMM dd, yyyy");
                String created = simpleDate.format(calendar.getTime());

                ContentValues values = new ContentValues();
                values.put(DBHelper.row_title, title);
//                values.put(DBHelper.row_kateg, categor);
                values.put(DBHelper.row_note, detail);
                values.put(DBHelper.row_created, created);

                //Create Condition if Title and Detail is empty
                if (title.equals("") && detail.equals("")) {
                    Toast.makeText(Activity_add.this, "Note tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    helper.insertData(values);
                    Toast.makeText(Activity_add.this, "Tersimpan", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
        return super.onOptionsItemSelected(item);
    }
}