package cl.kafecode.contacts;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PortraitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_detail);

        FragmentManager manager = getFragmentManager();
        Fragment frag = manager.findFragmentById(R.id.holder_fragment_detail);

        int position = 0;
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            position = extras.getInt("position");
        }

        if(frag == null){
            frag = AddressDetailFragment.newInstance(position);
        }

        manager.beginTransaction()
                .add(R.id.holder_fragment_detail, frag)
                .commit();
    }
}
