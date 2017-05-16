package com.example.jhgomez.pico_y_placa;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Intro extends AppCompatActivity {
    /*
    * estan todos los pico y placa del año
    * primer numero es el mes, segundo numero el dia, tercero a que placa aplica...  1= "0-1", 2= "2-3".....
    */
    String[] picoPlaca = {"1-5-1", "1-11-1", "1-17-1", "1-23-1", "1-6-2", "1-12-2", "1-18-2", "1-24-2", "1-30-2", "1-13-3", "1-19-3", "1-25-3", "1-31-3", "1-3-4", "1-20-4", "1-26-4", "1-4-5", "1-10-5", "1-16-5", "1-27-5",
            "2-3-1", "2-9-1", "2-15-1", "2-21-1", "2-27-1", "2-10-2", "2-16-2", "2-22-2", "2-28-2", "2-6-3", "2-17-3", "2-23-3", "2-1-4", "2-7-4", "2-13-4", "2-24-4", "2-2-5", "2-8-5", "2-14-5", "2-20-5",
            "3-10-1", "3-16-1", "3-22-1", "3-28-1", "3-6-2", "3-17-2", "3-23-2", "3-29-2", "3-1-3", "3-7-3", "3-13-3", "3-24-3", "3-30-3", "3-2-4", "3-8-4", "3-14-4", "3-31-4", "3-3-5", "3-9-5", "3-15-5", "3-21-5", "3-27-5",
            "4-3-1", "4-20-1", "4-26-1", "4-4-2", "4-10-2", "4-21-2", "4-27-2", "4-5-3", "4-11-3", "4-17-3", "4-28-3", "4-6-4", "4-12-4", "4-18-4", "4-24-4", "4-7-5", "4-19-5", "4-25-5",
            "5-2-1", "5-8-1", "5-19-1", "5-25-1", "5-31-1", "5-3-2", "5-9-2", "5-15-2", "5-26-2", "5-4-3", "5-10-3", "5-16-3", "5-22-3", "5-5-4", "5-11-4", "5-17-4", "5-23-4", "5-12-5", "5-18-5", "5-24-5", "5-30-5",
            "6-6-1", "6-12-1", "6-23-1", "6-29-1", "6-1-2", "6-7-2", "6-13-2", "6-30-2", "6-2-3", "6-8-3", "6-14-3", "6-20-3", "6-9-4", "6-15-4", "6-21-4", "6-27-4", "6-5-5", "6-16-5", "6-22-5", "6-28-5",
            "7-5-1", "7-11-1", "7-17-1", "7-28-1", "7-6-2", "7-12-2", "7-18-2", "7-24-2", "7-7-3", "7-13-3", "7-19-3", "7-25-3", "7-31-3", "7-14-4", "7-26-4", "7-4-5", "7-10-5", "7-21-5", "7-27-5",
            "8-3-1", "8-9-1", "8-15-1", "8-4-2", "8-10-2", "8-16-2", "8-22-2", "8-28-2", "8-11-3", "8-17-3", "8-23-3", "8-29-3", "8-1-4", "8-18-4", "8-24-4", "8-30-4", "8-2-5", "8-8-5", "8-14-5", "8-25-5", "8-31-5",
            "9-1-1", "9-7-1", "9-13-1", "9-19-1", "9-25-1", "9-8-2", "9-14-2", "9-20-2", "9-26-2", "9-4-3", "9-15-3", "9-21-3", "9-27-3", "9-5-4", "9-11-4", "9-22-4", "9-28-4", "9-6-5", "9-12-5", "9-18-5", "9-29-5",
            "10-6-1", "10-12-1", "10-18-1", "10-24-1", "10-30-1", "10-13-2", "10-19-2", "10-25-2", "10-31-2", "10-3-3", "10-9-3", "10-20-3", "10-26-3", "10-4-4", "10-10-4", "10-16-4", "10-27-4", "10-5-5", "10-11-5", "10-17-5", "10-23-5",
            "11-10-1", "11-16-1", "11-22-1", "11-28-1", "11-6-2", "11-17-2", "11-23-2", "11-29-2", "11-1-3", "11-7-3", "11-13-3", "11-24-3", "11-30-3", "11-2-4", "11-8-4", "11-14-4", "11-3-5", "11-9-5", "11-15-5", "11-21-5", "11-27-5",
            "12-4-1", "12-15-1", "12-21-1", "12-27-1", "12-5-2", "12-11-2", "12-22-2", "12-28-2", "12-6-3", "12-12-3", "12-18-3", "12-29-3", "12-1-4", "12-7-4", "12-13-4", "12-19-4", "12-14-5", "12-20-5", "12-26-5"};

    Button btnPico;
    Date d = new Date();
    TextView pico;
    TextView miPlaca;
    TextView txtProx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        pico = (TextView) findViewById(R.id.txtoculto);
        txtProx = (TextView) findViewById(R.id.txtProx);

        //mostrat pico y placa del dia
        picoDelDia();
        // mostrar la placa seleccionada
        miPlaca();
        //mostrar el proximo pico y placa
        proximoPico();


    }

    /*
    * Método mostrar el pico y placa del dia
     */
    public void picoDelDia() {

        btnPico = (Button) findViewById(R.id.button);

        //numero del mes
        SimpleDateFormat mes = new SimpleDateFormat("M");
        String mesNum = mes.format(d);

        //dia actual
        SimpleDateFormat dia = new SimpleDateFormat("d");
        String diaNum = dia.format(d);


        // recorrer el arreglo donde estan los dias de pico y placa
        boolean existe = false;
        for (int i = 0; i < picoPlaca.length && !existe; i++) {
            //se concatena la fecha con 1 para ver si es 0-1
            String fecha = mesNum + "-" + diaNum + "-1";
            String fecha2 = mesNum + "-" + diaNum + "-2";
            String fecha3 = mesNum + "-" + diaNum + "-3";
            String fecha4 = mesNum + "-" + diaNum + "-4";
            String fecha5 = mesNum + "-" + diaNum + "-5";

            //se compara la fecha actual con las guardadas
            if (fecha.equals(picoPlaca[i] + "")) {
                btnPico.setText("0 - 1");
                existe = true;

            } else if (fecha2.equals(picoPlaca[i] + "")) {
                btnPico.setText("2 - 3");
                existe = true;

            } else if (fecha3.equals(picoPlaca[i] + "")) {
                btnPico.setText("4 - 5");
                existe = true;

            } else if (fecha4.equals(picoPlaca[i] + "")) {
                btnPico.setText("6 - 7");
                existe = true;

            } else if (fecha5.equals(picoPlaca[i] + "")) {
                btnPico.setText("8 - 9");
                existe = true;

            }
            if (!existe) {
                btnPico.setText("Sin pico");
            }
        }

    }

    //metodo para mostrar la placa guardada
    public void miPlaca() {
        //leer el archivo donde esta la placa seleccionada
        miPlaca = (TextView) findViewById(R.id.txtPlaca);
        String[] file = fileList();
        if (buscar(file, "archivo.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput("archivo.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();

                br.close();
                archivo.close();
                pico.setText(linea);
            } catch (IOException e)
            {

            }

        //si el dato recuperado es 1 mi placa es 0-1, si es 2 mi placa es 2-3... asi suscesivamente
        if (pico.getText().equals("1")) {
            miPlaca.setText("0-1");
        } else if (pico.getText().equals("2")) {
            miPlaca.setText("2-3");
        } else if (pico.getText().equals("3")) {
            miPlaca.setText("4-5");
        } else if (pico.getText().equals("4")) {
            miPlaca.setText("6-7");
        } else if (pico.getText().equals("5")) {
            miPlaca.setText("8-9");
        }

    }

    //método que ejecuta el próximo pico y placa
    public void proximoPico() {

        //cual es el numero del mes
        SimpleDateFormat mes = new SimpleDateFormat("M");
        String mesNum = mes.format(d);

        //cual es el dia actual
        SimpleDateFormat dia = new SimpleDateFormat("d");
        String diaNum = dia.format(d);

        //se concatena la fecha
        String fecha = mesNum + "-" + diaNum + "-" + pico.getText();

        boolean exis = false;
        int a = 0;
        String comp = pico.getText() + "";
        for (int i = 0; i < picoPlaca.length && !exis; i++) {

            String[] cortar = picoPlaca[i].split("-");

            if (mesNum.equals(cortar[0] + "") && comp.equals(cortar[2] + "")) {

                a = i;
                exis = true;
            }

        }
        boolean exis1 = false;
        int o = picoPlaca.length;
        for (int g = a; g < picoPlaca.length && !exis1; g++) {

            String[] cortar1 = picoPlaca[g].split("-");
            int dia1 = Integer.parseInt(diaNum);
            int dia2 = Integer.parseInt(cortar1[1]);
            if (mesNum.equals(cortar1[0] + "") && comp.equals(cortar1[2] + "")) {
                if (dia1 < dia2) {
                    txtProx.setText(cortar1[1] + " del mes " + cortar1[0]);
                    exis1 = true;

                }
            } else if (!(mesNum.equals(cortar1[0]+"")) && comp.equals(cortar1[2] + "")) {
                txtProx.setText(cortar1[1] + " del mes " + cortar1[0]);
                exis1 = true;
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, PicoPlaca.class);
            startActivity(i);
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //busacar en el archivo archivo.txt
    private boolean buscar(String[] archivo, String encontrar) {
        for (int i = 0; i < archivo.length; i++)
            if (encontrar.equals(archivo[i]))
                return true;
        return false;
    }
}
