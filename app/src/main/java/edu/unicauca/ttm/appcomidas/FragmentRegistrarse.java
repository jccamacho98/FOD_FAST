package edu.unicauca.ttm.appcomidas;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRegistrarse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistrarse extends Fragment {
    TextView tv_date;
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
     ////////////////////////////////////////////////////////////////////////////////7

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_registrarse, container, false);

    }


    public void onClick(View view) {

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
    }
}