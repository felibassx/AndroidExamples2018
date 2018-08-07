package cl.kafecode.singletonpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActivityComs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utilizacion del singleton
        RentalStore rs = RentalStore.getInstance();

        ArrayList<Movie> myMovies = rs.getMovies();

    }

    @Override
    public void onListItemSelected(Movie theMovie) {
        Toast.makeText(this, theMovie.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
