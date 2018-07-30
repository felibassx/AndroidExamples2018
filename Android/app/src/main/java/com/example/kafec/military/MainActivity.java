package com.example.kafec.military;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Soldier mySoldier;
        mySoldier = new Soldier();

        mySoldier.health = 100;
        mySoldier.soldierType = "sniper";
        mySoldier.shootEnemy();


        Soldier mySoldier2;
        mySoldier2 = new Soldier();

        mySoldier2.health = 150;
        mySoldier2.soldierType = "special forces";
        mySoldier2.shootEnemy();



    }
}
