package com.example.jhgomez.pico_y_placa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class PicoPlaca extends AppCompatActivity {
    RadioGroup group;
    TextView lbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pico_placa);

        lbl = (TextView) findViewById(R.id.txt1);
        group = (RadioGroup) findViewById(R.id.group);
        SharedPreferences prefe = getSharedPreferences("dato", Context.MODE_PRIVATE);
        lbl.setText(prefe.getString("guardar", ""));

        //selecciona una opcion se guarda en un archivo.txt lo seleccionado
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radio1) {
                    lbl.setText("1");
                    SharedPreferences preferencias = getSharedPreferences("dato", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("guardar", lbl.getText().toString());
                    editor.commit();

                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                                "archivo.txt", Activity.MODE_PRIVATE));
                        archivo.write(lbl.getText().toString());
                        archivo.flush();
                        archivo.close();
                    }
                    catch (IOException e)
                    {
                    }

                    cerrar();

                } else if (checkedId == R.id.radio2) {
                    lbl.setText("2");
                    SharedPreferences preferencias = getSharedPreferences("dato", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("guardar", lbl.getText().toString());
                    editor.commit();


                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                                "archivo.txt", Activity.MODE_PRIVATE));
                        archivo.write(lbl.getText().toString());
                        archivo.flush();
                        archivo.close();
                    } catch (IOException e) {
                    }
                    cerrar();

                } else if (checkedId == R.id.radio3) {
                    lbl.setText("3");
                    SharedPreferences preferencias = getSharedPreferences("dato", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("guardar", lbl.getText().toString());
                    editor.commit();

                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                                "archivo.txt", Activity.MODE_PRIVATE));
                        archivo.write(lbl.getText().toString());
                        archivo.flush();
                        archivo.close();
                    } catch (IOException e) {
                    }
                    cerrar();

                } else if (checkedId == R.id.radio4) {
                    lbl.setText("4");
                    SharedPreferences preferencias = getSharedPreferences("dato", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("guardar", lbl.getText().toString());
                    editor.commit();

                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                                "archivo.txt", Activity.MODE_PRIVATE));
                        archivo.write(lbl.getText().toString());
                        archivo.flush();
                        archivo.close();
                    } catch (IOException e) {
                    }
                    cerrar();
                } else if (checkedId == R.id.radio5) {
                    lbl.setText("5");
                    SharedPreferences preferencias = getSharedPreferences("dato", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("guardar", lbl.getText().toString());
                    editor.commit();

                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                                "archivo.txt", Activity.MODE_PRIVATE));
                        archivo.write(lbl.getText().toString());
                        archivo.flush();
                        archivo.close();
                    } catch (IOException e) {
                    }
                    cerrar();

                }

            }

        });
    }


    public void cerrar()
    {
        Intent i = new Intent(this, Intro.class);
        startActivity(i);
        finish();
    }

    public void guardar()
    {
        Intent i = new Intent(this, Intro.class);
        startActivity(i);
        finish();
    }
}