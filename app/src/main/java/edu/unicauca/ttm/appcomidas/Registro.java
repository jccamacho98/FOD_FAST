package edu.unicauca.ttm.appcomidas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import edu.unicauca.ttm.appcomidas.db.DbContactos;

public class Registro extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreoElectronico,txtCedula,txtContrasena;
    Button btnGuarda;
     //FirebaseApp.initializeApp(this);
    //FirebaseFirestore db = FirebaseFirestore.getInstance();
   ///////////firebase//////////////

   public void iniciarFirebase(){
       FirebaseApp.initializeApp(this);
       FirebaseFirestore db = FirebaseFirestore.getInstance();
       //Toast.makeText(this,"Base de datos Iniciada",Toast.LENGTH_SHORT).show();
       //CollectionReference userCol =db.collection("users");
       //Map<String>, Object> user=new HashMap<>();
   }
   ////////////////////////////////
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //iniciarFirebase();

        txtNombre = findViewById(R.id.editNombre);
        txtTelefono = findViewById(R.id.editCeluar);
        txtCorreoElectronico = findViewById(R.id.editEmail);
        txtCedula=findViewById(R.id.editCedula);
        txtContrasena=findViewById(R.id.editPass);
        btnGuarda = findViewById(R.id.botonRegistroo);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txtNombre.getText().toString().equals("") && !txtTelefono.getText().toString().equals("")) {

                    DbContactos dbContactos = new DbContactos(Registro.this);
                    long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(),txtCedula.getText().toString(),txtContrasena.getText().toString(), txtCorreoElectronico.getText().toString());

                    if (id > 0) {
                        Toast.makeText(Registro.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(Registro.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Registro.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }

                /////////////firebase//////////////////
                //db.collection("users").document().set("");
                //hashMapof("provaider" to provider,  )
                ///////////////////////////////////////
            }
        });
    }
    private void limpiar() {
        txtNombre.setText(R.string.campoNombresApellidos);
        txtTelefono.setText(R.string.campoNumCelular);
        txtCorreoElectronico.setText(R.string.CampoCorreoElectronico);
        txtContrasena.setText(R.string.Contrasena);
        txtCedula.setText(R.string.campoNumDocumento);
    }

}