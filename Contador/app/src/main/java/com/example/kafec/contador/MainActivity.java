package com.example.kafec.contador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Variable para sostener el valor entero que vamos a mostrar
    private int value = 0;

    //variables para los 6 botones y la textView
    private TextView textView;
    private Button btnAdd, btnTake, btnGrow, btnShrink, btnHide, btnReset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se inicializan y vinculan los widget al xml
        //(La mejor zona es dentro del onCreate)
        textView = (TextView) findViewById(R.id.text_view);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTake = (Button) findViewById(R.id.btnTake);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnShrink = (Button) findViewById(R.id.btnShrink);
        btnHide = (Button) findViewById(R.id.btnHide);
        btnReset = (Button) findViewById(R.id.btnReset);

        //Indicamos que todos los botones lanzaran el mismo OnClick
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnReset.setOnClickListener(this);


    }


    // todos los click entraran a este onclick
    @Override
    public void onClick(View view) {

        //Log.i("Main Activity", "OnClick "+view.getId());
        Toast.makeText(this, "OnClick "+view.getId(), Toast.LENGTH_SHORT).show();
        float scale;


        //segun el boton hago la logica
        switch (view.getId()){

            case R.id.btnAdd:
                value++;
                textView.setText(""+value);
                break;

            case R.id.btnTake:
                value--;
                textView.setText(""+value);
                break;

            case R.id.btnReset:
                value = 0;
                textView.setText(""+value);
                break;

            case R.id.btnGrow:
                //incrementar el tamaño del texto
                scale = textView.getTextScaleX();
                scale = scale+1;
                textView.setTextScaleX(scale);

                break;

            case R.id.btnShrink:
                //decrementar el tamaño del texto
                scale = textView.getTextScaleX();
                scale = scale-1;
                textView.setTextScaleX(scale);

                break;

            case R.id.btnHide:
                //Ocultar/mostrar textview

                if(textView.getVisibility() == View.VISIBLE){
                    //En este caso la vista esta visible, debemos ocultarla
                    textView.setVisibility(View.INVISIBLE);
                    btnHide.setText("Mostrar");
                }else{
                    textView.setVisibility(View.VISIBLE);
                    btnHide.setText("Ocultar");
                }

                break;

        }

    }
}
