package edu.unicauca.ttm.appcomidas;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view){

        Intent miIntent=null;

        switch (view.getId()){
            case R.id.btnIniciaSesion:

                break;
            case R.id.btnPedirLinea:
                miIntent=new Intent(MainActivity.this,pideEnLinea.class);
                break;
            case R.id.btnRegistrarse:
                break;

        }
        startActivity(miIntent);
    }

}