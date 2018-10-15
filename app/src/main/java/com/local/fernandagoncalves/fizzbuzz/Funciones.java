package com.local.fernandagoncalves.fizzbuzz;

import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Funciones {

    private static final int MAXIMO = 100; //constante
    private static int numeroAleatorio;

    //genera numero aleatorio y la seria apartir de ese numero
    public static String generaSerie(TextView fizzbuzz){
        StringBuilder sb = new StringBuilder();
        numeroAleatorio = (int) (Math.random()*MAXIMO+1);
        System.out.println("aleatorio: "+numeroAleatorio);
        String resultado;

        for (int i = numeroAleatorio; i <= MAXIMO; i++) {
            if (i % 15 == 0) {
                String a = "FizzBuzz ";
                sb.append(a);
            } else if (i % 3 == 0) {
                String b = "Fizz ";
                sb.append(b);
            } else if (i % 5 == 0) {
                String c = "Buzz ";
                sb.append(c);
            } else {
                String d = String.valueOf(i)+" ";
                sb.append(d);
            }
        }
        resultado = sb.toString();
        fizzbuzz.setText(resultado);
        return resultado;
    }

    //metodo donde se crea el archivo,alamcena la informacion cn fecha y hora
    public static String datehourfile(){
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String fechayhora = hourdateFormat.format(date);
        return fechayhora;

    }
}
