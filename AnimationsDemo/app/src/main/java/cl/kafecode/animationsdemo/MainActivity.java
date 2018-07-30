package cl.kafecode.animationsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {

    //declaramos las 12 animaciones
    Animation animFadeIn, animFadeOut, animFadeInOut,
                animZoomIn, animZoomOut,
                animLeftRight, animRightLeft, animTopBottom,
                animBounce, animFlash,
                animRotateLeft, animRotateRight;

    ImageView imageView;
    TextView textViewStatus;

    Button btnFadeIn, btnFadeOut, btnFadeInOut,
            btnZoomIn, btnZoomOut,
            btnLeftRight, btnRightLeft, btnTopBottom,
            btnBounce, btnFlash,
            btnRotateLeft, btnRotateRight;

    SeekBar seekBarSpeed;
    TextView textViewSeekSpeed;

    int seekSpeedprogress;

    //Declaro dos métodos para realizar la carga de los objetos loadAnimation() y loadUI()
    //Con la finalidad de no cargar de código el OnCreate()
    private void loadAnimation(){

        animFadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        animFadeIn.setAnimationListener(this);

        animFadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        animFadeOut.setAnimationListener(this);

        animFadeInOut = AnimationUtils.loadAnimation(this,R.anim.fade_in_out);
        animFadeInOut.setAnimationListener(this);

        animZoomIn = AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        animZoomIn.setAnimationListener(this);

        animZoomOut = AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        animZoomOut.setAnimationListener(this);

        animLeftRight = AnimationUtils.loadAnimation(this,R.anim.left_right);
        animLeftRight.setAnimationListener(this);

        animRightLeft = AnimationUtils.loadAnimation(this,R.anim.right_left);
        animRightLeft.setAnimationListener(this);

        animTopBottom = AnimationUtils.loadAnimation(this,R.anim.top_bottom);
        animTopBottom.setAnimationListener(this);

        animBounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        animBounce.setAnimationListener(this);

        animFlash = AnimationUtils.loadAnimation(this,R.anim.flash);
        animFlash.setAnimationListener(this);

        animRotateLeft = AnimationUtils.loadAnimation(this,R.anim.rotate_left);
        animRotateLeft.setAnimationListener(this);

        animRotateRight = AnimationUtils.loadAnimation(this,R.anim.rotate_right);
        animRotateRight.setAnimationListener(this);



    }

    private void loadUI(){

        imageView = (ImageView)findViewById(R.id.image_view);
        textViewStatus = (TextView)findViewById(R.id.text_status);

        //Botones
        btnFadeIn = (Button)findViewById(R.id.btn_fadein);
        btnFadeIn.setOnClickListener(this);

        btnFadeOut  = (Button)findViewById(R.id.btn_fadeout);
        btnFadeOut.setOnClickListener(this);

        btnFadeInOut = (Button)findViewById(R.id.btn_fadeinout);
        btnFadeInOut.setOnClickListener(this);

        btnZoomIn  = (Button)findViewById(R.id.btn_zoomin);
        btnZoomIn.setOnClickListener(this);

        btnZoomOut = (Button)findViewById(R.id.btn_zoomout);
        btnZoomOut.setOnClickListener(this);

        btnLeftRight  = (Button)findViewById(R.id.btn_leftright);
        btnLeftRight.setOnClickListener(this);

        btnRightLeft  = (Button)findViewById(R.id.btn_rightleft);
        btnRightLeft.setOnClickListener(this);

        btnTopBottom = (Button)findViewById(R.id.btn_topbottom);
        btnTopBottom.setOnClickListener(this);

        btnBounce  = (Button)findViewById(R.id.btn_bounce);
        btnBounce.setOnClickListener(this);

        btnFlash = (Button)findViewById(R.id.btn_flash);
        btnFlash.setOnClickListener(this);

        btnRotateLeft  = (Button)findViewById(R.id.btn_rotateleft);
        btnRotateLeft.setOnClickListener(this);

        btnRotateRight = (Button)findViewById(R.id.btn_rotateright);
        btnRotateRight.setOnClickListener(this);

        textViewSeekSpeed = (TextView)findViewById(R.id.text_view_seek_speed);
        seekBarSpeed = (SeekBar)findViewById(R.id.seekBarSpeed);

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currentValue, boolean moveFromUser) {
                //Detecta un movimiento en la SeekBar

                seekSpeedprogress = currentValue;
                textViewSeekSpeed.setText(seekSpeedprogress + "/"+seekBarSpeed.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //detecta que el usuario empieza a mover una seek bar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Detecta cuando el usuario termina de mover la seek bar

            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadAnimation();
        loadUI();

    }


    //Implementación del AnimationListener
    @Override
    public void onAnimationStart(Animation animation) {
        textViewStatus.setText("RUNNING...");

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textViewStatus.setText("STOPPED...");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        textViewStatus.setText("REPEATING...");

    }

    @Override
    public void onClick(View view) {

        //Verificamos que boton fue presionado
        switch (view.getId()){
            case R.id.btn_fadein:
                animFadeIn.setDuration(seekSpeedprogress);
                imageView.startAnimation(animFadeIn);
                break;

            case R.id.btn_fadeout:
                animFadeOut.setDuration(seekSpeedprogress);
                imageView.startAnimation(animFadeOut);
                break;

            case R.id.btn_fadeinout:
                animFadeInOut.setDuration(seekSpeedprogress);
                imageView.startAnimation(animFadeInOut);
                break;

            case R.id.btn_zoomin:
                animZoomIn.setDuration(seekSpeedprogress);
                imageView.startAnimation(animZoomIn);
                break;

            case R.id.btn_zoomout:
                animZoomOut.setDuration(seekSpeedprogress);
                imageView.startAnimation(animZoomOut);
                break;



            case R.id.btn_leftright:
                animLeftRight.setDuration(seekSpeedprogress);
                imageView.startAnimation(animLeftRight);
                break;

            case R.id.btn_rightleft:
                animRightLeft.setDuration(seekSpeedprogress);
                imageView.startAnimation(animRightLeft);
                break;

            case R.id.btn_topbottom:
                animTopBottom.setDuration(seekSpeedprogress);
                imageView.startAnimation(animTopBottom);
                break;

            case R.id.btn_bounce:
                animBounce.setDuration(seekSpeedprogress / 10);
                imageView.startAnimation(animBounce);
                break;

            case R.id.btn_flash:
                animFlash.setDuration(seekSpeedprogress / 10);
                imageView.startAnimation(animFlash);
                break;

            case R.id.btn_rotateleft:
                animRotateLeft.setDuration(seekSpeedprogress);
                imageView.startAnimation(animRotateLeft);
                break;

            case R.id.btn_rotateright:
                animRotateRight.setDuration(seekSpeedprogress);
                imageView.startAnimation(animRotateRight);
                break;
        }

    }
}
