package com.example.evaluacin2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private EditText ed;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        ed = (EditText)findViewById(R.id.et_contraseña);
        tv = (TextView)findViewById(R.id.tv_seguridad);
    }

    private SecretKeySpec generateKey(String password) throws Exception {

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sha.digest(key);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        return secretKey;
    }

    public String Encriptar(String datos, String password) throws Exception{
        if(!ed.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);

            return datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this, "Debe ingresar una clave", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void Encriptar(View v)
    {
        try{

            String mensaje = Encriptar(ed.getText().toString(), tv.getText().toString());
            tv.setText(mensaje);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}