package com.example.kafec.randomtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();


        //De tipo Int
        int myRandomInt = randomGenerator.nextInt(10); //puede tomar cualquier valor

        //para obtener un número aleatorio entre 1 y 10...
        myRandomInt++;

        //de tipo long
        long myRandomLong = randomGenerator.nextLong();

        //Distribucion normal
        double myRandomDoubleGaussian = randomGenerator.nextGaussian();



    }
}
