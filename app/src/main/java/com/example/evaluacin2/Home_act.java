package com.example.evaluacin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[]images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i <images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        //configurar

        vf.addView(view); //añadir imagenes
        vf.setAutoStart(true); //inicio automatico
        vf.setFlipInterval(2800); //velocidad de cambio
        //sentido del slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Clientes(View v)
    {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }

    public void Prestamos(View v)
    {
        ArrayList<String> clientes = new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");
        clientes.add("Betzabe");
        clientes.add("Matias");

        ArrayList<String> prestamos = new ArrayList<String>();

        prestamos.add("Credito Hipotecario");
        prestamos.add("Credito Automotriz");

        Intent i = new Intent(this, Prestamos_act.class);
        i.putExtra("listaClientes", clientes);
        i.putExtra("listaPrestamos", prestamos);
        startActivity(i);
    }

    public void Seguridad(View v)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }

    public void Informacion(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

}