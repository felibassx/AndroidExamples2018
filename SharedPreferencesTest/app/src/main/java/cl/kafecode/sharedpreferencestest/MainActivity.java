package cl.kafecode.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PREFERENCIAS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Preferencias guardadas en el disco (solo lectura)
        SharedPreferences prefs = getSharedPreferences("My App Name", MODE_PRIVATE);

        //Preferencias para leer y escribir (Versión Editable)
        SharedPreferences.Editor editor = prefs.edit();


        /**
        //GUARDAR PREFS


        String username = "fhernandez";
        int age = 37;
        boolean knowsHowToMakeApps = true;


        //Guardar las preferencias
        editor.putString("username", username);
        editor.putInt("age", age);
        editor.putBoolean("knowHowToMakeApps", knowsHowToMakeApps);

        editor.commit();//Guarda la información en disco
         **/

        //LEER PREFS
        String username = prefs.getString("username", "nuevo usuario");//2do valor si no existe
        int age = prefs.getInt("age", -1);
        boolean knowHowToMakeApps = prefs.getBoolean("knowHowToMakeApps", false);

        Log.d(TAG, "El usuario se llama " + username + ", tiene "+age+" años y " +
                (knowHowToMakeApps? "sabe programar.": "no sabe programar."));


        //utilizar el valor por defectos
        if(username.compareTo("nombre usuario") == 0){
            //Mostrar pantalla para crear un nombre de usuario
        }





    }
}
