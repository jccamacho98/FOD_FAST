package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pideEnLinea extends AppCompatActivity {
    FragbarraBusqueda fragbarraBusqueda;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pide_en_linea);

        fragbarraBusqueda=new FragbarraBusqueda();
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorBus,fragbarraBusqueda).commit();
    }
/////////////////////////////////////////////////////////////

    /*public void onClick(View view){
        this.view = view;
        Intent miIntent=new Intent(pideEnLinea.this,MainActivity.class);
        startActivity(miIntent);
    }*/

    public void onClick(View view){

        Intent miIntent=null;

        switch (view.getId()){
            case R.id.btnAtras:
                miIntent=new Intent(pideEnLinea.this,MainActivity.class);
                break;
            case R.id.imgbtnComidasRapidas:
                miIntent=new Intent(pideEnLinea.this,categoriaActivity.class);
                break;

        }
        startActivity(miIntent);
    }

}