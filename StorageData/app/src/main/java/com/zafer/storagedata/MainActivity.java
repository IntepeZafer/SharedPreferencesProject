package com.zafer.storagedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText surname;
    TextView textOne;
    TextView texTwo;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextText);
        surname = findViewById(R.id.editTextText2);
        textOne = findViewById(R.id.textView);
        texTwo = findViewById(R.id.textView2);
        sharedPreferences = this.getSharedPreferences("com.zafer.storagedata" , Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name" , "");
        String surname =  sharedPreferences.getString("surname" , "");
        if(!(name.equals("")) && !(surname.equals(""))){
            textOne.setText(name);
            texTwo.setText(surname);
        }else{
            textOne.setText("");
            texTwo.setText("");
        }
    }
    public void saveButton(View view){
        if (!name.getText().toString().matches("") && !surname.getText().toString().matches("")){
            textOne.setText(name.getText());
            texTwo.setText(surname.getText());
            sharedPreferences.edit().putString("name" , name.getText().toString()).apply();
            sharedPreferences.edit().putString("surname" , surname.getText().toString()).apply();
        }
    }
    public void deleteButton(View view){
        sharedPreferences.edit().remove("name").apply();
        sharedPreferences.edit().remove("surname").apply();
        textOne.setText("");
        texTwo.setText("");
    }
}