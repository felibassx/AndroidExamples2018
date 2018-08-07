package cl.kafecode.singletonpattern;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

public class SomeFragment extends Fragment {
    private ActivityComs mActivityComs;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mActivityComs = (ActivityComs) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mActivityComs = null;
    }

    public void someBullyFunction(){

        Movie m = new Movie();

        m.setTitle("Lo que el viento se llevó");
        m.setOnRental(true);

        mActivityComs.onListItemSelected(m);
    }
}
