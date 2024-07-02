package com.berkan.kbsuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase db = this.openOrCreateDatabase("coursiers_Db",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS Coursiers (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50),surname VARCHAR(50), age INTEGER, class VARCHAR(50))");
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    public void goToAddCoursiers(View v) {
        Intent intent = new Intent(MainActivity.this, addCoursiers.class);
        startActivity(intent);
    }
    public void goToListCoursiers(View v) {
        Intent intent = new Intent(MainActivity.this,listCoursiers.class);
        startActivity(intent);
    }
    public void goToDeleteCoursier(View v) {
        Intent intent = new Intent(MainActivity.this,deleteCoursier.class);
        startActivity(intent);
    }
}