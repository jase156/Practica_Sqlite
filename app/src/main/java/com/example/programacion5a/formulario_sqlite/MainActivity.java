package com.example.programacion5a.formulario_sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.ContentValues;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtApellido;
    EditText txtDireccion;
    EditText txtCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtApellido= (EditText)findViewById(R.id.txtApellido);
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);

    }

    public void Guardar(View view) {
        if(txtNombre.getText().toString() != " ") {
            Toast.makeText(MainActivity.this, "Todos los campos deben estar llenos", Toast.LENGTH_LONG).show();

        }else{
            Base_datos admin = new Base_datos(this, "persona", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String nombre = txtNombre.getText().toString();
            String apellido = txtApellido.getText().toString();
            String direccion = txtDireccion.getText().toString();
            String correo = txtCorreo.getText().toString();
            ContentValues registro = new ContentValues();
            registro.put("Nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("direccion", direccion);
            registro.put("correo", correo);
            bd.insert("persona", null, registro);
            bd.close();
            Toast.makeText(MainActivity.this, "Se guardaron los datos correctamente", Toast.LENGTH_LONG).show();
            txtNombre.setText("");
            txtApellido.setText("");
            txtDireccion.setText("");
            txtCorreo.setText("");
        }
    }

}
