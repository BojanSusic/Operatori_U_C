package com.example.operatori_u_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import org.w3c.dom.Text;

import java.util.Random;

public class BrojPrioriteta extends AppCompatActivity {
    public String [][]tablica={{","},{"=","+=","-=","*=","/=","%=","&=","^=","|=","<<=",">>="},{"?:"},{"||"},{"&&"},{"|"},{"^"},{"&"},{"==","!="},{"<","<=",">",">="},{"<<",">>"},{"+","-"},{"*","/","%"},{"!","~","++","--","&","(tip)","sizeof","+","-","*"},{"[ ]","( )",".","->"}};
    private Button nazad;
    private Button prvi;
    private Button drugi;
    private Button treci;
    private Button cetvrti;
    private Button peti;
    private Button sesti;
    private Button sedmi;
    private Button osmi;
    private Button deveti;
    private Button deseti;
    private Button jedanaesti;
    private Button dvanaesti;
    private Button trinaesti;
    private Button cetrnaesti;
    private Button petnaesti;
    private TextView Tacnih;
    private TextView Tacnonetacno;
    private int BrojPitanja;
    private TextView ukupno;
    private TextView Znak;
    private int tacnih=0;
    private int brojac=0;
    public void init() {
        nazad = (Button) findViewById(R.id.nazadbr);
        prvi =(Button) findViewById(R.id.prvi);
        drugi =(Button) findViewById(R.id.drugi);
        treci =(Button) findViewById(R.id.treci);
        cetvrti =(Button) findViewById(R.id.cetvrti);
        peti =(Button) findViewById(R.id.peti);
        sesti =(Button) findViewById(R.id.sesti);
        sedmi =(Button) findViewById(R.id.sedmi);
        osmi =(Button) findViewById(R.id.osmi);
        deveti =(Button) findViewById(R.id.deveti);
        deseti =(Button) findViewById(R.id.deseti);
        jedanaesti =(Button) findViewById(R.id.jedanaesti);
        dvanaesti=(Button) findViewById(R.id.dvanaesti);
        trinaesti =(Button) findViewById(R.id.trinaesti);
        cetrnaesti =(Button) findViewById(R.id.cetrnaesti);
        petnaesti =(Button) findViewById(R.id.petnaesti);
        ukupno=(TextView)findViewById(R.id.ukupno);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        prvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(1);
            }

        });
        drugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(2);
            }

        });
        treci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(3);
            }

        });
        cetvrti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(4);
            }

        });
        peti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(5);
            }

        });
        sesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(6);
            }

        });
        sedmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(7);
            }

        });
        osmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(8);
            }

        });
        deveti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(9);
            }

        });
        deseti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(10);
            }

        });
        jedanaesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(11);
            }

        });
        dvanaesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(12);
            }

        });
        trinaesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(13);
            }

        });
        cetrnaesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(14);
            }

        });
        petnaesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriTacnost(15);
            }

        });

    }
    private void povecajUkupno(){
                brojac++;
                ukupno.setText("UKUPNO: "+brojac);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broj_prioriteta);
        odaberiPitanje();
        init();
    }
    private void provjeriTacnost(int brojDugmica){
        if(brojDugmica==BrojPitanja+1){
            tacno();
        }
        else
            netacno();
    }
    private void  odaberiPitanje(){
        BrojPitanja=new Random().nextInt(15);
        int BrojZnaka;
        BrojZnaka=new Random().nextInt(tablica[BrojPitanja].length);
        Znak= (TextView) findViewById(R.id.znak);
        Znak.setText(tablica[BrojPitanja][BrojZnaka]);
    }
    private void tacno(){
        Tacnih=(TextView) findViewById(R.id.tacnih);
        tacnih++;
        new CountDownTimer(500, 1000) {
            public void onTick(long millisUntilFinished) {
                Tacnonetacno.setBackgroundColor(Color.parseColor("#00FF00"));
            }
            public void onFinish() {
                Tacnonetacno.setBackgroundColor(Color.parseColor("#545454"));
                odaberiPitanje();
                povecajUkupno();
            }
        }.start();
        Tacnonetacno=(TextView) findViewById(R.id.truefalse);
        Tacnih.setText("TACNIH: "+tacnih);
    }
    private void netacno(){
        new CountDownTimer(500, 1000) {
            public void onTick(long millisUntilFinished) {
                Tacnonetacno.setBackgroundColor(Color.parseColor("#FF0000"));
            }
            public void onFinish() {
                Tacnonetacno.setBackgroundColor(Color.parseColor("#545454"));
                odaberiPitanje();
                povecajUkupno();
            }
        }.start();
        Tacnonetacno=(TextView) findViewById(R.id.truefalse);
    }
}
