package com.example.uas_akb_if1_10119011;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class CustomCursorAdapter extends CursorAdapter {
    private LayoutInflater layoutInflater;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.row_notes, viewGroup, false);
        MyHolder holder = new MyHolder();
        holder.ListID = (TextView)v.findViewById(R.id.listID);
        holder.ListTitle = (TextView)v.findViewById(R.id.listTitle);
//        holder.ListKategori = (TextView)v.findViewById((R.id.listKateg)) ;
        holder.ListDetail = (TextView)v.findViewById(R.id.listDetail);
        holder.ListCreated = (TextView)v.findViewById(R.id.listCreated);
        v.setTag(holder);
        return v;
    }

    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolder holder = (MyHolder)view.getTag();
        holder.ListID.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_id)));
        holder.ListTitle.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_title)));
//        holder.ListKategori.setText(cursor.getString((cursor.getColumnIndex(DBHelper.row_kateg))));
        holder.ListDetail.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_note)));
        holder.ListCreated.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_created)));
    }

    class MyHolder{
        TextView ListID;
        TextView ListTitle;
        TextView ListDetail;
        TextView ListCreated;
        TextView ListKategori;
    }
}
