package edu.unicauca.ttm.appcomidas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;

    //constructor
    public Adaptador(Context contexto,  String[][] datos,int[] imagenes)
    {
        this.contexto=contexto;
        this.datos=datos;
        this.datosImg=imagenes;

        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent)
    {
        final View vista= inflater.inflate(R.layout.elemento_lista,null);

        TextView titulo=(TextView) vista.findViewById(R.id.TituloComida);
        TextView descripcion=(TextView) vista.findViewById(R.id.DescripcionComida);
        TextView precio=(TextView) vista.findViewById(R.id.PrecioComida);
        ImageView imagen=(ImageView) vista.findViewById(R.id.imgComida);

        titulo.setText(datos[i][0]);
        descripcion.setText(datos[i][1]);
        precio.setText(datos[i][2]);

        imagen.setImageResource(datosImg[i]);


        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });


        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
