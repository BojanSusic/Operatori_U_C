package com.example.operatori_u_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Poredjenje extends AppCompatActivity {
    public Button b;
    public Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poredjenje);
         b=(Button) findViewById(R.id.bb);
         a=(Button) findViewById(R.id.aa);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setEnabled(true);
            }
        });
    }
}
