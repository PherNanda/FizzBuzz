package com.local.fernandagoncalves.fizzbuzz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    private static final String NAMEFILE = "fizzbuzz.txt"; //constante
    //variables
    private Button start;
    private Button test;
    private TextView fizzbuzz;
    private TextView exp_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cableado lógica y vista
        start = (Button)findViewById(R.id.start);
        test = (Button)findViewById(R.id.test);
        fizzbuzz = (TextView)findViewById(R.id.fizzbuzz);
        exp_test = (TextView)findViewById(R.id.exp_test);
        test.setVisibility(View.INVISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //metodo genera la seria apartir de un numero aleatorio
                String resultado = Funciones.generaSerie(fizzbuzz);
                String fechayhora = Funciones.datehourfile();
                creaarchivo(resultado, fechayhora);
                test.setVisibility(View.VISIBLE);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lee el fichero creado con la informacion de las series generadas apartir del numero aleatorio
                //para comprobar que la informacion se haya guardado correctamente
                readfile();

            }
        });
    }

    public void creaarchivo(String resultado, String fechayhora){
        try {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput(NAMEFILE, Context.MODE_APPEND));

            fout.write(resultado+" "+fechayhora+"\n");
            fout.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    //metodo para leer el archivo
    public void readfile(){
        String l="";
        try
        {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput(NAMEFILE)));

            while(true){
                //este ciclo while se usa para repetir el proceso de lectura,
                String texto = fin.readLine();
                if (texto != null)
                    l = l + texto + "\n";
                else
                    break;
            }
            fin.close();
            exp_test.setText(l);
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
            ex.printStackTrace();;
        }
    }

}