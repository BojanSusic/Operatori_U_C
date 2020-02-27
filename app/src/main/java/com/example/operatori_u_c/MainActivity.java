package com.example.operatori_u_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private  Button poredajPoPrioritetu;
    private  Button brojPrioriteta;
    private  Button poredjenje;
    private  Button tablicaPrioriteta;
    public String [][]tablica={{"[]","()",".","-&gt;"},{"!","~","++","--","&amp;","(tip)","sizeof","+","-","*"},{"*","/","%"},{"+","-"},{"&lt;&lt;","&gt;&gt;"},{"&lt;","&lt;=","&gt;","&gt;="},{"==","!="},{"&amp;"},{"^"},{"|"},{"&amp;&amp;"},{"||"},{"?:"},{"=","+=","-=","*=","/=","%=","&amp;=","^=","|=","&lt;&lt;=","&gt;&gt;="},{","}};

    public void init (){
        poredajPoPrioritetu = (Button) findViewById(R.id.poredaj_po_prioritetu);
        poredajPoPrioritetu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent poredajPoPrioritetuActivity = new Intent(MainActivity.this, PoredajPoPrioritetu.class);
                startActivity(poredajPoPrioritetuActivity);
            }
        });
        brojPrioriteta = (Button) findViewById(R.id.broj_prioriteta);
        brojPrioriteta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brojPrioritetaActivity = new Intent(MainActivity.this, BrojPrioriteta.class);
                startActivity(brojPrioritetaActivity);
            }
        });
        poredjenje = (Button) findViewById(R.id.poredjenje);
        poredjenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent poredjenjeActivity = new Intent(MainActivity.this, Poredjenje.class);
                startActivity(poredjenjeActivity);
            }
        });
        tablicaPrioriteta = (Button) findViewById(R.id.tablica);
        tablicaPrioriteta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tablicaActivity = new Intent(MainActivity.this, TablicaPrioriteta.class);
                startActivity(tablicaActivity);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
