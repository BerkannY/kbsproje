package com.berkan.kbsuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listCoursiers extends AppCompatActivity {
    ListView listView;
    ArrayList<Integer> ids = new ArrayList<Integer>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> idsAndNames = new ArrayList<String>();
    String idAndName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coursiers);
        listView = findViewById(R.id.students);
        try {
            SQLiteDatabase db = this.openOrCreateDatabase("coursiers_Db", MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM coursiers", null);
            int idX = cursor.getColumnIndex("id");
            int nameX = cursor.getColumnIndex("name");
            while (cursor.moveToNext()) {
                ids.add(cursor.getInt(idX));
                names.add(cursor.getString(nameX));
                idAndName = cursor.getInt(idX) + " - " + cursor.getString(nameX);
                idsAndNames.add(idAndName);
            }
            ArrayAdapter adapter =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,idsAndNames);
            listView.setAdapter(adapter);
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToMainMenu(View v) {
        ids.clear();
        names.clear();
        idsAndNames.clear();
        Intent intent = new Intent(listCoursiers.this, MainActivity.class);
        startActivity(intent);
    }
}