package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class IniciarSesion extends AppCompatActivity {
   FragmentIniciaSesion fragmentIniciaSesion;
   FragmentRegistrarse fragmentRegistrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        fragmentIniciaSesion = new FragmentIniciaSesion();
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorFrag,fragmentIniciaSesion).commit();
    }
    public void onClick(View view){
        fragmentRegistrarse = new FragmentRegistrarse();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId())
        {
            case R.id.btnIniciaSesion_arriba:
                transaction=getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorFrag,fragmentIniciaSesion);
                break;
            case R.id.btnResgistrarseArriba:
                transaction=getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorFrag,fragmentRegistrarse);
                break;
        }transaction.commit();

    }


}