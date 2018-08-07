package cl.kafecode.singlefragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();

        //creamos un nuevo fragment usando el manager
        Fragment frag = manager.findFragmentById(R.id.fragment_holder);

        //solo lo inflaremos si no esta creado con anterioridad
        if(frag == null){

            //inicializamos el singlefragment
            frag = new SingleFragment();
            manager.beginTransaction()
                    .add(R.id.fragment_holder, frag)
                    .commit();
        }

    }
}
