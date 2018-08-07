package cl.kafecode.singlefragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SingleFragment extends Fragment {

    String myString;
    Button myButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myString = "Hola estoy en un fragment";

    }


    //onCreateView, sirve para inicializar los elementos de la interfaz grafica
    //ya que estos no pueden inicializarse en el onCreate como en las activities.
    //el método devuelve una View
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        //el parametro ViewGroup container es la zona que va a contener el fregment

        //se vincula el layout del fragment,
        //se infla el layout
        //se indica si se va a reutilizar la vista
        View v = inflater.inflate(R.layout.fragment_layout, container, false);

         myButton = (Button)v.findViewById(R.id.button);

         myButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(), myString, Toast.LENGTH_SHORT).show();
             }
         });

        return v;
    }
}
