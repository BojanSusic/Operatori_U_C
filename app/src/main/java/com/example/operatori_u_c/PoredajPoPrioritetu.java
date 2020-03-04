package com.example.operatori_u_c;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PoredajPoPrioritetu extends AppCompatActivity {
    public String[][] tablica = {{","}, {"=", "+=", "-=", "*=", "/=", "%=", "&=", "^=", "|=", "<<=", ">>="}, {"?:"}, {"||"}, {"&&"}, {"|"}, {"^"}, {"&"}, {"==", "!="}, {"<", "<=", ">", ">="}, {"<<", ">>"}, {"+", "-"}, {"*", "/", "%"}, {"!", "~", "++", "--", "&(adress)", "(tip)", "sizeof", "+", "-", "*(pointer)"}, {"[ ]", "( )", ".", "->"}};
    private Button nazad;
    private List<Integer> odigranil;
    private List<Integer> odigranid;
    private int lijeviOdabrani;
    private int desniOdabrani;
   List<Button> lijeviDugmici = new ArrayList<Button>();
    List<Button> desniDugmici = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poredaj_po_prioritetu);
        odigranil=new ArrayList<Integer>();
        odigranid=new ArrayList<Integer>();
        lijeviDugmici.add((Button) findViewById(R.id.prvil));
        lijeviDugmici.add((Button) findViewById(R.id.drugil));
        lijeviDugmici.add((Button) findViewById(R.id.trecil));
        lijeviDugmici.add((Button) findViewById(R.id.cetvrtil));
        lijeviDugmici.add((Button) findViewById(R.id.petil));
        lijeviDugmici.add((Button) findViewById(R.id.sestil));
        lijeviDugmici.add((Button) findViewById(R.id.sedmil));
        lijeviDugmici.add((Button) findViewById(R.id.osmil));
        lijeviDugmici.add((Button) findViewById(R.id.devetil));
        lijeviDugmici.add((Button) findViewById(R.id.desetil));
        lijeviDugmici.add((Button) findViewById(R.id.jedanaestil));
        lijeviDugmici.add((Button) findViewById(R.id.dvanaestil));
        lijeviDugmici.add((Button) findViewById(R.id.trinaestil));

        desniDugmici.add((Button) findViewById(R.id.prvid));
        desniDugmici.add((Button) findViewById(R.id.drugid));
        desniDugmici.add((Button) findViewById(R.id.trecid));
        desniDugmici.add((Button) findViewById(R.id.cetvrtid));
        desniDugmici.add((Button) findViewById(R.id.petid));
        desniDugmici.add((Button) findViewById(R.id.sestid));
        desniDugmici.add((Button) findViewById(R.id.sedmid));
        desniDugmici.add((Button) findViewById(R.id.osmid));
        desniDugmici.add((Button) findViewById(R.id.devetid));
        desniDugmici.add((Button) findViewById(R.id.desetid));
        desniDugmici.add((Button) findViewById(R.id.jedanaestid));
        desniDugmici.add((Button) findViewById(R.id.dvanaestid));
        desniDugmici.add((Button) findViewById(R.id.trinaestid));
        nazad = (Button) findViewById(R.id.nazadbr);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for(int i=0;i<13;i++){
            final int finalI = i;
            lijeviDugmici.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    zabrani();
                    lijeviOdabrani= finalI;
                    odigranil.add(finalI);
                    lijeviDugmici.get(finalI).setBackgroundColor(100000000);
                }
            });
        }
        for(int i=0;i<13;i++){
            final int finalI = i;
            desniDugmici.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    odobri();
                    zabranidesne();
                    desniOdabrani=finalI;
                    desniDugmici.get(finalI).setEnabled(false);
                    odigranid.add(finalI);
                    oboji(provjeritacnost());
                }
            });

        }
       zabranidesne();
        kreiraj();
    }

    private void kreiraj() {
        List<Integer> brojevi = new ArrayList<Integer>();
        brojevi = odaberi(brojevi);
        int broj[] = new int[13];
        for (int i = 0; i < 13; i++) {
            lijeviDugmici.get(i).setText("" + brojevi.get(i).intValue());
        }
        Collections.shuffle(brojevi);
        for (int i = 0; i < 13; i++) {
            desniDugmici.get(i).setText("" + tablica[(brojevi.get(i).intValue()) - 1][new Random().nextInt(tablica[(brojevi.get(i).intValue()) - 1].length)]);
        }
    }

    private List<Integer> odaberi(List<Integer> brojevi) {
        Random random = new Random();
        while (brojevi.size() < 13) {
            int br = random.nextInt(16);
            if (!brojevi.contains(br) && br != 0) {
                brojevi.add(br);
            }
        }
        return brojevi;
    }

    public void zabrani(){
        for(int i=0;i<13;i++){
            lijeviDugmici.get(i).setEnabled(false);
        }
        for(int i=0;i<13;i++){
            if(!odigranid.contains(i))
            desniDugmici.get(i).setEnabled(true);
        }

    }
    public void odobri(){
        for(int i=0;i<13;i++){
            if(!odigranil.contains(i))
                lijeviDugmici.get(i).setEnabled(true);
        }

    }
    public void zabranidesne(){
        for(int i=0;i<13;i++){
            desniDugmici.get(i).setEnabled(false);
        }
    }
    public boolean provjeritacnost(){
        for(int i = 0; i<tablica[(Integer.parseInt((String) lijeviDugmici.get(lijeviOdabrani).getText()))-1].length; i++) {
            if (tablica[(Integer.parseInt((String) lijeviDugmici.get(lijeviOdabrani).getText())) - 1][i].compareTo(desniDugmici.get(desniOdabrani).getText().toString())==0) {
                return true;
            }
        }
        return false;
    }
    public void oboji(boolean tn){
        if(tn){
            lijeviDugmici.get(lijeviOdabrani).setBackgroundColor(Color.parseColor("#008800"));
            desniDugmici.get(desniOdabrani).setBackgroundColor(Color.parseColor("#008800"));
        }
        else{
            lijeviDugmici.get(lijeviOdabrani).setBackgroundColor(Color.parseColor("#880000"));
            desniDugmici.get(desniOdabrani).setBackgroundColor(Color.parseColor("#880000"));
        }

    }
}
