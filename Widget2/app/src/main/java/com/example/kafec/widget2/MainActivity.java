package com.example.kafec.widget2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_layout);

        CalendarView mycalendarView = (CalendarView)findViewById(R.id.calendarView);


        /**
        WebView wvMyWebview = (WebView)findViewById(R.id.wv_webview);

        wvMyWebview.loadUrl("http://www.google.cl");
        final TextView tvGenero = (TextView)findViewById(R.id.tv_genero);
        final TextView tvSwitch = (TextView)findViewById(R.id.tv_switch);
        final TextView tvCheckbox = (TextView)findViewById(R.id.tv_checkbox);


        //RadioButtonGroup
        RadioGroup rbgGroup = (RadioGroup)findViewById(R.id.rbg_grupo);

        //obtener informacion de los checkbox dentro del groupcheck
        rbgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                RadioButton rb = (RadioButton) radioGroup.findViewById(checkedId);

                tvGenero.setText(rb.getText().toString());
            }
        });


        //Switch Button
        Switch swOnoff = (Switch)findViewById(R.id.sw_onoff);

        swOnoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if(ischecked){
                    tvSwitch.setText("Prendido");
                }else{
                    tvSwitch.setText("Apagado");
                }
            }
        });


        //CheckBox
        CheckBox chActivo = (CheckBox)findViewById(R.id.ch_activo);

        chActivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if(ischecked){
                    tvCheckbox.setText("Activo");
                }else{
                    tvCheckbox.setText("Inactivo");
                }
            }
        });




        TextView myTextView = (TextView)findViewById(R.id.tv_hello);
        myTextView.setText("Hola, hoy es Jueves!");

        //Botón desde el código
        Button myButton = new Button(this);
        myButton.setText("My Button");

        //Meter el botón en layout
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear_layout);
        linearLayout.setPadding(39,39,39,39);
        linearLayout.addView(myButton);
         **/




    }


}
