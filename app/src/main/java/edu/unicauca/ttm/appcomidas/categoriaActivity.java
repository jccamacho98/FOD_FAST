
package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class categoriaActivity extends AppCompatActivity {
FragbarraBusqueda fragbarraBusqueda;

ListView listaComidasRapidas;


    String datos[][] ={
            {"Desgranado Sencillo","Maiz tierno + ripio + pollo + jamon + queso","$12000"},
            {"Desgranado Ranchero","Maiz tierno + ripio + pollo + chorizo + jamon + queso","$12000"},
            {"Desgranado Especial","Maiz tierno + ripio + pollo + chorizo + jamon + queso doble crema + tocineta","$12000"},
            {"Hambuerguesa Sencilla","Carne 100% asada al carbon + cebolla + queso doble crema + jamon + tomate + piña + ripio","$9000"},
            {"Hambuerguesa Doble Carne","Carne 100% asada al carbon + cebolla + queso doble crema + jamon + tomate + piña + ripio","$14000"},
            {"Hambuerguesa De Pollo","Carne 100% asada al carbon + cebolla + pollo + queso doble crema + jamon + tomate + piña","$14000"},
            {"Hambuerguesa Especial","Carne 100% asada al carbon + cebolla + pollo + tocineta + queso doble crema + jamon + tomate + piña","$15000"},
            {"Salchipa sencilla","queso doble crema + jamon ","$7000"},
            {"Salchipa pollo","Pollo + Doble queso + Doble jamon ","$9000"},
            {"Salchipa especial","Maduritos + Pollo + Chorizo + queso doble crema + jamon + maiz tierno + ripio","$16000"},
            {"Perro Sencillo","Salchicha + cebolla + queso doble crema + jamon + piña + ripio","$8000"},
            {"Perro De Pollo","Salchicha + pollo + cebolla + queso doble crema + jamon + piña + ripio","$10000"},
            {"Perro Especial"," Salchicha + pollo + tocineta + cebolla + queso doble crema + jamon + piña + ripio","$13000"}

    };

  int[] DatosImg={
          R.drawable.desgranado_sencillo,
          R.drawable.desgranado_ranchero,
          R.drawable.desgranado_especial,
          R.drawable.hamburguesa_sencilla,
          R.drawable.hamburguesa_doble_carne,
          R.drawable.hamburguesa_de_pollo,
          R.drawable.hamburhuesa_especial,
          R.drawable.salchipapa_sencilla,
          R.drawable.salchipapa_de_pollo,
          R.drawable.salchipapa_especial,
          R.drawable.perro_sencillo,
          R.drawable.perro_con_pollo,
          R.drawable.perro_especial
  };

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

    fragbarraBusqueda=new FragbarraBusqueda();
    getSupportFragmentManager().beginTransaction().add(R.id.ContenedorBusqueda,fragbarraBusqueda).commit();

    listaComidasRapidas = (ListView) findViewById(R.id.lvLista);
    listaComidasRapidas.setAdapter(new Adaptador(this,datos,DatosImg));

    }
    public void onClick(View view){

        Intent miIntent=null;

        switch (view.getId()){
            case R.id.btnAtrasCategoria:
                miIntent=new Intent(categoriaActivity.this,pideEnLinea.class);
                break;
            case R.id.btnPedirLinea:

                break;
            case R.id.btnmenos:

                break;
        }
        startActivity(miIntent);
    }
}