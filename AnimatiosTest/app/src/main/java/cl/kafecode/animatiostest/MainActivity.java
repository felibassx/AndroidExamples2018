package cl.kafecode.animatiostest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  Animation.AnimationListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener referencia al widget
        TextView tv = (TextView)findViewById(R.id.tv);

        //Obtener referencia a la animacion
        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_scale);
        animation.setAnimationListener(this);

        //Indicar al widget que ejecute la animacion
        tv.startAnimation(animation);

    }

    @Override
    public void onAnimationStart(Animation animation) {
        Log.d(TAG, "Ha empezado la animación");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.d(TAG, "Ha finalizado la animación");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Log.d(TAG, "Se está repitiendo la animación");
    }
}
