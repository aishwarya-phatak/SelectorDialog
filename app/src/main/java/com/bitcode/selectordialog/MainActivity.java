package com.bitcode.selectordialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class MainActivity extends AppCompatActivity {

    Button btnShowSelectorDialog,btnShowSelectorDialogForSkills;
    TextView txtFavCities;

    String [] cities = {"Pune", "Mumbai","Delhi", "Nagpur"};

    String [] skills = {"C", "CPP", "java","Android","Kotlin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews(){
        txtFavCities = findViewById(R.id.txtFavCities);
        btnShowSelectorDialogForSkills = findViewById(R.id.btnShowSelectorDialogForSkills);
        btnShowSelectorDialog = findViewById(R.id.btnShowSelectorDialog);

    }

    private void initListeners(){
            btnShowSelectorDialog.setOnClickListener(new BtnShowSelectorDialogClickListener());
            btnShowSelectorDialogForSkills.setOnClickListener(new BtnShowSelectorDialogForSkillsClickListener());
    }

    private class BtnShowSelectorDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            SelectorDialog selectorDialog = new SelectorDialog(
                    MainActivity.this,
                           cities);
            selectorDialog.setTitle("Cities");
            selectorDialog.setOnOptionsSetListener(new MyOnCitiesOptionsSelectedListener());
            selectorDialog.show();
        }
    }

    private class MyOnCitiesOptionsSelectedListener implements SelectorDialog.OnOptionsSetListener{
        @Override
        public void onOptionsSet(ArrayList<String> selectedCities) {
            txtFavCities.setText("");
            for(String city : selectedCities){
                txtFavCities.append(city + "\n");
            }
        }
    }

    private class BtnShowSelectorDialogForSkillsClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
           SelectorDialog selectorDialog = new SelectorDialog(
                           MainActivity.this,
                           skills);
           selectorDialog.setTitle("Skills in IT");
           selectorDialog.setOnOptionsSetListener(new MyOnSkillsOptionsSelectedListener());
           selectorDialog.show();
        }
    }

    private class MyOnSkillsOptionsSelectedListener implements SelectorDialog.OnOptionsSetListener{
        @Override
        public void onOptionsSet(ArrayList<String> selectedSkills) {
            txtFavCities.setText("");
            for(String skill : selectedSkills){
                txtFavCities.append(skill + "\n");
            }
        }
    }
}