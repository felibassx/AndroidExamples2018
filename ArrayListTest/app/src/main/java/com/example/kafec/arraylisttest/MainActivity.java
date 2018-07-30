package com.example.kafec.arraylisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaracion de un arraylist de enteros
        ArrayList<Integer> myList;

        //inicializacion del array list
        myList = new ArrayList<Integer>();

        myList.add(1);
        myList.add(2);


    }
}
