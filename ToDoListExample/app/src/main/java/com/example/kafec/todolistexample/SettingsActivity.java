package com.example.kafec.todolistexample;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences mPrefs; //Para leer
    private SharedPreferences.Editor mEditor; // para escribir

    private boolean mSound;

    //TIPOS de Animaciones
    public static final int FAST = 0;
    public static final int SLOW = 1;
    public static final int NONE = 2;

    private int mAnimationOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mPrefs = getSharedPreferences("To Do List", MODE_PRIVATE);
        mEditor = mPrefs.edit();


        //Activar o desactivar sonido
        mSound = mPrefs.getBoolean("sound", true);
        final CheckBox checkBoxSound = (CheckBox)findViewById(R.id.sound_checkbox);

        if(mSound){
            checkBoxSound.setChecked(true);
        }else{
            checkBoxSound.setChecked(false);
        }

        checkBoxSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                //Si el sonido estaba en marcha lo apagamos
                //Si el sonido estaba apagado, lo prendemos
                mSound = !mSound;

                mEditor.putBoolean("sound", mSound);

                //mEditor.commit();
            }
        });


        //Tipo Animaciones
        mAnimationOption = mPrefs.getInt("anim option", FAST);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group_anim);

        radioGroup.clearCheck();//deselecciona todos los check del grupo

        switch (mAnimationOption){
            case FAST:
                radioGroup.check(R.id.rbFast);
                break;
            case SLOW:
                radioGroup.check(R.id.rbSlow);
                break;
            case NONE:
                radioGroup.check(R.id.rbNone);
                break;
        }

        //Cambiar opcion
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                //recuperar el radiobuton seleccionado por el usuario a traves del checked ID
                RadioButton rb = (RadioButton)radioGroup.findViewById(checkedId);

                if(null != rb && checkedId > -1){
                   switch (rb.getId()){
                       case R.id.rbFast:
                           mAnimationOption = FAST;
                           break;
                       case R.id.rbSlow:
                           mAnimationOption = SLOW;
                           break;
                       case R.id.rbNone:
                           mAnimationOption = NONE;
                           break;
                   }

                   mEditor.putInt("anim option", mAnimationOption);

                   //mEditor.commit();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        mEditor.commit();
    }
}
