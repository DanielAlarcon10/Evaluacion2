package com.example.evaluacin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.adminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    private EditText edCodigo, edNombre, edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edCodigo = (EditText)findViewById(R.id.et_codigo);
        edNombre = (EditText)findViewById(R.id.et_nombre);
        edSalario = (EditText)findViewById(R.id.et_salario);
    }

    public void Guardar(View v)
    {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(!edCodigo.getText().toString().isEmpty())
        {
            ContentValues cont = new ContentValues();

            cont.put("codigo", edCodigo.getText().toString());
            cont.put("nombre", edNombre.getText().toString());
            cont.put("salario", edSalario.getText().toString());

            db.insert("banco", null, cont);
            db.close();

            Toast.makeText(this, "Has guardado un cliente", Toast.LENGTH_LONG).show();

            edCodigo.setText("");
            edNombre.setText("");
            edSalario.setText("");
        }
        else
        {
            Toast.makeText(this, "Debe ingresar el codigo del cliente", Toast.LENGTH_LONG).show();
        }
    }

    public void Mostrar(View v)
    {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM banco WHERE codigo="+codigo, null);

            if(fila.moveToFirst())
            {
                edNombre.setText(fila.getString(0));
                edSalario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "No hay campos en la tabla banco", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "No hay clientes con el codigo asociado", Toast.LENGTH_LONG).show();
        }
    }

    public void Eliminar(View v)
    {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        db.delete("banco", "codigo="+codigo, null);
        db.close();

        Toast.makeText(this, "Has eliminado un cliente", Toast.LENGTH_LONG).show();
    }

    public void Actualizar(View v)
    {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edCodigo.getText().toString());
        cont.put("nombre", edNombre.getText().toString());
        cont.put("salario", edSalario.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("banco", cont, "codigo="+codigo, null);
            db.close();
            Toast.makeText(this, "ha actualizado un cliente", Toast.LENGTH_LONG).show();
        }
    }
}