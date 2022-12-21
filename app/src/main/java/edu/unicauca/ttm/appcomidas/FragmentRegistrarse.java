package edu.unicauca.ttm.appcomidas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.EditText;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRegistrarse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistrarse extends Fragment {
    TextView tv_date;
    String[] items =  {"Cedula","NIT","Cedula Extranjeria"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    View var;

    RequestQueue requestQueue;

    private static final String URL1 = "http://192.168.10.232/FOD_FAST/save.php";
//////////////////////////////////////////////////////////////////////////////////////

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRegistrarse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragRegistrarse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegistrarse newInstance(String param1, String param2) {
        FragmentRegistrarse fragment = new FragmentRegistrarse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tv_date.findViewById(R.id.FechaNacimientoRegistro);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


     ////////////////////////////////////////////////////////////////////////////
        //initUI();
        /*
        btnCreate.setOnClickListener(this);

        */
    }

    /*
    private void initUI(){
        //edittext
        etName = var.findViewById(R.id.editTextNombreApellido);
        etPassword = var.findViewById(R.id.editTextTextPassword3);
        etEmail = var.findViewById(R.id.editTextEmail);
        etPhone = var.findViewById(R.id.editTextPhone);
        // etId = findViewById(R.id.etId);

        //Botones
        btnCreate = var.findViewById(R.id.btn_registrarse);
        //btnFetch = findViewById(R.id.btnFetch);
    }

     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        var =inflater.inflate(R.layout.fragment_frag_registrarse, container, false);
        return var;
    }


    /*public void onClick(View view) {

  Calendar cal= Calendar.getInstance();
  int anio= cal.get(Calendar.YEAR);
  int mes = cal.get(Calendar.MONTH);
  int dia = cal.get(Calendar.DAY_OF_MONTH);

  DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

      @Override
      public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
      String fecha=dayofMonth+"/"+month+"/"+year;
      }
  },anio,mes,dia);
   dpd.show();
    }*/
    //@Override
    /*
    public void onClick( View view){
        int id = view.getId();

        if (id == R.id.btn_registrarse){
            String nombre = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            createUser(nombre, email, password, phone);

        }; //else if (id == R.id.btnFetch){}

    }*/


    private void createUser(final String nombre, final String email, final String password, final String phone){

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(), "correcto", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", nombre);
                params.put("email", email);
                params.put("password", password);
                params.put("phone", phone);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }
}