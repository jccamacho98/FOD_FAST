package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pideEnLinea extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pide_en_linea);
    }

    public void onClick(View view){
        this.view = view;
        Intent miIntent=new Intent(pideEnLinea.this,MainActivity.class);
        startActivity(miIntent);
    }

}