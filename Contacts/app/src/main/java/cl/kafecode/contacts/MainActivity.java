package cl.kafecode.contacts;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActivityComs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_fragment);

        FragmentManager manager = getFragmentManager();

        Fragment fragment = manager.findFragmentById(R.id.list_fragment_holder);

        if(fragment == null){
            fragment = new AddressListFragment();

            manager.beginTransaction()
                    .add(R.id.list_fragment_holder, fragment)
                    .commit();
        }


    }

    @Override
    public void onListItemSelected(int position) {
        //este metodo se llama cuando han seleccionado un contacto
        if(findViewById(R.id.holder_fragment_detail) == null){
            //estoy en vertical
            Intent i = new Intent(this, PortraitDetailActivity.class);
            i.putExtra("position",position);
            startActivity(i);

        }else{
            //estoy en horizontal
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            Fragment oldfrag = manager.findFragmentById(R.id.holder_fragment_detail);
            Fragment newfrag = AddressDetailFragment.newInstance(position);

            //si estaba mostrando otro contacto, lo eliminará y mostrará el que se pincho
            if(oldfrag != null){
                transaction.remove(oldfrag);
            }

            transaction.add(R.id.holder_fragment_detail, newfrag);
            transaction.commit();

        }
    }
}
