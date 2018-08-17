package cl.kafecode.snapmap;

import android.support.v7.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private ListView mNavDrawerListView;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void switchFragment(int position){

        Fragment fragment = null;
        String fragmentID = "";

        switch (position){
            case 0:
                fragmentID = "TITLES";

                Bundle args = new Bundle();

                args.putString("Tag","_NO_TAG");
                //fragment = new TitlesFragment();

                break;

            case 1:
                fragmentID = "TAGS";
                break;

            case 2:
                fragmentID = "CAPTURE";
                break;

            default:

                break;
        }

    }
}
