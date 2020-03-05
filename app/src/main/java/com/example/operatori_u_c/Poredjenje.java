package com.example.operatori_u_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Poredjenje extends AppCompatActivity {
    public String [][]tablica={{","},{"=","+=","-=","*=","/=","%=","&=","^=","|=","<<=",">>="},{"?:"},{"||"},{"&&"},{"|"},{"^"},{"&"},{"==","!="},{"<","<=",">",">="},{"<<",">>"},{"+","-"},{"*","/","%"},{"!","~","++","--","&(adress)","(tip)","sizeof","+","-","*(pointer)"},{"[ ]","( )",".","->"}};
    private int lijevirnd;
    private int desnirnd;
    private TextView lijeviText;
    private TextView desniText;
    private TextView ukupno;
    private TextView tacno;
    private  int ukupnih=0;
    private int tacnoOdg=0;
    private  TextView obojiTacno;
    private Button []dugmici=new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poredjenje);
        dugmici[0]=(Button)findViewById(R.id.manje);
        dugmici[1]=(Button)findViewById(R.id.jednako);
        dugmici[2]=(Button)findViewById(R.id.vece);
        dugmici[3]=(Button)findViewById(R.id.nazadbr);
        kreiraj();
        for(int i=0;i<3;i++){
            final int finalI = i;
            dugmici[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                  tacnoNetacno(ispitaj(finalI));
                   kreiraj();
                }
            });

        }



        dugmici[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void kreiraj(){
        lijevirnd=new Random().nextInt(15);
        desnirnd=new Random().nextInt(15);
        lijeviText=(TextView)findViewById(R.id.lijevitext);
        desniText=(TextView)findViewById(R.id.desnitext);
        ukupno=(TextView)findViewById(R.id.ukupnop);
        lijeviText.setText(tablica[lijevirnd][new Random().nextInt(tablica[lijevirnd].length)]);
        desniText.setText(tablica[desnirnd][new Random().nextInt(tablica[desnirnd].length)]);
        ukupnih++;
        ukupno.setText("UKUPNO: "+ukupnih);
    }
    public boolean ispitaj(int broj){
        if(broj==0 && (lijevirnd<desnirnd)){
            tacnoOdg++;
            return true;
        }
        else if(broj==1 && (lijevirnd==desnirnd)){
            tacnoOdg++;
            return true;
        }
        else if(broj==2 && (lijevirnd>desnirnd)){
            tacnoOdg++;
            return true;
        }
        else
            return false;

    }
    public void tacnoNetacno(boolean odgovor){
        tacno=(TextView)findViewById(R.id.tacnihp);
        obojiTacno=(TextView)findViewById(R.id.obojiTacno);
        if(odgovor) {
            tacno.setText("TACNIH: " + tacnoOdg);
            new CountDownTimer(500, 1000) {
                public void onTick(long millisUntilFinished) {
                    obojiTacno.setText("TACNO");
                    obojiTacno.setBackgroundColor(Color.parseColor("#00FF00"));
                }

                public void onFinish() {
                    obojiTacno.setText("");
                    obojiTacno.setBackgroundColor(Color.parseColor("#545454"));

                }
            };

        }
        else new CountDownTimer(500, 1000) {
            public void onTick(long millisUntilFinished) {
                obojiTacno.setText("NETACNO");
                obojiTacno.setBackgroundColor(Color.parseColor("#880000"));
            }

            public void onFinish() {
                obojiTacno.setText("");
                obojiTacno.setBackgroundColor(Color.parseColor("#545454"));

            }
        };
    }
}
