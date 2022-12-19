package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int imagenesPromociones[]=
                {
                        R.drawable.promo_salchipapa,
                        R.drawable.promo_sandwich,
                        R.drawable.promohambuerguesa};
        v_flipper =findViewById(R.id.v_flipper);

        for(int imagen: imagenesPromociones){
            flipperImages(imagen);

        }

    }

    //metodo para el visor de imagenes
    public void flipperImages(int imagePromo){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(imagePromo);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(6000); //tiempo de la trancision
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);

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