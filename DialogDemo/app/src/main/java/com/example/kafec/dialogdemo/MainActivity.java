package com.example.kafec.dialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInvocarAlerta = (Button)findViewById(R.id.btn_invocar_alerta);

        //On click del boton
        btnInvocarAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instanciar al MyFirstDialog
                MyFristDialog dialog = new MyFristDialog();

                //Aquí mostraremos un dialogo en pantalla que tien por identificador 1234
                dialog.show(getSupportFragmentManager(), "1234");


            }
        });

    }
}
