package com.example.uf1nf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int contador = 0;
    final int MAX_CLICKS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"Creem l'aplicació", Toast.LENGTH_SHORT).show();


        //Recuperem elements del layout
        final TextView t1 =findViewById(R.id.etiqueta);
        final Button b1 =findViewById(R.id.boto);
        final Button b2 =findViewById(R.id.boto2);

        //Iniciem etiqueta de text
        t1.setText(getResources().getString(R.string.resultat)+contador);


        //afegim listener al botó
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                contador++;
                t1.setText(getResources().getString(R.string.resultat)+contador);

                if(contador==MAX_CLICKS){
                    finish();
                }



            }

        });
        b2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NextActivity.class);
                startActivity(intent);
            }

        });

        }

    //Mètode per guardar el numero de clics
    @Override protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

            savedInstanceState.putInt("contador", contador);

    }

    //Mètode per recuperar el numero de clics
    @Override protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null ) {
            contador = savedInstanceState.getInt("contador");

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"Iniciem l'aplicació", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"Pausem l'aplicació", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"Reiniciem l'aplicació", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Reprenem l'aplicació", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Aturem l'aplicació", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Destruim l'aplicació", Toast.LENGTH_SHORT).show();
    }
}