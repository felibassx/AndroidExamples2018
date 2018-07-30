package com.example.kafec.arraytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] topScores = new int[100];
    String[] classNames;
    boolean arrayOfPass;
    float[] walletBalances;

    Note[] myNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classNames = new String[20];

        myNotes = new Note[30];

        topScores[0] = 7;
        topScores[1] = 10;

        //Array vidimencional
        String[][] countriesAndCities = new String[3][3];

        countriesAndCities[0][0] = "Chile";
        countriesAndCities[0][1] = "Santiago";
        countriesAndCities[0][2] = "Iquique";

        countriesAndCities[1][0] = "Francia";
        countriesAndCities[1][1] = "Paris";
        countriesAndCities[1][2] = "Lyon";

        countriesAndCities[2][0] = "USA";
        countriesAndCities[2][1] = "Washington";
        countriesAndCities[2][2] = "New York";

        String[] ChileanCitys = countriesAndCities[0];
    }
}
