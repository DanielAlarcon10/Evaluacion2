package com.example.evaluacin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed_1;
    private EditText ed_2;
    private ProgressBar progress;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_1 = (EditText)findViewById(R.id.et_codigo);
        ed_2 = (EditText)findViewById(R.id.et_nombre);
        progress = (ProgressBar)findViewById(R.id.pb);
        progress.setVisibility(View.INVISIBLE);
        btn = (Button)findViewById(R.id.iniciar_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                new task().execute();
                String user = ed_1.getText().toString();
                String pass = ed_2.getText().toString();

                if(user.equals("android") && pass.equals("123"))
                {
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                else if(user.equals("ANDROID") && pass.equals("123"))
                {
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    class task extends AsyncTask<String, Void, String> {

        @Override
        public void onPreExecute()
        {
            progress.setVisibility(View.VISIBLE);
        }

        @Override //tarea pesada
        protected String doInBackground(String... strings) {

            for(int i = 0; i <=10; i++)
            {
                try
                {
                    Thread.sleep(1000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        public void onPostExecute(String s)
        {
            progress.setVisibility(View.INVISIBLE);
        }

    }


}