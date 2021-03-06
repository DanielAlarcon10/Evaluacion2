package com.example.evaluacin2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import Clases.Saldos;

public class Prestamos_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spin1 = (Spinner)findViewById(R.id.spn1);
        spin2 = (Spinner)findViewById(R.id.spn2);
        text = (TextView)findViewById(R.id.text_prestamos);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPrestamos = (ArrayList<String>) getIntent().getSerializableExtra("listaPrestamos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> prest = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPrestamos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(prest);
    }

    public void prestamos(View v)
    {
        String cliente = spin1.getSelectedItem().toString();
        String prestamos = spin2.getSelectedItem().toString();

        Saldos saldo = new Saldos();

        int AxelHip = saldo.getSaldoAxel() + saldo.getValorHipotecario();
        int AxelAut = saldo.getSaldoAxel() + saldo.getValorAutomotriz();
        int RoxHip = saldo.getSaldoRoxana() + saldo.getValorHipotecario();
        int RoxAut = saldo.getSaldoRoxana() + saldo.getValorAutomotriz();
        int BetHip = saldo.getSaldoBetzabe() + saldo.getValorHipotecario();
        int BetAut = saldo.getSaldoBetzabe() + saldo.getValorAutomotriz();
        int MatHip= saldo.getSaldoMatias() + saldo.getValorHipotecario();
        int MatAut= saldo.getSaldoMatias() + saldo.getValorAutomotriz();

        if(cliente.equals("Axel") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su nuevo saldo es: "+ AxelHip);
        }

        if(cliente.equals("Axel") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su nuevo saldo es: "+ AxelAut);
        }

        if(cliente.equals("Roxana") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su nuevo saldo es: "+ RoxHip);
        }

        if(cliente.equals("Roxana") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su nuevo saldo es: "+ RoxAut);
        }

        if(cliente.equals("Betzabe") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su nuevo saldo es: "+ BetHip);
        }

        if(cliente.equals("Betzabe") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su nuevo saldo es: "+ BetAut);
        }

        if(cliente.equals("Matias") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su nuevo saldo es: "+ MatHip);
        }

        if(cliente.equals("Matias") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su nuevo saldo es: "+ MatAut);
        }

    }

    public void deudas(View v)
    {
        String cliente = spin1.getSelectedItem().toString();
        String prestamos = spin2.getSelectedItem().toString();

        Saldos deuda = new Saldos();

        int AxelHipDeuda = deuda.getSaldoAxel() + deuda.getValorHipotecario();
        int AxelHipCuota = AxelHipDeuda / deuda.getDeudaHipotecario();
        int AxelAutDeuda = deuda.getSaldoAxel() + deuda.getValorAutomotriz();
        int AxelAutCuota = AxelAutDeuda / deuda.getDeudaAutomotriz();
        int RoxHipDeuda = deuda.getSaldoRoxana() + deuda.getValorHipotecario();
        int RoxHipCuota = RoxHipDeuda / deuda.getDeudaHipotecario();
        int RoxAutDeuda = deuda.getSaldoRoxana() + deuda.getValorAutomotriz();
        int RoxAutCuota = RoxAutDeuda / deuda.getDeudaAutomotriz();
        int BetHipDeuda = deuda.getSaldoBetzabe() + deuda.getValorHipotecario();
        int BetHipCuota = BetHipDeuda / deuda.getDeudaHipotecario();
        int BetAutDeuda = deuda.getSaldoBetzabe() + deuda.getValorAutomotriz();
        int BetAutCuota = BetAutDeuda / deuda.getDeudaAutomotriz();
        int MatHipDeuda = deuda.getSaldoMatias() + deuda.getValorHipotecario();
        int MatHipCuota = MatHipDeuda / deuda.getDeudaHipotecario();
        int MatAutDeuda = deuda.getSaldoMatias() + deuda.getValorAutomotriz();
        int MatAutCuota = MatAutDeuda / deuda.getDeudaAutomotriz();

        if(cliente.equals("Axel") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su deuda es de: "+ AxelHipCuota);
        }

        if(cliente.equals("Axel") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su deuda es de: "+ AxelAutCuota);
        }

        if(cliente.equals("Roxana") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su deuda es de: "+ RoxHipCuota);
        }

        if(cliente.equals("Roxana") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su deuda es de: "+ RoxAutCuota);
        }

        if(cliente.equals("Betzabe") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su deuda es de: "+ BetHipCuota);
        }

        if(cliente.equals("Betzabe") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su deuda es de: "+ BetAutCuota);
        }

        if(cliente.equals("Matias") && prestamos.equals("Credito Hipotecario"))
        {
            text.setText("Su deuda es de: "+ MatHipCuota);
        }

        if(cliente.equals("Matias") && prestamos.equals("Credito Automotriz"))
        {
            text.setText("Su deuda es de: "+ MatAutCuota);
        }


    }
}