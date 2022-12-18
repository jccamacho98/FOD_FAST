package edu.unicauca.ttm.appcomidas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class mysql extends AppCompatActivity implements View.OnClickListener{

    /* codigo de base de datos */
    EditText etName, etPassword, etEmail, etPhone, etId;
    Button btnCreate, btnFetch;

    RequestQueue requestQueue;

    private static final String URL1 = "http://192.168.101.73/FOD_FAST/save.php";

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_mysql);

        requestQueue = Volley.newRequestQueue(this);
        //UI
        initUI();

        btnCreate.setOnClickListener(this);
        btnFetch.setOnClickListener(this);
    }

    private void initUI(){
        //edittext
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
       // etId = findViewById(R.id.etId);

        //Botones
        btnCreate = findViewById(R.id.btnCreate);
        btnFetch = findViewById(R.id.btnFetch);
    }

    @Override
    public void onClick( View v){
        int id = v.getId();

        if (id == R.id.btnCreate){
            String nombre = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            createUser(nombre, email, password, phone);

        }else if (id == R.id.btnFetch){

        }
    }
    private void createUser(final String nombre, final String email, final String password, final String phone){

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(mysql.this, "correcto", Toast.LENGTH_SHORT).show();
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
