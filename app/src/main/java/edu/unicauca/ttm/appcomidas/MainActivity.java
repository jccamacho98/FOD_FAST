package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){

        Intent miIntent=null;

        switch (view.getId()){
            case R.id.btnIniciaSesion:
                miIntent=new Intent(MainActivity.this,IniciarSesion.class);
                break;
            case R.id.btnPedirLinea:
                miIntent=new Intent(MainActivity.this,pideEnLinea.class);
                break;
            case R.id.btnmenos:
                miIntent=new Intent(MainActivity.this,IniciarSesion.class);
                break;

        }
        startActivity(miIntent);
    }

}