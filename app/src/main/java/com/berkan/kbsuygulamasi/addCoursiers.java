package com.berkan.kbsuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addCoursiers extends AppCompatActivity {
    EditText coursierName, coursierSurname, coursierAge, coursierClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coursiers);
        coursierName = findViewById(R.id.coursierName);
        coursierSurname = findViewById(R.id.coursierSurname);
        coursierAge = findViewById(R.id.coursierAge);
        coursierClass = findViewById(R.id.coursierClass);
    }

    public void addCoursier(View v) {
        String name = coursierName.getText().toString();
        String surname = coursierSurname.getText().toString();
        String age = coursierAge.getText().toString();
        String classes = coursierClass.getText().toString();
        if (name.isEmpty() || surname.isEmpty() || surname.isEmpty() || age.isEmpty() || classes.isEmpty()) {
            Toast.makeText(this, "Lütfen İlgili Alanları Boş Bırakmayın", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                name = coursierName.getText().toString();
                surname = coursierSurname.getText().toString();
                age = coursierAge.getText().toString();
                classes = coursierClass.getText().toString();
                SQLiteDatabase db = this.openOrCreateDatabase("coursiers_Db", MODE_PRIVATE, null);
                db.execSQL("INSERT INTO coursiers (name, surname, age, class) VALUES ('" + name + "','" + surname + "'," + age + ",'" + classes + "')");
                coursierName.setText("");
                coursierSurname.setText("");
                coursierAge.setText("");
                coursierClass.setText("");
            }
            catch (Exception e){
                Toast.makeText(this, "Kayıt Ekleme Hatası", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void goToMainMenu(View v) {
        Intent intent = new Intent(addCoursiers.this, MainActivity.class);
        startActivity(intent);
    }
}