package com.example.uas_akb_if1_10119011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class EditActivity extends AppCompatActivity {
    DBHelper helper;
    EditText TxTitle, TxDetail,txtKateg;
    Button btnEdit;
    Toolbar toolbar;
    long id;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new DBHelper(this);

        id = getIntent().getLongExtra(DBHelper.row_id, 0);

        TxTitle = (EditText)findViewById(R.id.txTitle_Edit);
        TxDetail = (EditText)findViewById(R.id.txDetail_Edit);
        txtKateg = (EditText)findViewById(R.id.txKategEdit);


        getData();
    }

    private void getData() {
        Cursor cursor = helper.oneData(id);
        if(cursor.moveToFirst()){
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DBHelper.row_title));
//            @SuppressLint("Range") String kateg = cursor.getString(cursor.getColumnIndex(DBHelper.row_kategori));
            @SuppressLint("Range") String detail = cursor.getString(cursor.getColumnIndex(DBHelper.row_note));

            TxTitle.setText(title);
//            txtKateg.setText(kateg);
            TxDetail.setText(detail);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_edit:
                String title = TxTitle.getText().toString().trim();
                String kateg = txtKateg.getText().toString().trim();
                String detail = TxDetail.getText().toString().trim();

                ContentValues values = new ContentValues();
                values.put(DBHelper.row_title, title);
//                values.put(DBHelper.row_kateg, kateg);
                values.put(DBHelper.row_note, detail);

                if (title.equals("") && detail.equals("")){
                    Toast.makeText(EditActivity.this, "Nothing to save", Toast.LENGTH_SHORT).show();
                }else {
                    helper.updateData(values, id);
                    Toast.makeText(EditActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
        switch (item.getItemId()){
            case R.id.delete_edit:
                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
                builder.setMessage("Apakah Anda Yakin Ingin Menghapus Ini?.");
                builder.setCancelable(true);
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        helper.deleteData(id);
                        Toast.makeText(EditActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}