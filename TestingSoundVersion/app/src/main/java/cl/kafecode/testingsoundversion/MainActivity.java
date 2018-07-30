package cl.kafecode.testingsoundversion;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Clase SoundPool, permite manipular un pool de sonidos
    SoundPool sp;

    int nowPlaying = -1;
    int idFx1 = -1;
    int idFx2 = -1;
    int idFx3 = -1;

    float volume = .1f;
    int repeats = 2;

    private void loadPoolSound(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //Código para Lollypop o posterios
            //El nuevo modo de inicializar el soundpool es con AudioAttributes
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            //construir el soundpool
            sp = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(attr)
                    .build();


        }else{
            //Código para versiones anteriores a Lolmlypop
            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        try{
            AssetManager manager = this.getAssets();
            AssetFileDescriptor descriptor;

            //Cargamos en memoria el audio llamado fx1.ogg
            descriptor = manager.openFd("fx1.ogg");
            idFx1 = sp.load(descriptor, 0);

            descriptor = manager.openFd("fx2.ogg");
            idFx2 = sp.load(descriptor, 0);

            descriptor = manager.openFd("fx3.ogg");
            idFx3 = sp.load(descriptor, 0);

        }catch(IOException e){
            e.printStackTrace();
        }


        //Cargamos el seekbar y creamos una clase anonima para gestionar sus cambios
        SeekBar seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int valueSeekBar, boolean fromUser) {

                volume = valueSeekBar / 10.0f;
                sp.setVolume(nowPlaying, volume, volume);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Spinner
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = String.valueOf(spinner.getSelectedItem());
                repeats = Integer.valueOf(temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nada
            }
        });


    }

    private void loadUI(){
        Button btnFx1 = (Button)findViewById(R.id.btnFx1);
        btnFx1.setOnClickListener(this);

        Button btnFx2 = (Button)findViewById(R.id.btnFx2);
        btnFx2.setOnClickListener(this);

        Button btnFx3 = (Button)findViewById(R.id.btnFx3);
        btnFx3.setOnClickListener(this);

        Button btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadPoolSound();
        loadUI();

    }

    @Override
    public void onClick(View view) {
        //Reproducir un sonido
        int priorityOverOtherSounds = 0;
        int rateSpeed = 1;

        switch (view.getId()){
            case R.id.btnFx1:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFx1,volume,volume,priorityOverOtherSounds,repeats,rateSpeed);
                break;
            case R.id.btnFx2:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFx2,volume,volume,priorityOverOtherSounds,repeats,rateSpeed);
                break;
            case R.id.btnFx3:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFx3,volume,volume,priorityOverOtherSounds,repeats,rateSpeed);
                break;
            case R.id.btnStop:
                sp.stop(nowPlaying);
                break;
        }
    }
}
